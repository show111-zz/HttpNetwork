package com.show.series.httpnetwork.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.show.series.httpnetwork.R;
import com.show.series.httpnetwork.activity.fragment.PrimaryActivity;

import java.util.ArrayList;

/**
 * Created by lihf on 16/8/11.
 */
public class GuideActivity extends Activity {

    private ViewPager viewPager;
    private ArrayList<View> pageViews;
    private ViewGroup viewPics;
    private LinearLayout view_container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = getLayoutInflater();
        pageViews = new ArrayList<>();

        final View pic1 = inflater.inflate(R.layout.guide_view, null);
        ImageView guideView1 = (ImageView) pic1.findViewById(R.id.guideView);
        guideView1.setBackgroundResource(R.mipmap.guide_bg1);

        final View pic2 = inflater.inflate(R.layout.guide_view, null);
        ImageView guideView2 = (ImageView) pic2.findViewById(R.id.guideView);
        guideView2.setBackgroundResource(R.mipmap.guide_bg2);

        final View pic3 = inflater.inflate(R.layout.guide_view, null);
        ImageView guideView3 = (ImageView) pic3.findViewById(R.id.guideView);
        guideView3.setBackgroundResource(R.mipmap.guide_bg3);

        final View pic4 = inflater.inflate(R.layout.guide_view, null);
        ImageView guideView4 = (ImageView) pic4.findViewById(R.id.guideView);
        guideView4.setBackgroundResource(R.mipmap.guide_bg4);

        final View pic5 = inflater.inflate(R.layout.guide_view, null);
        ImageView guideView5 = (ImageView) pic5.findViewById(R.id.guideView);
        guideView5.setBackgroundResource(R.mipmap.guide_bg5);

        Button btn_just_do = (Button) pic5.findViewById(R.id.btn_just_do);
        btn_just_do.setVisibility(View.VISIBLE);
        btn_just_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                startActivity(new Intent(GuideActivity.this, PrimaryActivity.class));
                finish();
            }
        });


        pageViews.add(pic1);
        pageViews.add(pic2);
        pageViews.add(pic3);
        pageViews.add(pic4);
        pageViews.add(pic5);


        viewPics = (ViewGroup) inflater.inflate(R.layout.activity_guide, null);
        viewPager = (ViewPager) viewPics.findViewById(R.id.viewPager);

        setContentView(viewPics);

        viewPager.setAdapter(new GuidePageAdapter());


        view_container = (LinearLayout) viewPics.findViewById(R.id.view_container);

        for (int i = 0; i < pageViews.size(); i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(23,23);
            params.setMargins(20,5,20,5);
            view_container.addView(dotsItem(i),params);  //引导圆圈
        }

        view_container.getChildAt(0).setSelected(true);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0;i<view_container.getChildCount();i++){
                    view_container.getChildAt(i).setSelected(false);
                }
                view_container.getChildAt(position).setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    private ImageView dotsItem(int position){
       LayoutInflater inflater = (LayoutInflater) getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.view_grounp_dot,null);
        ImageView iv = (ImageView) layout.findViewById(R.id.face_dot);
        iv.setId(position);
        return iv;
    }


    class GuidePageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return pageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pageViews.get(position));
            return pageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(pageViews.get(position));
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }
    }


}
