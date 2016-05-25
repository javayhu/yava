/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.hujiaweibujidao.library;

import android.animation.TypeEvaluator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 缓动函数的抽象类，每个EasingMethod（缓动方法）实际上就是一个类型估值器（TypeEvaluator）
 */
public abstract class BaseEasingMethod implements TypeEvaluator<Number> {

    protected float mDuration;//缓动的时长
    private ArrayList<EasingUpdateListener> mListeners = new ArrayList<EasingUpdateListener>();//监听器列表

    public BaseEasingMethod(float duration) {
        mDuration = duration;
    }

    public void addEasingListener(EasingUpdateListener l) {
        mListeners.add(l);
    }

    public void addEasingListeners(EasingUpdateListener... ls) {
        Collections.addAll(mListeners, ls);
    }

    public void removeEasingListener(EasingUpdateListener l) {
        mListeners.remove(l);
    }

    public void clearEasingListeners() {
        mListeners.clear();
    }

    @Override
    public final Float evaluate(float fraction, Number startValue, Number endValue) {
        float t = mDuration * fraction;//已经过去的时间
        float b = startValue.floatValue();//起始值
        float c = endValue.floatValue() - startValue.floatValue();//结束值与起始值之间的差值
        float d = mDuration;//总的时间间隔
        float result = calculate(t, b, c, d);//不同的缓动函数计算出不同的数据值

        for (EasingUpdateListener l : mListeners) {
            l.on(t, result, b, c, d);
        }
        return result;
    }

    //不同的缓动函数的区别就是根据这几个参数得到的下一个值不同而已
    public abstract Float calculate(float t, float b, float c, float d);

    public float getDuration() {
        return mDuration;
    }

    public void setDuration(float duration) {
        mDuration = duration;
    }

    //缓动过程的监听器，监听每次值的变化
    public interface EasingUpdateListener {
        void on(float time, float value, float start, float end, float duration);
    }

}
