package com.sport.sportproject.ui.activity_attention_team;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sport.sportproject.R;
import com.sport.sportproject.base.BaseFragment;
import com.sport.sportproject.base.BasePublicPresenter;
import com.sport.sportproject.bean.bean.team.FavTeamBean;
import com.sport.sportproject.interfaces.Params;
import com.sport.sportproject.ui.activity_main.MainActivity;
import com.sport.sportproject.utils.SharedPreferencesUtils;
import com.sport.sportproject.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;

/*
 *   梨花带雨,我见优伶  
 *      2019/4/19        
 */
public class Fragment_FavTeam extends BaseFragment<BasePublicPresenter, Fragment_FavTeam_Model> {
    private static final String FIRSI = "first";
    private static final String LISTBEANS = "listBeans";
    private static final String STRINGLIST = "stringlist";

    @BindView(R.id.favteam_rlv)
    RecyclerView mFavteamRlv;
    private Fragment_FavTeamAdapter fragment_favTeamAdapter;
    private ArrayList<FavTeamBean> listBeans;
    private ArrayList<String> select_teams;
    private boolean isCreate;
    private boolean isvisible;
    private ArrayList<String> strings = new ArrayList<>();
    ;
    private String team = "";

    public static Fragment_FavTeam go2Fragment(ArrayList<FavTeamBean> listBeans, ArrayList<String> stringslist) {
        Fragment_FavTeam fragment_favTeam = new Fragment_FavTeam();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(LISTBEANS, listBeans);
        bundle.putStringArrayList(STRINGLIST, stringslist);
        fragment_favTeam.setArguments(bundle);
        return fragment_favTeam;
    }

    @Override
    public void onSuccess(int type, Object[] objects) {
        switch (type) {
            case Params.REQUEST_TWO:
                CommitFavInfo favInfo = (CommitFavInfo) objects[0];
                if (favInfo.getMessage().equals("success")) {
                    SharedPreferencesUtils.setParam(FIRSI, "first");
                    Finish();
                } else {
                    ToastUtil.showShort("关注失败");
                }
                break;
        }
    }

    @Override
    public void onFaile(Throwable e) {

    }

    private void Finish() {
        startActivity(new Intent(getContext(), MainActivity.class));
        getActivity().finish();
        getActivity().overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }

    @Override
    protected Fragment_FavTeam_Model initModel() {
        return new Fragment_FavTeam_Model();
    }

    @Override
    protected BasePublicPresenter initPresenter() {
        return new BasePublicPresenter();
    }

    @Override
    protected void initListener() {
        final Main3Activity activity = (Main3Activity) getActivity();
        fragment_favTeamAdapter.setOnItemClickListener(new Fragment_FavTeamAdapter.OnItemClickListener() {

            @Override
            public void OnItemClick(View v, int position) {
                String id = listBeans.get(position).getId();
                if (select_teams != null) {
                    if (select_teams.contains(id)) {
                        select_teams.remove(id);
                    } else {
                        select_teams.add(id);
                    }
                } else {
                    if (strings.contains(id)) {
                        strings.remove(id);
                    } else {
                        strings.add(id);
                    }
                }

                if ((select_teams != null && select_teams.size() > 0) || (strings != null && strings.size() > 0)) {
                    activity.mTvAffirm.setBackgroundResource(R.drawable.guanzhu_btn_select_bg);
                } else {
                    activity.mTvAffirm.setBackgroundResource(R.drawable.guanzhu_btn_unselect_bg);
                }
                fragment_favTeamAdapter.notifyDataSetChanged();
            }
        });


        if ((select_teams != null && select_teams.size() > 0) || (strings != null && strings.size() > 0)) {
            activity.mTvAffirm.setBackgroundResource(R.drawable.guanzhu_btn_select_bg);
            activity.mTvAffirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (select_teams != null && select_teams.size() > 0) {
                        for (int i = 0; i < select_teams.size(); i++) {
                            team += select_teams.get(i) + ",";
                        }
                        mPresenter.getData(Params.REQUEST_TWO, team);
                    }
                    if (strings != null && strings.size() > 0) {
                        for (int i = 0; i < strings.size(); i++) {
                            team += select_teams.get(i) + ",";
                        }
                        mPresenter.getData(Params.REQUEST_TWO, team);
                    }
                }
            });
        }

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        select_teams = arguments.getStringArrayList(STRINGLIST);
        listBeans = arguments.getParcelableArrayList(LISTBEANS);
        if (listBeans.size() > 0 || listBeans != null && select_teams != null) {
            mFavteamRlv.setLayoutManager(new GridLayoutManager(getContext(), 4));
            fragment_favTeamAdapter = new Fragment_FavTeamAdapter(select_teams, listBeans, strings);
            mFavteamRlv.setAdapter(fragment_favTeamAdapter);
            fragment_favTeamAdapter.notifyDataSetChanged();
            isCreate = true;
        }
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_favteam;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            isvisible = isVisibleToUser;
            setvisible();
        } else {
            isvisible = isVisibleToUser;
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onDestroyView() {
        isvisible = false;
        isCreate = false;
        super.onDestroyView();
    }

    private void setvisible() {
        if (isvisible && isCreate) {
            fragment_favTeamAdapter.notifyDataSetChanged();
        }
    }


}
