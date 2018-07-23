package com.smona.app.guaika.util;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.smona.app.guaika.activity.CategoryActivity;
import com.smona.app.guaika.activity.SettingActivity;
import com.smona.app.guaika.activity.VideoActivity;

public class UIUtil {

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

    public static void gotoSetting(Context context) {
        gotoActivity(context, SettingActivity.class);
    }

    public static void gotoCategory(Context context) {
        gotoActivity(context, CategoryActivity.class);
    }

    public static void gotoVideo(Context context) {
        gotoActivity(context, VideoActivity.class);
    }

    private static void gotoActivity(Context context, Class clazz) {
        Intent intent = new Intent();
        intent.setClass(context, clazz);
        context.startActivity(intent);
    }
}
