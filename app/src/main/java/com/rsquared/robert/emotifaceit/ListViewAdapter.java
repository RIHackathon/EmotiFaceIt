package com.rsquared.robert.emotifaceit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;
import android.media.Image;
import android.widget.ArrayAdapter;

public class ListViewAdapter extends ArrayAdapter<Item> {

    ArrayList<Item> emoticons = new ArrayList<>();

    public ListViewAdapter(Context context, int textViewResourceId, ArrayList<Item> objects) {
        super(context, textViewResourceId, objects);
        emoticons = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.activity_fullscreen, null);
//        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView2);
//        textView.setText(emoticons.get(position).getName());
        imageView.setImageResource(emoticons.get(position).getEmoticonImage());
        return v;

    }

}


/**
 * Created by emesh on 12/3/2016.
 */




/*
public class ListViewAdapter extends ArrayAdapter {

    ArrayList<Image> emoticons= new ArrayList<>();
    public ListViewAdapter(Context context, int resource, ArrayList<Item> Objects) {
        super(context, resource);
    }
*/