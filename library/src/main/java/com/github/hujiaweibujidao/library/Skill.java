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

import com.github.hujiaweibujidao.library.easing.BackEaseIn;
import com.github.hujiaweibujidao.library.easing.BackEaseInOut;
import com.github.hujiaweibujidao.library.easing.BackEaseOut;
import com.github.hujiaweibujidao.library.easing.BounceEaseIn;
import com.github.hujiaweibujidao.library.easing.BounceEaseInOut;
import com.github.hujiaweibujidao.library.easing.BounceEaseOut;
import com.github.hujiaweibujidao.library.easing.CircEaseIn;
import com.github.hujiaweibujidao.library.easing.CircEaseInOut;
import com.github.hujiaweibujidao.library.easing.CircEaseOut;
import com.github.hujiaweibujidao.library.easing.CubicEaseIn;
import com.github.hujiaweibujidao.library.easing.CubicEaseInOut;
import com.github.hujiaweibujidao.library.easing.CubicEaseOut;
import com.github.hujiaweibujidao.library.easing.ElasticEaseIn;
import com.github.hujiaweibujidao.library.easing.ElasticEaseOut;
import com.github.hujiaweibujidao.library.easing.ExpoEaseIn;
import com.github.hujiaweibujidao.library.easing.ExpoEaseInOut;
import com.github.hujiaweibujidao.library.easing.ExpoEaseOut;
import com.github.hujiaweibujidao.library.easing.Linear;
import com.github.hujiaweibujidao.library.easing.QuadEaseIn;
import com.github.hujiaweibujidao.library.easing.QuadEaseInOut;
import com.github.hujiaweibujidao.library.easing.QuadEaseOut;
import com.github.hujiaweibujidao.library.easing.QuintEaseIn;
import com.github.hujiaweibujidao.library.easing.QuintEaseInOut;
import com.github.hujiaweibujidao.library.easing.QuintEaseOut;
import com.github.hujiaweibujidao.library.easing.SineEaseIn;
import com.github.hujiaweibujidao.library.easing.SineEaseInOut;
import com.github.hujiaweibujidao.library.easing.SineEaseOut;

/**
 * Skill是各种不同的缓动函数的枚举集合，枚举项的名称是缓动函数的名称，值是对应的缓动函数实现类 （形象比喻为采用哪种技术来操纵滑翔机）
 */
public enum Skill {

    BackEaseIn(BackEaseIn.class),
    BackEaseOut(BackEaseOut.class),
    BackEaseInOut(BackEaseInOut.class),

    BounceEaseIn(BounceEaseIn.class),
    BounceEaseOut(BounceEaseOut.class),
    BounceEaseInOut(BounceEaseInOut.class),

    CircEaseIn(CircEaseIn.class),
    CircEaseOut(CircEaseOut.class),
    CircEaseInOut(CircEaseInOut.class),

    CubicEaseIn(CubicEaseIn.class),
    CubicEaseOut(CubicEaseOut.class),
    CubicEaseInOut(CubicEaseInOut.class),

    ElasticEaseIn(ElasticEaseIn.class),
    ElasticEaseOut(ElasticEaseOut.class),

    ExpoEaseIn(ExpoEaseIn.class),
    ExpoEaseOut(ExpoEaseOut.class),
    ExpoEaseInOut(ExpoEaseInOut.class),

    QuadEaseIn(QuadEaseIn.class),
    QuadEaseOut(QuadEaseOut.class),
    QuadEaseInOut(QuadEaseInOut.class),

    QuintEaseIn(QuintEaseIn.class),
    QuintEaseOut(QuintEaseOut.class),
    QuintEaseInOut(QuintEaseInOut.class),

    SineEaseIn(SineEaseIn.class),
    SineEaseOut(SineEaseOut.class),
    SineEaseInOut(SineEaseInOut.class),

    Linear(Linear.class);

    private Class easingMethod;

    private Skill(Class clazz) {
        easingMethod = clazz;
    }

    public BaseEasingMethod getMethod(float duration) {
        try {
            return (BaseEasingMethod) easingMethod.getConstructor(float.class).newInstance(duration);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("Can not init easingMethod instance");
        }
    }

}
