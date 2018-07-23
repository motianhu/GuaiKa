package com.smona.app.guaika.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.smona.app.guaika.R;
import com.smona.app.guaika.home.factory.FragmentFactory;
import com.smona.app.guaika.common.fragment.BaseFragment;
import com.smona.app.guaika.common.fragment.NameFragment;
import com.smona.app.guaika.util.UIUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements  View.OnClickListener {

    @BindView(R.id.setting)
    View mSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mSetting.setOnClickListener(this);
        init();
    }

    private void init() {
        BaseFragment fragment = FragmentFactory.createTabFragment();
        switchFragment(fragment);
    }

    private void switchFragment(Fragment fragment) {
        setTitle(((NameFragment) fragment).getName());
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_main, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.setting) {
            gotoSettings();
        }
    }

    private void gotoSettings() {
        UIUtil.gotoSetting(this);
    }
}
