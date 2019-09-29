package com.sport.sportproject.JSCallback;

import java.util.List;

/**
 * Created by 华为 on 2019/7/22.
 */

public class PopVp {
    private List<String> mImageList;
    private int index;

    public PopVp() {

    }

    public PopVp(List<String> mImageList, int index) {
        this.mImageList = mImageList;
        this.index = index;
    }

    public List<String> getmImageList() {
        return mImageList;
    }

    public void setmImageList(List<String> mImageList) {
        this.mImageList = mImageList;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "PopVp{" +
                "mImageList=" + mImageList +
                ", index=" + index +
                '}';
    }
}
