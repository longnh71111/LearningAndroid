package com.example.glideexample;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.tbruyelle.rxpermissions2.RxPermissions;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MainActivity extends AppCompatActivity {

    String imageUrl = "https://getdrive.net/wp-content/uploads/2020/03/Mau-background-powerpoint-giao-duc.jpg";
    @BindView(R.id.imgTest)
    ImageView imgTest;
    @BindView(R.id.imgTest2)
    ImageView imgTest2;
    @BindView(R.id.imgTest3)
    ImageView imgTest3;

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final RxPermissions rxPermissions = new RxPermissions(this);

        rxPermissions
                .request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) { // Always true pre-M
                        // I can control the camera now
                        Log.d("testing", "granted");
                    } else {
                        Log.d("testing", "denied");
                        // Oups permission denied
                    }
                });

        GlideImageUtils.loadImage(this, imageUrl, imgTest);
        GlideImageUtils.loadImage(this, imageUrl, imgTest2);
    }

    @OnClick({R.id.imgTest, R.id.imgTest2, R.id.imgTest3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgTest:

                break;
            case R.id.imgTest2:
                break;
            case R.id.imgTest3:
                break;
        }
    }
}