package com.rsquared.robert.emotifaceit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by R^2 on 12/3/2016.
 */

public class ImageAdapter extends BaseAdapter {

    private Context context;

    public ImageAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.ic_bus_stop_big_medium_small_turk);
        imageView.setImageResource(R.drawable.ic_bus_stop_big_medium_small_turk);
        imageView.setImageResource(R.drawable.ic_bus_stop_big_medium_small_turk);
        imageView.setImageResource(R.drawable.ic_bus_stop_big_medium_small_turk);
        imageView.setImageResource(R.drawable.ic_bus_stop_big_medium_small_turk);
        imageView.setImageResource(R.drawable.ic_bus_stop_big_medium_small_turk);
        imageView.setImageResource(R.drawable.ic_bus_stop_big_medium_small_turk);
        return null;
    }
}
