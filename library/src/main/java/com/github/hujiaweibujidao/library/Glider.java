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

import android.animation.ValueAnimator;

/**
 * 滑翔机，Glider类的作用就是用来获取属性动画的数值产生器（ValueAnimator）
 */
public class Glider {

    //没有监听器的版本
    public static ValueAnimator glide(Skill skill, float duration, ValueAnimator animator) {
        return Glider.glide(skill, duration, animator, null);//null不能去掉，否则会变成递归调用该方法
    }

    //包含监听器的版本
    public static ValueAnimator glide(Skill skill, float duration, ValueAnimator animator, BaseEasingMethod.EasingUpdateListener... listeners) {
        BaseEasingMethod easingMethod = skill.getMethod(duration);
        if (listeners != null) easingMethod.addEasingListeners(listeners);
        animator.setEvaluator(easingMethod);
        //animator.setInterpolator();//TODO: 16/5/26
        return animator;
    }

}
