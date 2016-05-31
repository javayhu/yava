package com.github.hujiaweibujidao.example.activity;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.github.hujiaweibujidao.yava.Functions;
import com.github.hujiaweibujidao.yava.IFunction;
import com.github.hujiaweibujidao.example.R;

/**
 * 演示如何自定义function拿到Interpolator或者TypeEvaluator
 */
public class CustomActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    Button buttonStart;
    Button buttonStart2;
    Button buttonStartAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        textView1 = (TextView) findViewById(R.id.textview1);
        textView2 = (TextView) findViewById(R.id.textview2);
        buttonStart = (Button) findViewById(R.id.buttonStart1);
        buttonStart2 = (Button) findViewById(R.id.buttonStart2);
        buttonStartAll = (Button) findViewById(R.id.buttonStartAll);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimator1();
            }
        });
        buttonStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimator2();
            }
        });
        buttonStartAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimator1();
                startAnimator2();
            }
        });
    }

    private void startAnimator2() {
        ObjectAnimator animator2 = new ObjectAnimator();
        animator2.setTarget(textView2);
        animator2.setPropertyName("translationY");
        animator2.setFloatValues(0f, -100f);
        animator2.setDuration(1000);
        animator2.setInterpolator(Functions.with(new IFunction() {
            @Override
            public float getValue(float input) {
                return input * 2 + 3;
            }
        }));
        animator2.setEvaluator(new FloatEvaluator());
        animator2.start();
    }

    private void startAnimator1() {
        ObjectAnimator animator1 = new ObjectAnimator();
        animator1.setTarget(textView1);
        animator1.setPropertyName("translationY");
        animator1.setFloatValues(0f, -100f);
        animator1.setDuration(1000);
        animator1.setInterpolator(new LinearInterpolator());
        animator1.setEvaluator(Functions.with(new IFunction() {
            @Override
            public float getValue(float input) {
                return input * 2 + 3;
            }
        }));
        animator1.start();
    }
}

