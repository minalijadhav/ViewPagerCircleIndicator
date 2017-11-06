package com.example.admin.viewpagercircleindicator.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.viewpagercircleindicator.R;

/**
 * Created by Admin on 02/10/2017.
 */

public class ViewPagerAdapter extends PagerAdapter
{
    private Context context;
    private int[] array_list;

    public ViewPagerAdapter(Context context, int[] array_list)
    {
        this.context = context;
        this.array_list = array_list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View convertView = LayoutInflater.from(context).inflate(R.layout.pager_layout, container, false);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);

        imageView.setBackgroundResource(array_list[position]);

        container.addView(convertView);

        return convertView;
    }

    public int getCount()
    {
        return array_list.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        View view = (View) object;
        container.removeView(view);
    }
}
