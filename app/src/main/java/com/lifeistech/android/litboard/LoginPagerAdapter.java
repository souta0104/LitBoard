package com.lifeistech.android.litboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.google.firebase.auth.FirebaseAuth;
import com.lifeistech.android.litboard.fragment.LoginUnderFragment;
import com.lifeistech.android.litboard.fragment.NameSetLoginFragment;

/**
 * Created by Soutahagiwara on 2018/03/09.
 */

public class LoginPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_NUM = 3;

    public LoginPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new LoginUnderFragment();
                break;
            default:
                fragment = new NameSetLoginFragment();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_NUM;
    }
}
