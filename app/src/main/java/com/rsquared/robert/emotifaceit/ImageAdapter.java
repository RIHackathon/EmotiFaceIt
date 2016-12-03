package com.rsquared.robert.emotifaceit;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by R^2 on 12/3/2016.
 */

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private Bitmap bitmap;
    public ImageAdapter(Context context){
        this.context = context;
    }

    public ImageAdapter(Context context, Bitmap bitmap){
        this.context = context;
        this.bitmap = bitmap;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setImageBitmap(bitmap);
        return imageView;
    }

    private Integer[] mThumbIds ={
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk,
            R.drawable.ic_bus_stop_big_medium_small_turk

    };
}
