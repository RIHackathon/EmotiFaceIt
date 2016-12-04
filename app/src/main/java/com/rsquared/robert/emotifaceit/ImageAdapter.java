package com.rsquared.robert.emotifaceit;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by R^2 on 12/3/2016.
 */

public class ImageAdapter extends BaseAdapter {

    private static final String FILE_NAME = "memoji.png";

    private Context context;
    private Bitmap bitmap;
    private ImageView imageView;


    public ImageAdapter(Context context) {
        this.context = context;
    }

    public ImageAdapter(Context context, Bitmap bitmap) {
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

        imageView = new ImageView(context);
//        imageView.setImageResource(mThumbIds[position]);
        int imageCount = loadImageFromStorage(getFilePath());
        saveToInternalStorage(bitmap, imageCount);
        imageView.setImageBitmap(bitmap);

        return imageView;
    }

    private String saveToInternalStorage(Bitmap bitmapImage, int imageCount) {
        ContextWrapper cw = new ContextWrapper(context.getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir

        File directory = cw.getDir(FILE_NAME + imageCount, Context.MODE_PRIVATE);

        // Create imageDir
        File mypath = new File(directory, "emoti1.jpg");

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

    private int loadImageFromStorage(String filePath) {

        int count = 0;
        boolean hasBitmap = true;
        while (hasBitmap) {

            try {
                File file =new File(filePath, FILE_NAME + count);
                FileInputStream fileInputStream = new FileInputStream(file);
                if(fileInputStream == null){


                }
                Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                imageView.setImageBitmap(bitmap);
                count++;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return count;
            }
        }
        return count;
    }

    private String getFilePath(){
        ContextWrapper cw = new ContextWrapper(context.getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir(FILE_NAME, Context.MODE_PRIVATE);

        String mypath = directory.getAbsolutePath();

        return mypath;
    }
}
