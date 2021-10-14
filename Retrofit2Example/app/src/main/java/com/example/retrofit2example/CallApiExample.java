package com.example.retrofit2example;

import android.net.Uri;
import android.os.Build;

import java.io.File;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class CallApiExample {

    //TODO: LocalMedia là model nằm trong thư viện PictureSelector, link Repo: https://github.com/LuckSiege/PictureSelector


    private void uploadContent() {
//        MultipartBody.Builder builder = new MultipartBody.Builder();
//        builder.setType(MultipartBody.FORM);
//        for (int i = 0; i < listAdapter.size(); i++) {
//            NewPostImageDetail item = listAdapter.get(i);
//            if (!item.isFromServer()) {
//                Uri imageUri = Uri.parse(Build.VERSION.SDK_INT >= 29 ? item.getLocalMedia().getAndroidQToPath() : item.getLocalMedia().getPath());
//                File file = new File(imageUri.getPath());
//                RequestBody requestBody = RequestBody.create(MediaType.parse(URLConnection.guessContentTypeFromName(file.getAbsolutePath())), file);
//                builder.addFormDataPart("files", file.getName(), requestBody);
//            }
//        }
//        if (edtContent.getText().toString().trim().length() > 0)
//            builder.addFormDataPart("description", edtContent.getText().toString().trim());
//        if (type.equals("edit")) {
//            String pageOrderString = getIndexToEdit();
//            builder.addFormDataPart("pagesOrder", pageOrderString);
//        }
//        MultipartBody multipartBody = builder.build();
//        Map<String, Object> headers = new HashMap<>();
//        if (type.equals("edit")) {
//            viewModel.loadEditFunComic(targetId, multipartBody, headers);
//        } else if (type.equals("new")) {
//            viewModel.loadUploadFunComic(multipartBody, headers);
//        }
    }
}
