package com.github.hujiaweibujidao.viewanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.hujiaweibujidao.library.Technique;
import com.github.hujiaweibujidao.library.YoYo;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    Button buttonStart;
    Button buttonStop;

    YoYo.YoYoString yoYoString1;
    YoYo.YoYoString yoYoString2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textview1);
        textView2 = (TextView) findViewById(R.id.textview2);
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStop = (Button) findViewById(R.id.buttonStop);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yoYoString1 = YoYo.with(Technique.Bounce).duration(2000).delay(0)
                        .target(textView1).reset(true).repeat(10) //ValueAnimator.INFINITE
                        .interpolate(new LinearInterpolator())
                        .listen(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                Toast.makeText(MainActivity.this, "1 animation end", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .play();

                yoYoString2 = YoYo.with(Technique.Bounce).duration(2000).delay(0)
                        .target(textView2).reset(true).repeat(10) //ValueAnimator.INFINITE
                        .interpolate(new BounceInterpolator())
                        .listen(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                Toast.makeText(MainActivity.this, "2 animation end", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .play();

                //ObjectAnimator.ofFloat(target, "translationY", 0, 0, -30, 0, -15, 0, 0)
//                ObjectAnimator animator = ObjectAnimator.ofFloat(textView2, "translationY", 0, 0, -30, 0, -15, 0, 0);
//                animator.setDuration(2000);
//                animator.setStartDelay(0);
//                animator.setRepeatCount(10);
//                animator.setInterpolator(new BounceInterpolator());
//                animator.addListener(new AnimatorListenerAdapter() {
//                    @Override
//                    public void onAnimationEnd(Animator animation) {
//                        Toast.makeText(MainActivity.this, "2 animation end", Toast.LENGTH_SHORT).show();
//                    }
//                });
//                animator.start();

            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != yoYoString1) {
                    yoYoString1.stop(true);
                }

                if (null != yoYoString2) {
                    yoYoString2.stop(true);
                }
            }
        });

    }
}
