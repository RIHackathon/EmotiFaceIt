package com.rsquared.robert.emotifaceit;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
        return 1;
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
//        imageView.setImageResource(mThumbIds[position]);
        imageView.setImageBitmap(bitmap);
        return imageView;
    }

    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(context.getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }
/*    private Integer[] mThumbIds ={
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

    };*/
}
