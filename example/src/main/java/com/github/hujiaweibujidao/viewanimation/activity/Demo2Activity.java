package com.github.hujiaweibujidao.viewanimation.activity;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.github.hujiaweibujidao.viewanimation.R;

/**
 * 演示LinearInterpolator和TypeEvaluator 与 TimeInterpolator和LinearEvaluator 的动画效果一样
 * 这里使用ValueAnimator来验证
 */
public class Demo2Activity extends AppCompatActivity {

    Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        findViewById(R.id.textview1).setVisibility(View.GONE);
        findViewById(R.id.textview2).setVisibility(View.GONE);
        findViewById(R.id.buttonStart1).setVisibility(View.GONE);
        findViewById(R.id.buttonStart2).setVisibility(View.GONE);

        buttonStart = (Button) findViewById(R.id.buttonStartAll);
        buttonStart.setText("Click and see your log");

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ValueAnimator animator1 = new ValueAnimator();
                animator1.setFloatValues(0.0f, 1.0f);
                animator1.setDuration(1000);
                animator1.setInterpolator(new LinearInterpolator());//默认就是LinearInterpolator
                animator1.setEvaluator(new TypeEvaluator() {
                    @Override
                    public Object evaluate(float fraction, Object startValue, Object endValue) {
                        return (float) startValue + ((float) endValue - (float) startValue) * (fraction*fraction);
                    }
                });
                animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.e("demo 1", "" + animation.getAnimatedValue());
                    }
                });

                ValueAnimator animator2 = new ValueAnimator();
                animator2.setFloatValues(0.0f, 1.0f);
                animator2.setDuration(1000);
                animator2.setInterpolator(new Interpolator() {
                    @Override
                    public float getInterpolation(float input) {
                        return input * input;
                    }
                });
                animator2.setEvaluator(new TypeEvaluator() {
                    @Override
                    public Object evaluate(float fraction, Object startValue, Object endValue) {
                        return (float) startValue + ((float) endValue - (float) startValue) * (fraction);
                    }
                });
                animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.e("demo 2", "" + animation.getAnimatedValue());
                    }
                });

                animator1.start();
                animator2.start();
            }
        });

    }
}
