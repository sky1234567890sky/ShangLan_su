package com.sport.sportproject.ui.fragment_match.net;

/**
 * Created by $lzj on 2019/5/17.
 */
public interface TouchCallBack {

    //上下拖动，实现数据位置交换，刷新局部位置
    void onItemMove(int fromPosition, int toPosition);

    //向左滑动，实现数据删除，刷新局部页面
    void onItemDelete(int position);
}
