package com.example.edutrack;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int[] images;
    public ImageAdapter(Context c, int[] imgs){ mContext=c; images=imgs; }
    @Override public int getCount(){ return images.length; }
    @Override public Object getItem(int position){ return null; }
    @Override public long getItemId(int position){ return position; }
    @Override public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView = (ImageView) (convertView != null ? convertView : new ImageView(mContext));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(300,300));
        imageView.setImageResource(images[position]);
        return imageView;
    }
}
