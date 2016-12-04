package com.rsquared.robert.emotifaceit;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

public class ListViewAdapter extends ArrayAdapter<Item> {

    private Context context;

    ArrayList<Item> emoticons = new ArrayList<>();

    public ListViewAdapter(Context context, int textViewResourceId, ArrayList<Item> objects) {
        super(context, textViewResourceId, objects);
        emoticons = objects;
        this.context= context;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.activity_fullscreen, null);
//        TextView textView = (TextView) v.findViewById(R.id.textView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView2);
//        textView.setText(emoticons.get(position).getName());
        imageView.setImageResource(emoticons.get(position).getEmoticonImage());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.EMOTIWAREHOUSE");
                context.startActivity(intent);
                Toast.makeText(context, "The list view is clickable. Clicked item number: " + position, Toast.LENGTH_LONG).show();
            }
        });

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