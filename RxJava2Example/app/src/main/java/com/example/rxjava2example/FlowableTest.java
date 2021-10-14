package com.example.rxjava2example;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.subscribers.DefaultSubscriber;
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
import io.reactivex.schedulers.Schedulers;


public class FlowableTest {
    static int[] total;

    public static void testBackPressure() {
        total[0] = 0;
        Flowable<Integer> flowable = Flowable.range(1, 50000);
        flowable.subscribe(s ->
                total[0] = total[0] + s
        );
        Log.d("testing", total[0] + "");

        total[0] = 0;
        Flowable<Integer> flowable2 = Flowable.range(1, 10000).sample(1, TimeUnit.MILLISECONDS);
        flowable2.subscribe(new DefaultSubscriber<Integer>() {
            @Override
            public void onStart() {
                request(1);
            }

            @Override
            public void onNext(Integer t) {
//                Log.d( "testing", "value after every 1 milis secs "+t);
                total[0] = total[0] + t;
                request(1);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });

        Log.d("testing", total[0] + "");
    }

    public static void parallelFlowable() {
        ParallelFlowable<Integer> parallelFlowable = Flowable.range(1, 100).parallel();

        parallelFlowable
                .runOn(Schedulers.io())
                .map(new Function<Integer, String>() {

                    @Override
                    public String apply(@NonNull Integer integer) throws Exception {
                        return integer.toString();
                    }
                })
                .sequential()
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@androidx.annotation.NonNull String s) throws Exception {
                        Log.d("testing", s.toString());
                    }
                });
    }
}
