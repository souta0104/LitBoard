package com.lifeistech.android.litboard.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lifeistech.android.litboard.R;

/**
 * Created by Soutahagiwara on 2018/02/10.
 */

public class SendTabFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_send, container, false);
    }

}
