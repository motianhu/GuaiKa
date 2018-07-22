package com.smona.app.guaika.activity;

import android.os.Bundle;

import com.smona.app.guaika.R;

import butterknife.ButterKnife;

public class VideoActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }
}
