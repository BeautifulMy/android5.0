package com.example.my5060;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toolbar;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_recycler_view);


        RecyclerView rec = (RecyclerView) findViewById(R.id.recycle);
        final SwipeRefreshLayout refresh = (SwipeRefreshLayout) findViewById(R.id.refresh);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                                android.R.color.holo_green_light,
                                android.R.color.holo_orange_light,
                                android.R.color.holo_red_light);
                        refresh.setRefreshing(false);
                    }
                },3000);
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rec.setLayoutManager(linearLayoutManager);
        rec.setAdapter(new myAdapter());

    }
    private class myAdapter extends RecyclerView.Adapter<myAdapter.ListHolder>{

        @Override
        public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(RecyclerViewActivity.this, R.layout.item_cardview, null);


            return new ListHolder(view);
        }

        @Override
        public void onBindViewHolder(ListHolder holder, int position) {
        holder.setData(position);
        }

        @Override
        public int getItemCount() {
            return 100;
        }
        class ListHolder extends RecyclerView.ViewHolder{


            private final TextView tv1;
            private final TextView tv2;

            public ListHolder(View itemView) {
                super(itemView);
                tv1 = (TextView) itemView.findViewById(R.id.tv1);
                tv2 = (TextView) itemView.findViewById(R.id.tv2);


            }
            public void setData(int position){
                tv1.setText(position+"     ");
                tv2.setText("我是第"+position+"条目");

            }
        }
    }
}
