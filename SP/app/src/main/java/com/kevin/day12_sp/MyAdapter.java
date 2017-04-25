package com.kevin.day12_sp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/10.
 */

public class MyAdapter extends PagerAdapter{

    private ArrayList<View> data;
    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<View> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = data.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        View view = data.get(position);
        container.removeView(view);
    }
}
