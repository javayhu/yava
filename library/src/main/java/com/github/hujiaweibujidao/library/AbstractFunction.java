package com.github.hujiaweibujidao.library;

import android.animation.TypeEvaluator;
import android.view.animation.Interpolator;

/**
 * 抽象函数实现，既可以当做简单函数使用，也可以当做Interpolator或者TypeEvaluator去用于制作动画
 */
public abstract class AbstractFunction implements IFunction, Interpolator, TypeEvaluator<Float> {

    @Override
    public float getInterpolation(float input) {
        return getValue(input);
    }

    @Override
    public Float evaluate(float fraction, Float startValue, Float endValue) {
        return startValue + getValue(fraction) * (endValue - startValue);
    }
}