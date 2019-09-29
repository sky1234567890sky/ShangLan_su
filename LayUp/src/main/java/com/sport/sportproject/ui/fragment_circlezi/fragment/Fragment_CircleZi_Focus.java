package com.sport.sportproject.ui.fragment_circlezi.fragment;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePresenter;
import com.sport.sportproject.ui.fragment_match.net.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 圈子焦点重点
 */
public class Fragment_CircleZi_Focus extends BaseFragment {
    @BindView(R.id.iv)
    ImageView mIv;
    private AnimationDrawable drawable;
    /**
     * @return Fragment_CircleZi_Focus
     */
    public static Fragment_CircleZi_Focus get2FragmentFocus() {
        Fragment_CircleZi_Focus circleZi_focus = new Fragment_CircleZi_Focus();
        return circleZi_focus;
    }
    /**
     * @param type 区分
     * @param objects
     */
    @Override
    public void onSuccess(int type, Object[] objects) {
    }
    /**
     * @param e
     */
    @Override
    public void onFaile(Throwable e) {
        ToastUtil.showLong(e.getMessage());
    }
    /**
     * @return Model
     */
    @Override
    protected Object initModel() {
        return null;
    }
    /**
     * @return Presenter
     */
    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
    /**
     *  InitListener
     */
    @Override
    protected void initListener() {

    }
    /**
     *  InitData
     */
    @Override
    protected void initData() {

    }
    /**
     *   InitView
     */
    @Override
    protected void initView() {

    }
    /**
     * @return Layout
     */
    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_circlezi_focus;
    }
    @Override
    public void onResume() {
        super.onResume();
        drawable = (AnimationDrawable) mIv.getDrawable();
        if (drawable != null) {
            drawable.start();
        }
    }
    @Override
    public void onPause() {
        super.onPause();
    }
    @Override
    public void onStop() {
        super.onStop();
        drawable.stop();
    }

    /**
     * @param v
     */

    @OnClick(R.id.iv)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv:
                if (drawable.isRunning()) drawable.stop();
                else drawable.start();
                break;
        }
    }
}
