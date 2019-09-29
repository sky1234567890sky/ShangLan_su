package com.sport.sportproject.JSCallback;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sport.sportproject.R;
import com.sport.sportproject.ui.WebViewActivity;

import java.util.List;

/**
 * Created by 华为 on 2019/7/22.
 */

public class PopWebViewPager extends PagerAdapter {
    private final List<String> list;
    private Context context;

    public PopWebViewPager(List<String> list) {

        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        context = container.getContext();
        String s = list.get(position);
        View view = View.inflate(context, R.layout.viewpage_item_imageview2,null);
        ImageView img = view.findViewById(R.id.img_content);
        Glide.with(context).load(list.get(position)).into(img);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
