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
 * animator包下的所有类都继承自BaseViewAnimator
 */
public abstract class BaseViewAnimator {

    private int mRepeat;//动画重复的次数
    private boolean mRest;//动画结束之后是否恢复到原来的状态
    private View mTarget;//动画作用的对象
    private AnimatorSet mAnimatorSet = new AnimatorSet();//动画集合

    protected abstract void prepare(View target);//动画准备阶段

    /**
     * start to animate
     */
    public void start() {
        reset();
        prepare(mTarget);
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
                    reset();
                }
            });
        }
        mAnimatorSet.start();
    }

    /**
     * reset the view to default status
     */
    public void reset() {
        mTarget.setAlpha(1);
        mTarget.setScaleX(1);
        mTarget.setScaleY(1);
        mTarget.setTranslationX(0);
        mTarget.setTranslationY(0);
        mTarget.setRotation(0);
        mTarget.setRotationX(0);
        mTarget.setRotationY(0);
        mTarget.setPivotX(mTarget.getMeasuredWidth() / 2.0f);
        mTarget.setPivotY(mTarget.getMeasuredHeight() / 2.0f);
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
    }

    //动画其他属性的控制 set
    public BaseViewAnimator setTarget(View target) {//设置动画的作用对象
        mTarget = target;
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
