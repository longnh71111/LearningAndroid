package com.example.glideexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class GlideImageUtils {

    public static void loadImage(Context context, String imageUrl, ImageView imageView) {
        CircularProgressDrawable drawable = new CircularProgressDrawable(context);
        drawable.setColorSchemeColors(Color.BLUE);
        drawable.setCenterRadius(25f);
        drawable.setStrokeWidth(4f);
        // set all other properties as you would see fit and start it
        drawable.start();


        RequestOptions sharedOptions =
                new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(drawable);
        sharedOptions.transform(new CenterCrop(),
                new RoundedCornersTransformation(50, 0, RoundedCornersTransformation.CornerType.ALL));

//        Glide.with(this)
//                .load(imageUrl)
//                .apply(sharedOptions)
//                .into(imgTest);


        Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .apply(sharedOptions)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        imageView.setImageBitmap(resource);
//                        Observable.just(true).delay(2000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())
//                                .subscribeOn(Schedulers.io())
//
//                                .subscribe(new Observer<Boolean>() {
//                                    @Override
//                                    public void onSubscribe(Disposable d) {
//
//                                    }
//
//                                    @Override
//                                    public void onNext(Boolean aBoolean) {
//                                        imgTest.setImageBitmap(resource);
//                                    }
//
//                                    @Override
//                                    public void onError(Throwable e) {
//
//                                    }
//
//                                    @Override
//                                    public void onComplete() {
//
//                                    }
//                                });


                    }
                });
    }
}
