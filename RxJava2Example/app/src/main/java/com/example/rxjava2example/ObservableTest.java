package com.example.rxjava2example;

import android.util.Log;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;

public class ObservableTest {
    static int[] total = new int[2];

    public static void customSubscriber() {
        Observable<String> observable;
//        observable =  Observable.just("a", "b", "c");
                observable = Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@androidx.annotation.NonNull ObservableEmitter<String> e) throws Exception {
                        e.onNext("1");
                        e.onNext("3");
                        e.onNext("4");
                        e.onComplete();
                    }
                });


        observable.subscribe(new Consumer<String>() {
            @Override
            public void accept(@androidx.annotation.NonNull String s) throws Exception {
                Log.d("testing", s);
            }
        });
    }


    public static void test2() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@androidx.annotation.NonNull ObservableEmitter<String> e) throws Exception {
//                Log.d("testing", Thread.currentThread().getName());
                e.onNext("1");
                e.onNext("2");
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .map(new Function<String, Integer>() {
            @androidx.annotation.NonNull
            @Override
            public Integer apply(@androidx.annotation.NonNull String s) throws Exception {
                Log.d("testing", Thread.currentThread().getName());
                return s.length();
            }
        }).observeOn(Schedulers.newThread()).map(new Function<Integer, String>() {
            @androidx.annotation.NonNull
            @Override
            public String apply(@androidx.annotation.NonNull Integer integer) throws Exception {
                Log.d("testing", Thread.currentThread().getName());
                return integer.toString();
            }
        }).observeOn(Schedulers.io()).subscribe(new Consumer<String>() {
            @Override
            public void accept(@androidx.annotation.NonNull String s) throws Exception {
                Log.d("testing", Thread.currentThread().getName());
            }
        });
    }

    public static void operatorFlatmap() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@androidx.annotation.NonNull ObservableEmitter<String> e) throws Exception {
//                Log.d("testing", Thread.currentThread().getName());
                e.onNext("1");
                e.onNext("2");
            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @androidx.annotation.NonNull
                    @Override
                    public ObservableSource<String> apply(@androidx.annotation.NonNull String s) throws Exception {
                        return Observable.just("1", "2");
                    }
                }).observeOn(Schedulers.newThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public static void testBackPressure() {
        total[0] = 0;
        Observable<Integer> observable = Observable.range(1, 50000);
        observable.subscribe(new Consumer<Integer>() {
            @Override
            public void accept(@NonNull Integer integer) throws Exception {
                total[0] = total[0] + integer;
                Log.d("testing", integer+"");
            }
        });
        Log.d("testing", total[0] + "");
    }


    public static void testMapAndFlatMap(TextView textView) {

        Observable.just("a", "bb", "ccc").delay(2, TimeUnit.SECONDS)
                .observeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
//                Log.d("testing", Thread.currentThread().getName());
                    }
                }).observeOn(Schedulers.newThread()).map(new Function<String, Integer>() {
            @androidx.annotation.NonNull
            @Override
            public Integer apply(@androidx.annotation.NonNull String s) throws Exception {
                Log.d("testing", Thread.currentThread().getName() + ": " + s);
                return s.length();
            }
        }).observeOn(Schedulers.io()).map(new Function<Integer, ObservableSource<Integer>>() {
            @androidx.annotation.NonNull
            @Override
            public ObservableSource<Integer> apply(@androidx.annotation.NonNull Integer integer) throws Exception {
                Log.d("testing", Thread.currentThread().getName() + ": " + integer);
                return Observable.just(integer);
            }
        }).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ObservableSource<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(ObservableSource<Integer> integerObservableSource) {
                Log.d("testing", Thread.currentThread().getName() + "on Next: " + integerObservableSource.toString());
                textView.setText(integerObservableSource.toString() + "");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public static void operatorMerge(TextView textView) {
        Observable<String> observable1 = Observable.just("a", "b").delay(1, TimeUnit.SECONDS);
        Observable<Integer> observable2 = Observable.just(1, 2).delay(1, TimeUnit.SECONDS);
        Observable<Student> observable3 = Observable.just(new Student("HanHee"), new Student("Long Nguyen")).delay(2, TimeUnit.SECONDS);

        Observable.merge(observable1, observable2, observable3).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Serializable>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Serializable serializable) {
                        if (serializable.getClass().isAssignableFrom(Student.class)) {
                            Log.d("testing", ((Student) serializable).getName());
                            textView.setText(((Student) serializable).getName());
                        }
                        if (serializable.getClass().isAssignableFrom(String.class)) {
                            Log.d("testing", (String) serializable);
                        }
                        if (serializable.getClass().isAssignableFrom(Integer.class)) {
                            Log.d("testing", serializable+"");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public static void operatorThrottleFirst() {
        Observable<String> observable;
        observable =  Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@androidx.annotation.NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("1");
                Thread.sleep(3100);
                e.onNext("2");
                e.onNext("3");
            }
        });
        observable.throttleFirst(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("testing", s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
//                        Log.d("testing", Calendar.getInstance().getTimeInMillis()+"");
                    }
                });
    }
}
