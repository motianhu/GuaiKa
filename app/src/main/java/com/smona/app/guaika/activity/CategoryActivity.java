package com.smona.app.guaika.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;


import com.smona.app.guaika.R;
import com.smona.app.guaika.common.fragment.BaseFragment;
import com.smona.app.guaika.common.fragment.NameFragment;
import com.smona.app.guaika.home.factory.FragmentFactory;
import butterknife.ButterKnife;

public class CategoryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        BaseFragment fragment = FragmentFactory.createCategoryFragment();
        switchFragment(fragment);
    }

    private void switchFragment(Fragment fragment) {
        setTitle(((NameFragment) fragment).getName());
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment);
        fragmentTransaction.commit();
    }
}
