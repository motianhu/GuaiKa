package com.smona.app.guaika.home.factory;

import android.os.Bundle;
import android.util.Log;

import com.smona.app.guaika.category.fragment.CategoryFragment;
import com.smona.app.guaika.main.bean.TabData;
import com.smona.app.guaika.common.fragment.BaseFragment;
import com.smona.app.guaika.home.fragment.HomeFragment;
import com.smona.app.guaika.main.fragment.TabFragment;
import com.smona.app.guaika.main.http.DataType;
import com.smona.app.guaika.more.fragment.MoreFragment;
import com.smona.app.guaika.video.fragment.RecommendFragment;

public class FragmentFactory {
    public static final String KEY_BUNDLE_TAB_ITEM = "tab_item";

    public static BaseFragment createTabFragment() {
        return new TabFragment();
    }

    public static BaseFragment createFragment(TabData tabItem) {
        BaseFragment fragment = null;
        DataType type = tabItem.getType();
        switch (type) {
            case HOME:
                fragment = new HomeFragment();
                break;
            case CATEGORY:
                fragment = new CategoryFragment();
                break;
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_BUNDLE_TAB_ITEM, tabItem);
        if (fragment != null) {
            fragment.setArguments(bundle);
        }

        return fragment;
    }

    public static BaseFragment createCategoryFragment() {
        BaseFragment fragment = new MoreFragment();
        Bundle bundle = new Bundle();
        if (fragment != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    public static BaseFragment createRecomendFragment() {
        BaseFragment fragment = new RecommendFragment();
        Bundle bundle = new Bundle();
        if (fragment != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }
}
