package com.example.my5060;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class tablelayoutActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablelayout);
        tab = (TabLayout) findViewById(R.id.tab);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tab.addTab(tab.newTab().setText("tab1").setTag("1").setIcon(R.mipmap.ic_launcher));
        tab.addTab(tab.newTab().setText("tab2").setTag("2").setIcon(R.mipmap.ic_launcher));
        tab.addTab(tab.newTab().setText("tab3").setTag("3").setIcon(R.mipmap.ic_launcher));
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(tablelayoutActivity.this, "选中"+tab.getText()+"Tag为"+tab.getTag(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewpager.setAdapter(new myAdapter());
        tab.setupWithViewPager(viewpager);

    }
    class myAdapter extends PagerAdapter{
        @Override
        public CharSequence getPageTitle(int position) {
            return "标签";
        }

        public myAdapter() {
            super();
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = new TextView(tablelayoutActivity.this);
            textView.setText("xxxx");
            textView.setTextColor(Color.RED);
            container.addView(textView);
            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
