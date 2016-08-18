package com.show.series.httpnetwork.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.gson.Gson;
import com.show.series.httpnetwork.R;
import com.show.series.httpnetwork.model.HomeModel;
import com.show.series.httpnetwork.utils.OkHttpUtils;
import com.show.series.httpnetwork.utils.callback.ResultCallback;
import com.show.series.httpnetwork.view.UrlContants;

import okhttp3.Call;

/**
 * Created by lihf on 16/8/12.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private PopupWindow popupWindow;
    private ImageButton menu_btn;

    private LinearLayout layout_title_frame;

    public static HomeFragment newInstance(String title) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        menu_btn = (ImageButton) view.findViewById(R.id.menu_btn);
        layout_title_frame = (LinearLayout) view.findViewById(R.id.layout_title_frame);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initMenu();
        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAsDropDown(layout_title_frame);
            }
        });
        loadData();
    }

    public void loadData() {
        String url = UrlContants.URL_HOME_INDEX + "&token=" + UrlContants.tokenTest;

        Log.e("url:", url);
        OkHttpUtils.get().url(url).build().execute(new ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {
            }

            @Override
            public void onResponse(String response) {
                HomeModel model = new Gson().fromJson(response, HomeModel.class);
                Toast.makeText(getActivity(), "model::" + model.body.donate.projectCount, Toast.LENGTH_LONG).show();
                HomeModel.BodyBean.DonateBean donate = model.body.donate;

                Fragment fragment = null;
                if(donate != null & TextUtils.equals(model.body.donate.projectCount,"0")){
                    fragment = HDFragment.getInstance(model);
                }else{
                    fragment = NDFragment.getInstance(model);
                }

                if(fragment != null){
                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                    transaction.replace(R.id.home_content_frame,fragment,fragment.getClass().getName()).commitAllowingStateLoss();
                }

            }
        });
    }


    private void initMenu() {
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.view_menu_home, null);
        popupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_bg_transparent));
        contentView.findViewById(R.id.user_tv).setOnClickListener(this);
        contentView.findViewById(R.id.safe_tv).setOnClickListener(this);
        contentView.findViewById(R.id.scan_tv).setOnClickListener(this);
        contentView.findViewById(R.id.setup_tv).setOnClickListener(this);
        contentView.findViewById(R.id.share_tv).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        popupWindow.dismiss();
        switch (v.getId()) {
            case R.id.user_tv:
                Toast.makeText(getActivity(), "个人资料", Toast.LENGTH_LONG).show();
                break;
            case R.id.safe_tv:
                Toast.makeText(getActivity(), "账号安全", Toast.LENGTH_LONG).show();
                break;
            case R.id.scan_tv:
                Toast.makeText(getActivity(), "扫一扫", Toast.LENGTH_LONG).show();
                break;
            case R.id.setup_tv:
                Toast.makeText(getActivity(), "设置", Toast.LENGTH_LONG).show();
                break;
            case R.id.share_tv:
                Toast.makeText(getActivity(), "分享", Toast.LENGTH_LONG).show();
                break;
        }
    }


}
