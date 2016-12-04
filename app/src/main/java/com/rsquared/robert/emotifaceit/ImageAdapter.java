package com.rsquared.robert.emotifaceit;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
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

    private static final String FILE_NAME = "memoji";
    private static final String FILE_EXTENSION = ".png";

    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;

    }

    public int getCount() {
        return countImagesStored();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Bitmap bitmap = getImageFromStorage(position);
        ImageView imageView = null;

        if(bitmap != null) {
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageBitmap(bitmap);
        }
        return imageView;
    }

    private Bitmap getImageFromStorage(int position) {
        Bitmap bitmap = null;
        try {
            File file = new File(getFilePath(), FILE_NAME + position + FILE_EXTENSION);
            if(file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                bitmap = BitmapFactory.decodeStream(fileInputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    // references to our images
    private Integer[] mThumbIds = {
            /*R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7*/
    };

    private int countImagesStored() {
        int count = 0;
        boolean hasImage = true;
        try {
            while(hasImage){
                File file = new File(getFilePath(), FILE_NAME + count + FILE_EXTENSION);
                if (!file.exists()) {
                    hasImage = false;
                }else{
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    private String getFilePath(){
        ContextWrapper cw = new ContextWrapper(mContext.getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);

        String mypath = directory.getAbsolutePath();

        return mypath;
    }

}


/*

public class ImageAdapter extends BaseAdapter {

    private static final String FILE_NAME = "memoji";
    private static final String FILE_EXTENSION = ".png";


    private Context context;
//    private Bitmap bitmap;
//    private ImageView imageView;
    private int bitmapCount = 0;
    private String filePath;
    private static final int MAX_AMOUNT_MIMOJI = 10;

    public ImageAdapter(Context context) {
        this.context = context;
        this.filePath = getFilePath();
        this.bitmapCount = countImagesStored();
//        imageView = new ImageView(context);
    }

    public ImageAdapter(Context context, Bitmap bitmap) {
        this.context = context;
//        this.bitmap = bitmap;
        this.filePath = getFilePath();
        this.bitmapCount = countImagesStored();

    }

    @Override
    public int getCount() {
        return bitmapCount;
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
        ImageView imageView;
        if(view == null){

            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) view;
        }

        try {
            File file = new File(filePath, FILE_NAME + position + FILE_EXTENSION);
            if(file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                imageView.setImageBitmap(bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageView;
    }

    private String saveToInternalStorage(Bitmap bitmapImage, int position) {
        ContextWrapper cw = new ContextWrapper(context.getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File myPath = new File(directory, FILE_NAME + position + FILE_EXTENSION);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(myPath);
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

    private boolean loadImageFromStorage(int position, ImageView view) {
            boolean loadedSuccessfully = false;
            try {
                File file = new File(filePath, FILE_NAME + position + FILE_EXTENSION);
                if(file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                    view.setImageBitmap(bitmap);
                }
                loadedSuccessfully = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return loadedSuccessfully;
    }

    private int countImagesStored() {
        int count = 0;
        try {
            for(int i = 0; i < MAX_AMOUNT_MIMOJI; i++) {
                File file = new File(filePath, FILE_NAME + i + FILE_EXTENSION);
                if (!file.exists()) {
                    return i;
                }
                count = i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    private String getFilePath(){
        ContextWrapper cw = new ContextWrapper(context.getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);

        String mypath = directory.getAbsolutePath();

        return mypath;
    }
}
*/