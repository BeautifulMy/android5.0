package com.example.my5060;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toolbar;

public class AppbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_appbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toobar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setActionBar(toolbar);
        viewPager.setAdapter(new Myadapter());
        tabLayout.setupWithViewPager(viewPager);
    }

    private class Myadapter extends PagerAdapter {

        //设置viewpager条目对应的标签的文本
        @Override
        public CharSequence getPageTitle(int position) {
            return  "111111111111111";
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = View.inflate(AppbarActivity.this, R.layout.appbarlayout_viewpager_item, null);

            //初始化recycelerView，填充显示数据
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

            LinearLayoutManager layoutManager = new LinearLayoutManager(AppbarActivity.this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(new MyRecyclerViewadapter());

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }

    private class MyRecyclerViewadapter extends RecyclerView.Adapter<MyRecyclerViewadapter.ViewHolder> {

        //设置条目布局操作
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(AppbarActivity.this, R.layout.recyclerview_item, null);

            return new ViewHolder(view);
        }

        //加载条目数据
        //onBindViewHolder中如果使用的自己的viewholder，一定要在adapter类中进行类型标示
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            viewHolder.setData(position);
        }

        //设置条目个数
        @Override
        public int getItemCount() {
            return 100;
        }

        //创建一个viewhodler用来初始化控件和加载数据,viewholder是在adapter的内部
        class ViewHolder extends RecyclerView.ViewHolder {
            TextView tv1;
            TextView tv2;

            public ViewHolder(View itemView) {
                super(itemView);
                //初始化控件的操作
                tv1 = (TextView) itemView.findViewById(R.id.tv1);
                tv2 = (TextView) itemView.findViewById(R.id.tv2);
            }

            /**
             * 设置控件展示数据
             **/
            public void setData(int position) {
                tv1.setText(position + "");
                tv2.setText("我是第" + position + "条目的数据");
            }
        }
    }


}
