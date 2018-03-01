package com.lifeistech.android.litboard;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stephentuso.welcome.BasicPage;
import com.stephentuso.welcome.TitlePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;
import com.stephentuso.welcome.WelcomeHelper;

public class TutorialActivity extends WelcomeActivity {

    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)
                .defaultBackgroundColor(R.color.colorPrimaryDark)
                .page(new TitlePage(R.drawable.saru,
                        "Title")
                )
                .page(new BasicPage(R.drawable.saru,
                        "Header",
                        "More text.")
                        .background(R.color.colorAccent)
                )
                .page(new BasicPage(R.drawable.saru,
                        "Lorem ipsum",
                        "dolor sit amet.")
                )
                .swipeToDismiss(true)
                .build();
    }
}