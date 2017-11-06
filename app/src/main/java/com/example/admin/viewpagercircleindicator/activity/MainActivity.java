package com.example.admin.viewpagercircleindicator.activity;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.viewpagercircleindicator.R;
import com.example.admin.viewpagercircleindicator.adapter.ViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity
{
    private ViewPager viewPager;
    private LinearLayout dotsLinear;
    private ViewPagerAdapter viewPagerAdapter;
    private int[] array;
    private TextView[] dotsText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Method for Initialization
        initialize();

        // Method for Adding Indicators
        addIndicator(0);
    }

    private void initialize()
    {
        // Finding IDs of all the Views
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLinear = (LinearLayout) findViewById(R.id.dots_linear);

        // Initializing array
        array = new int[]
                {
                        R.drawable.image_1,
                        R.drawable.image_2,
                        R.drawable.image_3,
                        R.drawable.image_4,
                        R.drawable.image_5,
                        R.drawable.image_6,
                };

        // Setting adapter for View Pager
        viewPagerAdapter = new ViewPagerAdapter(MainActivity.this, array);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                // Method for Adding Indicators
                addIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addIndicator(int position)
    {
        dotsText = new TextView[array.length];
        dotsLinear.removeAllViews();

        for(int i = 0; i < dotsText.length; i++)
        {
            dotsText[i] = new TextView(MainActivity.this);
            String html_string = "&#8226;";

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
            {
                dotsText[i].setText(Html.fromHtml(html_string, Html.FROM_HTML_MODE_LEGACY));
            }
            else
            {
                dotsText[i].setText(Html.fromHtml(html_string));
            }

            dotsText[i].setTextSize(28);
            dotsText[i].setTextColor(ContextCompat.getColor(MainActivity.this, R.color.light_gray));
            dotsLinear.addView(dotsText[i]);
        }

        if(dotsText.length == 1)
        {
            dotsLinear.setVisibility(View.GONE);
        }
        else if(dotsText.length > 0)
        {
            dotsText[position].setTextSize(28);;
            dotsText[position].setTextColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        }
    }
}
