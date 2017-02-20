package com.example.my5060;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewOutlineProvider;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView icon1;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        icon1 = (ImageView)  findViewById(R.id.iv_icon1);
        icon1.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0,0,view.getWidth(),view.getHeight());
            }
        });

        textView =
                (TextView) findViewById(R.id.cut);
        textView.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0,0,view.getWidth(),view.getHeight());
            }
        });
        //裁剪生效
        textView.setClipToOutline(true);


        ImageView icon2 = (ImageView) findViewById(R.id.iv_icon2);

        final TextView tv2 = (TextView) findViewById(R.id.tv2);
        BitmapDrawable background = (BitmapDrawable) icon2.getBackground();
        //使用调色版
        Palette.generateAsync(background.getBitmap(), new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                //参数 默认的颜色
                tv2.setBackgroundColor(palette.getVibrantColor(Color.BLACK));
            }
        });
        final Button bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animator animator1   = ViewAnimationUtils.createCircularReveal(bt1, bt1.getWidth() / 2, bt1.getHeight() / 2, bt1.getWidth(), 0);
            animator1.setInterpolator(new LinearInterpolator());
                animator1.setDuration(1000);
                animator1.start();

            }
        });
        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animator animator1   = ViewAnimationUtils.createCircularReveal(button2, button2.getWidth() / 2
                        , button2.getHeight() / 2, button2.getWidth(), 0);
                animator1.setInterpolator(new LinearInterpolator());
                animator1.setDuration(1000);
                animator1.start();
            }
        });

        Button bt3 = (Button) findViewById(R.id.bt3);
        bt3.setStateListAnimator(AnimatorInflater.loadStateListAnimator(this,R.drawable.state_anim));

        Button bt4 = (Button) findViewById(R.id.bt4);
        bt4.setOnClickListener(this);
        Button bt5 = (Button) findViewById(R.id.bt5);
        bt5.setOnClickListener(this);
        Button bt6 = (Button) findViewById(R.id.bt6);
        bt6.setOnClickListener(this);
        Button bt7 = (Button) findViewById(R.id.bt7);
        bt7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt4:
            startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));

                break;
            case  R.id.bt5:
                startActivity(new Intent(MainActivity.this,AppbarActivity.class));
                break;
            case  R.id.bt6:
                startActivity(new Intent(MainActivity.this,textinputActivity.class));
                break;
            case  R.id.bt7:
                startActivity(new Intent(MainActivity.this,tablelayoutActivity.class));
                break;

        }
    }
}
