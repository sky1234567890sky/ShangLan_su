package com.sport.sportproject.ui.fragment_circlezi.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.fragment_circlezi.adapter.CircleTopicAdapter;
import com.sport.sportproject.ui.fragment_circlezi.bean.CircleTopicBean;
import com.sport.sportproject.ui.fragment_circlezi.model.Fragment_CircleZi_Topic_Model;

import java.util.ArrayList;

import butterknife.BindView;

public class Fragment_CircleZi_Topic extends BaseFragment<BasePublicPresenter, Fragment_CircleZi_Topic_Model> implements PublicView {


    @BindView(R.id.rlv_topic)
    RecyclerView mRlvTopic;

    private ArrayList<CircleTopicBean.DataBean.TopicListBean> topicListBeans = new ArrayList<>();
    private CircleTopicAdapter circleTopicAdapter;

    /**
     *
     * @return Fragment_CircleZi_Topic
     */
    public static Fragment_CircleZi_Topic get2FragmentTopic() {
        Fragment_CircleZi_Topic circleZiTopic = new Fragment_CircleZi_Topic();
        return circleZiTopic;
    }

    /**
     *
     * @param type 区分
     * @param objects
     */
    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                if (objects[0] instanceof CircleTopicBean);
                CircleTopicBean circleTopicBean = (CircleTopicBean) objects[0];
                topicListBeans.addAll(circleTopicBean.getData().getTopic_list());
                circleTopicAdapter.notifyDataSetChanged();
                break;
        }
        loadingDialog.dismiss();
    }

    /**
     *
     * @param e
     */
    @Override
    public void onFaile(Throwable e) {

    }

    /**
     *
     * @return Fragment_CircleZi_Topic_Model
     */
    @Override
    protected Fragment_CircleZi_Topic_Model initModel() {
        return new Fragment_CircleZi_Topic_Model();
    }

    /**
     *
     * @return BasePublicPresenter
     */
    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        loadingDialog.show();
        mPresenter.getData(Params.REQUEST_ONE);
    }

    @Override
    protected void initView() {
        mRlvTopic.setLayoutManager(new LinearLayoutManager(getContext()));
        circleTopicAdapter = new CircleTopicAdapter(topicListBeans);
        mRlvTopic.setAdapter(circleTopicAdapter);
    }

    /**
     *
     * @return  Layout
     */
    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_circlezi_topic;
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }
}
