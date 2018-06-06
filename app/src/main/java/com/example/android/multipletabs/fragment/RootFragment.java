package com.example.android.multipletabs.fragment;

import android.support.v4.app.Fragment;

import com.example.android.multipletabs.BackPressImpl;
import com.example.android.multipletabs.OnBackPressListener;


/**
 * Created by shahabuddin on 6/6/14.
 */
public class RootFragment extends Fragment implements OnBackPressListener {

    @Override
    public boolean onBackPressed() {
        return new BackPressImpl(this).onBackPressed();
    }
}
