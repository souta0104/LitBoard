package com.lifeistech.android.litboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lifeistech.android.litboard.fragment.MessageTabFragment;
import com.lifeistech.android.litboard.fragment.SendTabFragment;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

    }
}