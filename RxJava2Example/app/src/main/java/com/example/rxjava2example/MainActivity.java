package com.example.rxjava2example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    int[] total = {0};
    private TextView txtHelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

//        ObservableTest.customSubscriber();
//        ObservableTest.test2();
//       ObservableTest.testBackPressure();
        ObservableTest.operatorMerge(txtHelloWorld);
        txtHelloWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObservableTest.operatorThrottleFirst();
            }
        });

//        --------------------

    }

    public void testSingle() {
        Single.just("a").subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull String s) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }

    public void testCompletable() {

        Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter e) throws Exception {
                e.onComplete();
            }
        }).delay(1, TimeUnit.SECONDS).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                Log.d("testing", "onComplete");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }

    private void initView() {
        txtHelloWorld = findViewById(R.id.txtHelloWorld);
    }
}