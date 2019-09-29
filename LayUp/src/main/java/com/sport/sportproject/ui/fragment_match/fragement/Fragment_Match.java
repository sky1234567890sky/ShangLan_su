package com.sport.sportproject.ui.fragment_match.fragement;
import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePresenter;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.base.PublicView;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.fragment_match.MatchMaxmumInterface;
import com.sport.sportproject.ui.fragment_match.adapter.MatchMaxmumApapter;
import com.sport.sportproject.ui.fragment_match.model.Fragment_Match_Tab_Model;
import com.sport.sportproject.utils.LoadingDialog;
import com.sport.sportproject.utils.ToastUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//比赛页面
public class Fragment_Match extends BaseFragment<BasePublicPresenter,Fragment_Match_Tab_Model> implements PublicView {
//    @BindView(R.id.match_smartTab)
//    TabLayout mMatchSmartTab;
    @BindView(R.id.match_smartTab)
    SmartTabLayout mMatchSmartTab;

    @BindView(R.id.match_viewpage)
    ViewPager mMatchViewpage;

    private MatchMaxmumApapter matchMaxmumApapter;
    private ArrayList<MatchMaxmumInterface.LiveTabsBean> listBeans = new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();
    @Override
    protected void initData() {
        //数据
//        initMatchMaxData();
//        initMatchData();
        loadingDialog.show();
        mPresenter.getData(Params.REQUEST_ONE);
    }
    @Override
    protected void initView() {

    }
    //https://bkbapi.dqdgame.com/data/tab/matchs/max/person?match_ids=[11528,11532,11579,11596,11607,11608,11609,11610,11619,11620
    //TODO:比赛Fragment
    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_match;
    }
    String startData = "http://sport-data.dqdgame.com/sd/biz/index";

    //数据源
    //private void initMatchMaxData() {
    private void AddFragment(MatchMaxmumInterface matchMaxmumInterface) {
        List<MatchMaxmumInterface.LiveTabsBean> live_tabs = matchMaxmumInterface.getLive_tabs();
        for (int i = 0; i < live_tabs.size(); i++) {
            ImportantFragment importantFragment =new  ImportantFragment(live_tabs.get(i).getLabel(), live_tabs.get(i).getType(),live_tabs.get(i).getApi());
            fragments.add(importantFragment);
        }
        //创建并绑定适配器
        matchMaxmumApapter = new MatchMaxmumApapter(getChildFragmentManager(),fragments, live_tabs);
        mMatchViewpage.setAdapter(matchMaxmumApapter);
        mMatchSmartTab.setViewPager(mMatchViewpage);
        mMatchViewpage.setCurrentItem(1);
        matchMaxmumApapter.notifyDataSetChanged();
    }

    @Override
    protected void initListener(){
        mMatchSmartTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                TextView tabAt = (TextView) mMatchSmartTab.getTabAt(position);
                tabAt.setTextColor(getContext().getResources().getColor(R.color.c_e34536));

                tabAt.setTextSize(14);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    tabAt.setTextAppearance(R.style.tab_text_style);
                }
                for (int i = 0; i < listBeans.size(); i++) {
                    if (i == position) {
                        continue;
                    } else {
                        TextView tabAt1 = (TextView) mMatchSmartTab.getTabAt(i);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            tabAt1.setTextAppearance(R.style.tab_text_style);
                        }
                        tabAt1.setTextColor(getContext().getResources().getColor(R.color.c_000));
                        tabAt1.setTextSize(12);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @Override
    protected Fragment_Match_Tab_Model initModel() {
        return new Fragment_Match_Tab_Model();
    }

    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }

    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_ONE:
                MatchMaxmumInterface mat_tab = (MatchMaxmumInterface) objects[0];
                Log.i("tag", "圈子数据: "+mat_tab.toString());
                AddFragment(mat_tab);
                break;
        }
        loadingDialog.dismiss();
    }
    @Override
    public void onFaile(Throwable e) {
        ToastUtil.showShort(e.getMessage());
    }
//    public static void setTabWidth(final TabLayout tabLayout, final int padding){
//        tabLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    //拿到tabLayout的mTabStrip属性
//                    LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);
//                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
//                        View tabView = mTabStrip.getChildAt(i);
//                        //拿到tabView的mTextView属性  tab的字数不固定一定用反射取mTextView
//                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
//                        mTextViewField.setAccessible(true);
//
//                        TextView mTextView = (TextView) mTextViewField.get(tabView);
//
//                        tabView.setPadding(0, 0, 0, 0);
//
//                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
//                        int width = 0;
//                        width = mTextView.getWidth();
//                        if (width == 0) {
//                            mTextView.measure(0, 0);
//                            width = mTextView.getMeasuredWidth();
//                        }
//
//                        //设置tab左右间距 注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
//                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
//                        params.width = width ;
//                        params.leftMargin = padding;
//                        params.rightMargin = padding;
//                        tabView.setLayoutParams(params);
//
//                        tabView.invalidate();
//                    }
//
//                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//    }

}
