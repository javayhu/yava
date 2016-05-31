package com.github.hujiaweibujidao.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.hujiaweibujidao.example.R;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnInterpolator(View view) {
        startActivity(new Intent(this, InterpolatorActivity.class));
    }

    public void btnEvaluator(View view) {
        startActivity(new Intent(this, EvaluatorActivity.class));
    }

    public void btnDemo(View view) {
        startActivity(new Intent(this, DemoActivity.class));
    }

    public void btnBounce(View view) {
        startActivity(new Intent(this, BounceActivity.class));
    }

    public void btnBounce2(View view) {
        startActivity(new Intent(this, Bounce2Activity.class));
    }

    public void btnCustom(View view) {
        startActivity(new Intent(this, CustomActivity.class));
    }
}
