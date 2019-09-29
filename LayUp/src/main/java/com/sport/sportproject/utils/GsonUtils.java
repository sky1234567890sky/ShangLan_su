package com.sport.sportproject.utils;

import com.google.gson.Gson;

public class GsonUtils {
    public static <T> T gsonStrToBean(String jsonStr, Class<T> tClass) {
        Gson gson = new Gson();
        T t = gson.fromJson(jsonStr, tClass);
        return t;
    }
    public static <T> String gsonBeanTostr(T t) {
        Gson gson = new Gson();
        String s = gson.toJson(t);
        return s;
    }

}
