package com.sport.sportproject.utils;

/**
 * Created by 华为 on 2019/7/26.
 */

import android.graphics.Bitmap;
import android.graphics.Matrix;

import java.io.ByteArrayOutputStream;

/**
 * 压缩图片的工具类
 */
public class BitmapOption {
    private static final BitmapOption bitmapOption= new BitmapOption();

    public BitmapOption() {
    }

    public static BitmapOption getBitmapOption() {
        return bitmapOption;
    }

    public static Bitmap bitmapOption(Bitmap image, int size) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 85, out);
        float zoom = (float) Math.sqrt(size * 1024 / (float) out.toByteArray().length);
        Matrix matrix = new Matrix();
        matrix.setScale(zoom, zoom);
        Bitmap result = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
        out.reset();
        result.compress(Bitmap.CompressFormat.JPEG, 85, out);
        while (out.toByteArray().length > size * 1024) {
            System.out.println(out.toByteArray().length);
            matrix.setScale(0.9f, 0.9f);
            result = Bitmap.createBitmap(result, 0, 0, result.getWidth(), result.getHeight(), matrix, true);
            out.reset();
            result.compress(Bitmap.CompressFormat.JPEG, 85, out);
        }
        return result;
    }
}
