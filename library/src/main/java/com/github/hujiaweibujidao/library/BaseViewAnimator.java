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

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;

import java.util.List;

/**
 * ViewAnimator的抽象基类，不同动画效果之间的差异体现在它们在动画准备阶段加入到动画集合中的动画不同
 */
public abstract class BaseViewAnimator {

    private int mRepeat;//动画重复的次数
    private boolean mRest;//动画结束之后是否恢复到原来的状态
    private AnimatorSet mAnimatorSet = new AnimatorSet();//动画集合

    protected abstract void prepare(View target);//动画准备阶段

    /**
     * start to animate
     */
    public void start(final View target) {
        reset(target);
        prepare(target);
        if (mRepeat != 0) {
            for (Animator animator : mAnimatorSet.getChildAnimations()) {
                ((ValueAnimator) animator).setRepeatCount(mRepeat > 0 ? mRepeat - 1 : mRepeat);//区别无穷次
                //((ValueAnimator) animator).setRepeatMode(ValueAnimator.REVERSE);
            }
        }
        if (mRest) {
            mAnimatorSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    reset(target);
                }
            });
        }
        mAnimatorSet.start();
    }

    /**
     * reset the view to default status
     */
    public void reset(View target) {
        target.setAlpha(1);
        target.setScaleX(1);
        target.setScaleY(1);
        target.setTranslationX(0);
        target.setTranslationY(0);
        target.setRotation(0);
        target.setRotationX(0);
        target.setRotationY(0);
        target.setPivotX(target.getMeasuredWidth() / 2.0f);
        target.setPivotY(target.getMeasuredHeight() / 2.0f);
    }

    //动画过程的控制
    public void cancel() {
        mAnimatorSet.cancel();
    }

    public boolean isRunning() {
        return mAnimatorSet.isRunning();
    }

    public boolean isStarted() {
        return mAnimatorSet.isStarted();
    }

    //动画监听器的控制，监听器的方法会在AnimatorSet中被调用
    public BaseViewAnimator addAnimatorListener(Animator.AnimatorListener l) {
        mAnimatorSet.addListener(l);
        return this;
    }

    public BaseViewAnimator addAllListeners(List<Animator.AnimatorListener> ls) {
        for (Animator.AnimatorListener l : ls) {
            mAnimatorSet.addListener(l);
        }
        return this;
    }

    public void removeAnimatorListener(Animator.AnimatorListener l) {
        mAnimatorSet.removeListener(l);
    }

    public void removeAllListener() {
        mAnimatorSet.removeAllListeners();
        //default listener will be removed...
    }

    //动画其他属性的控制 set
    public BaseViewAnimator setTarget(View target) {//设置动画的作用对象
        mAnimatorSet.setTarget(target);
        return this;
    }

    public BaseViewAnimator setInterpolator(Interpolator interpolator) {//设置动画的插值器
        mAnimatorSet.setInterpolator(interpolator);
        return this;
    }

    public BaseViewAnimator setDuration(long duration) {
        mAnimatorSet.setDuration(duration);
        return this;
    }

    public BaseViewAnimator setStartDelay(long delay) {
        mAnimatorSet.setStartDelay(delay);
        return this;
    }

    public BaseViewAnimator setRest(boolean rest) {
        mRest = rest;
        return this;
    }

    public BaseViewAnimator setRepeat(int repeat) {
        mRepeat = repeat;
        return this;
    }

    //get 子类会调用该方法
    public AnimatorSet getAnimatorSet() {
        return mAnimatorSet;
    }
}
