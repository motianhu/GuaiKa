package com.smona.app.guaika.util;

import android.content.Context;
import android.widget.Toast;

public class UIUtil {

    public static void showToast(Context context, String msg) {

        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(Context context, int resId) {

        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }
}
