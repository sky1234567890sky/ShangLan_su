package com.sport.sportproject.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 华为 on 2019/8/2.
 */
//加载进度条有关类
public class FontUtil {
    public static void replaceFont( View root, String fontPath) {
        if (root == null || TextUtils.isEmpty(fontPath)) {
            return;
        }
        if (root instanceof TextView) {
            TextView textView = (TextView) root;
            int style = Typeface.NORMAL;
            if (textView.getTypeface() != null) {
                style = textView.getTypeface().getStyle();
            }
            textView.setTypeface(createTypeface(root.getContext(), fontPath), style);
        } else if (root instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) root;
            for (int i = 0; i < viewGroup.getChildCount(); ++i) {
                replaceFont(viewGroup.getChildAt(i), fontPath);
            }
        }
    }

    public static void replaceFont(Activity context, String fontPath) {
        replaceFont(getRootView(context), fontPath);
    }

    public static Typeface createTypeface(Context context, String fontPath) {
        return Typeface.createFromAsset(context.getAssets(), fontPath);
    }

    public static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }
}
