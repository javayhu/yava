package com.github.hujiaweibujidao.viewanimation.activity;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.github.hujiaweibujidao.viewanimation.R;

/**
 * 演示LinearInterpolator和TypeEvaluator 与 TimeInterpolator和LinearEvaluator 的动画效果一样
 * 这里使用ObjectAnimator来验证，弹跳效果
 */
public class BounceActivity extends AppCompatActivity {

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
        final ObjectAnimator animator2 = new ObjectAnimator();
        animator2.setTarget(textView2);
        animator2.setPropertyName("translationY");
        animator2.setFloatValues(0f, -100f);
        animator2.setDuration(1000);
        animator2.setInterpolator(new TimeInterpolator() {
            @Override
            public float getInterpolation(float input) {
                if (input < (1 / 2.75))
                    return (7.5625f * input * input);
                else if (input < (2 / 2.75))
                    return (7.5625f * (input -= (1.5f / 2.75f)) * input + 0.75f);
                else if (input < (2.5 / 2.75))
                    return (7.5625f * (input -= (2.25f / 2.75f)) * input + 0.9375f);
                else
                    return (7.5625f * (input -= (2.625f / 2.75f)) * input + 0.984375f);
            }
        });
        animator2.setEvaluator(new FloatEvaluator());
        animator2.start();
    }

    private void startAnimator1() {
        final ObjectAnimator animator1 = new ObjectAnimator();
        animator1.setTarget(textView1);
        animator1.setPropertyName("translationY");
        animator1.setFloatValues(0f, -100f);
        animator1.setDuration(1000);
        animator1.setInterpolator(new LinearInterpolator());
        animator1.setEvaluator(new TypeEvaluator<Number>() {
            @Override
            public Number evaluate(float fraction, Number startValue, Number endValue) {
                float t = animator1.getDuration() * fraction;//已经过去的时间
                float b = startValue.floatValue();//起始值
                float c = endValue.floatValue() - startValue.floatValue();//结束值与起始值之间的差值
                float d = animator1.getDuration();//总的时间间隔，t/d 就是已经过去的时间占总时间间隔的比率

                if ((t /= d) < (1 / 2.75f)) {
                    return c * (7.5625f * t * t) + b;
                } else if (t < (2 / 2.75f)) {
                    return c * (7.5625f * (t -= (1.5f / 2.75f)) * t + .75f) + b;
                } else if (t < (2.5 / 2.75)) {
                    return c * (7.5625f * (t -= (2.25f / 2.75f)) * t + .9375f) + b;
                } else {
                    return c * (7.5625f * (t -= (2.625f / 2.75f)) * t + .984375f) + b;
                }
            }
        });
        animator1.start();
    }
}

