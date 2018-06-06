package com.example.android.multipletabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by shahabuddin on 6/6/14.
 */
public class BackPressImpl implements OnBackPressListener {

    private Fragment parentFragment;

    public BackPressImpl(Fragment parentFragment) {
        this.parentFragment = parentFragment;
    }

    @Override
    public boolean onBackPressed() {

        if (parentFragment == null) return false;

        int childCount = parentFragment.getChildFragmentManager().getBackStackEntryCount();

        if (childCount == 0) {
            // it has no child Fragment
            // can not handle the onBackPressed task by itself
            return false;

        } else {
            FragmentManager childFragmentManager = parentFragment.getChildFragmentManager();
            OnBackPressListener childFragment = (OnBackPressListener) childFragmentManager.getFragments().get(0);

            if (!childFragment.onBackPressed()) {
                childFragmentManager.popBackStackImmediate();
            }
            return true;
        }
    }
}
