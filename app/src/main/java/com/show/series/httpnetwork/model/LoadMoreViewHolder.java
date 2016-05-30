package com.show.series.httpnetwork.model;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.show.series.httpnetwork.R;

import org.w3c.dom.Text;

/**
 * Created by lihf on 16/5/30.
 */
public class LoadMoreViewHolder extends BaseViewHolder<LoadMoreModel.BodyBean.ListBean>{

    private ImageView image_user;
    private TextView project_name;
    private TextView tv_user_count;
    private TextView tv_amount;
    private TextView tv_pay_total;



    public LoadMoreViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_load_more);
        image_user = $(R.id.image_user);
        project_name = $(R.id.project_name);
        tv_user_count = $(R.id.tv_user_count);
        tv_amount = $(R.id.tv_amount);
        tv_pay_total = $(R.id.tv_pay_total);

    }


    @Override
    public void setData(LoadMoreModel.BodyBean.ListBean data) {
        super.setData(data);
        project_name.setText(data.nickName);
        tv_user_count.setText(data.userCount);
        tv_amount.setText(data.amount);
        tv_pay_total.setText(data.payTotal);
        Glide.with(getContext()).load(data.headPath.W180).bitmapTransform(new CenterCrop(getContext())).into(image_user);

    }
}
