package com.example.rxbindingexample;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.jakewharton.rxbinding4.recyclerview.RxRecyclerView;
import com.jakewharton.rxbinding4.recyclerview.RxRecyclerViewAdapter;
import com.jakewharton.rxbinding4.view.RxView;

import com.jakewharton.rxbinding4.widget.RxTextView;
import com.jakewharton.rxbinding4.widget.TextViewTextChangeEvent;
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import kotlin.Unit;

public class MainActivity extends RxAppCompatActivity {

    @BindView(R.id.edtCurrentPass)
    EditText edtCurrentPass;
    @BindView(R.id.ivTest)
    ImageView ivTest;
    @BindView(R.id.edtUsername)
    EditText edtUsername;
    @BindView(R.id.btnChangeActivity)
    TextView btnChangeActivity;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        edtCurrentPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("testing", "text Change: " + charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        RxView.clicks(ivTest)
                .delay(2000, TimeUnit.MILLISECONDS)
                .compose(bindToLifecycle())
                .debounce(2, TimeUnit.SECONDS)
//                .throttleFirst(2, TimeUnit.SECONDS)
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d("testing", "complete");
                    }
                })
                .subscribe(new Observer<Unit>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Unit unit) {
                        Log.d("testing", "onClick");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("testing", "onComplete");
                    }
                });


        RxView.clicks(btnChangeActivity)
//                .compose(bindToLifecycle())
//                .throttleFirst(5, TimeUnit.SECONDS)

                .subscribe(new Observer<Unit>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Unit unit) {
                        finish();
                        Intent intent = new Intent(MainActivity.this, TestActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("testing", "onComplete");
                    }
                });

        RxView.focusChanges(edtCurrentPass)
                .compose(bindToLifecycle())

                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        if (edtCurrentPass.getText().length() > 0) {
                            ivTest.setVisibility(View.VISIBLE);
                        } else {
                            ivTest.setVisibility(View.GONE);
                        }
                    } else {
                        ivTest.setVisibility(View.GONE);
                    }

                });

        RxTextView.textChangeEvents(edtUsername)
                .compose(bindToLifecycle())
                .throttleLast(2, TimeUnit.SECONDS)
                .subscribe(new Observer<TextViewTextChangeEvent>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull TextViewTextChangeEvent textViewTextChangeEvent) {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                Log.d("testing: ", textViewTextChangeEvent.getText().toString());
                                edtCurrentPass.setText("");
                                if (textViewTextChangeEvent.getCount() > 0) {
                                    ivTest.setVisibility(View.VISIBLE);
                                } else {
                                    ivTest.setVisibility(View.GONE);
                                }

                            }
                        });

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


}