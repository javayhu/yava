package com.github.hujiaweibujidao.example.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.github.hujiaweibujidao.example.R;
import com.github.hujiaweibujidao.example.adapter.EvaluatorAdapter;
import com.github.hujiaweibujidao.yava.EasingFunction;
import com.github.hujiaweibujidao.example.view.EvaluatorView;

/**
 * 演示TypeEvaluator
 */
public class EvaluatorActivity extends AppCompatActivity {

    private ListView list;
    private EvaluatorAdapter adapter;

    private View circle;
    private EvaluatorView evaluatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluator);

        adapter = new EvaluatorAdapter(this);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        circle = findViewById(R.id.circle);
        evaluatorView = (EvaluatorView) findViewById(R.id.drawview);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                evaluatorView.clear();
                circle.setTranslationX(0);
                circle.setTranslationY(0);

                ObjectAnimator animator = ObjectAnimator.ofFloat(circle, "translationY", 0, dipToPixels(EvaluatorActivity.this, -(160 - 3)));
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        evaluatorView.drawPoint(animation.getCurrentPlayTime(), animation.getDuration(), (float) animation.getAnimatedValue() - dipToPixels(EvaluatorActivity.this, 60));
                    }
                });
                animator.setEvaluator(EasingFunction.values()[position]);
                animator.setDuration(1200);
                animator.start();

            }
        });

    }

    public static float dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics);
    }

}
