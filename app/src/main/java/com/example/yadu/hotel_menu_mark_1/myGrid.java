package com.example.yadu.hotel_menu_mark_1;

/**
 * Created by yadu on 04/02/15.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;



public class myGrid extends BaseAdapter {
    private Context context;
    private final String[] mobileValues;

    public myGrid(Context context, String[] mobileValues) {
        this.context = context;
        this.mobileValues = mobileValues;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.grid_single, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_text);
            textView.setText(mobileValues[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_image);

            String mobile = mobileValues[position];

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

            if (mobile.equals("starters")) {
                imageView.setImageResource(R.drawable.pic_1);
            } else if (mobile.equals("Main Course")) {
                imageView.setImageResource(R.drawable.pic_2);
            }else {
                imageView.setImageResource(R.drawable.pic_3);
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return mobileValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}