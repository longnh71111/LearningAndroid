package com.example.recyclerviewhelperexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.recyclerviewhelperexample.adapter.NormalRvAdapter;

import com.example.recyclerviewhelperexample.model.Status;
import com.example.recyclerviewhelperexample.utils.DataServer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}