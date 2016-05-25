package com.github.hujiaweibujidao.viewanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.hujiaweibujidao.library.Technique;
import com.github.hujiaweibujidao.library.YoYo;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button buttonStart;
    Button buttonStop;

    YoYo.YoYoString yoYoString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStop = (Button) findViewById(R.id.buttonStop);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yoYoString = YoYo.with(Technique.Hinge).duration(2000).delay(0)
                        .target(textView).reset(true).repeat(10) //ValueAnimator.INFINITE
                        .interpolate(new AccelerateDecelerateInterpolator())
                        .listen(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                Toast.makeText(MainActivity.this, "animation end", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .play();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != yoYoString) {
                    yoYoString.stop(true);
                }
            }
        });

    }
}
