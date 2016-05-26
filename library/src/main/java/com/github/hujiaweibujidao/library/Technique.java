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

import com.github.hujiaweibujidao.library.animator.BounceAnimator;
import com.github.hujiaweibujidao.library.animator.FlashAnimator;
import com.github.hujiaweibujidao.library.animator.PulseAnimator;
import com.github.hujiaweibujidao.library.animator.RubberBandAnimator;
import com.github.hujiaweibujidao.library.animator.ShakeAnimator;
import com.github.hujiaweibujidao.library.animator.StandUpAnimator;
import com.github.hujiaweibujidao.library.animator.SwingAnimator;
import com.github.hujiaweibujidao.library.animator.TadaAnimator;
import com.github.hujiaweibujidao.library.animator.WaveAnimator;
import com.github.hujiaweibujidao.library.animator.WobbleAnimator;
import com.github.hujiaweibujidao.library.animator.BounceInAnimator;
import com.github.hujiaweibujidao.library.animator.BounceInDownAnimator;
import com.github.hujiaweibujidao.library.animator.BounceInLeftAnimator;
import com.github.hujiaweibujidao.library.animator.BounceInRightAnimator;
import com.github.hujiaweibujidao.library.animator.BounceInUpAnimator;
import com.github.hujiaweibujidao.library.animator.FadeInAnimator;
import com.github.hujiaweibujidao.library.animator.FadeInDownAnimator;
import com.github.hujiaweibujidao.library.animator.FadeInLeftAnimator;
import com.github.hujiaweibujidao.library.animator.FadeInRightAnimator;
import com.github.hujiaweibujidao.library.animator.FadeInUpAnimator;
import com.github.hujiaweibujidao.library.animator.FadeOutAnimator;
import com.github.hujiaweibujidao.library.animator.FadeOutDownAnimator;
import com.github.hujiaweibujidao.library.animator.FadeOutLeftAnimator;
import com.github.hujiaweibujidao.library.animator.FadeOutRightAnimator;
import com.github.hujiaweibujidao.library.animator.FadeOutUpAnimator;
import com.github.hujiaweibujidao.library.animator.FlipInXAnimator;
import com.github.hujiaweibujidao.library.animator.FlipInYAnimator;
import com.github.hujiaweibujidao.library.animator.FlipOutXAnimator;
import com.github.hujiaweibujidao.library.animator.FlipOutYAnimator;
import com.github.hujiaweibujidao.library.animator.RotateInAnimator;
import com.github.hujiaweibujidao.library.animator.RotateInDownLeftAnimator;
import com.github.hujiaweibujidao.library.animator.RotateInDownRightAnimator;
import com.github.hujiaweibujidao.library.animator.RotateInUpLeftAnimator;
import com.github.hujiaweibujidao.library.animator.RotateInUpRightAnimator;
import com.github.hujiaweibujidao.library.animator.RotateOutAnimator;
import com.github.hujiaweibujidao.library.animator.RotateOutDownLeftAnimator;
import com.github.hujiaweibujidao.library.animator.RotateOutDownRightAnimator;
import com.github.hujiaweibujidao.library.animator.RotateOutUpLeftAnimator;
import com.github.hujiaweibujidao.library.animator.RotateOutUpRightAnimator;
import com.github.hujiaweibujidao.library.animator.SlideInDownAnimator;
import com.github.hujiaweibujidao.library.animator.SlideInLeftAnimator;
import com.github.hujiaweibujidao.library.animator.SlideInRightAnimator;
import com.github.hujiaweibujidao.library.animator.SlideInUpAnimator;
import com.github.hujiaweibujidao.library.animator.SlideOutDownAnimator;
import com.github.hujiaweibujidao.library.animator.SlideOutLeftAnimator;
import com.github.hujiaweibujidao.library.animator.SlideOutRightAnimator;
import com.github.hujiaweibujidao.library.animator.SlideOutUpAnimator;
import com.github.hujiaweibujidao.library.animator.DropOutAnimator;
import com.github.hujiaweibujidao.library.animator.HingeAnimator;
import com.github.hujiaweibujidao.library.animator.LandingAnimator;
import com.github.hujiaweibujidao.library.animator.RollInAnimator;
import com.github.hujiaweibujidao.library.animator.RollOutAnimator;
import com.github.hujiaweibujidao.library.animator.TakingOffAnimator;
import com.github.hujiaweibujidao.library.animator.ZoomInAnimator;
import com.github.hujiaweibujidao.library.animator.ZoomInDownAnimator;
import com.github.hujiaweibujidao.library.animator.ZoomInLeftAnimator;
import com.github.hujiaweibujidao.library.animator.ZoomInRightAnimator;
import com.github.hujiaweibujidao.library.animator.ZoomInUpAnimator;
import com.github.hujiaweibujidao.library.animator.ZoomOutAnimator;
import com.github.hujiaweibujidao.library.animator.ZoomOutDownAnimator;
import com.github.hujiaweibujidao.library.animator.ZoomOutLeftAnimator;
import com.github.hujiaweibujidao.library.animator.ZoomOutRightAnimator;
import com.github.hujiaweibujidao.library.animator.ZoomOutUpAnimator;

/**
 * Technique是各种不同的animator效果的枚举集合类 （形象比喻为采用哪种技术来操纵悠悠球）
 */
public enum Technique {

    DropOut(DropOutAnimator.class),
    Landing(LandingAnimator.class),
    TakingOff(TakingOffAnimator.class),

    Flash(FlashAnimator.class),
    Pulse(PulseAnimator.class),
    RubberBand(RubberBandAnimator.class),
    Shake(ShakeAnimator.class),
    Swing(SwingAnimator.class),
    Wobble(WobbleAnimator.class),
    Bounce(BounceAnimator.class),
    Tada(TadaAnimator.class),
    StandUp(StandUpAnimator.class),
    Wave(WaveAnimator.class),

    Hinge(HingeAnimator.class),
    RollIn(RollInAnimator.class),
    RollOut(RollOutAnimator.class),

    BounceIn(BounceInAnimator.class),
    BounceInDown(BounceInDownAnimator.class),
    BounceInLeft(BounceInLeftAnimator.class),
    BounceInRight(BounceInRightAnimator.class),
    BounceInUp(BounceInUpAnimator.class),

    FadeIn(FadeInAnimator.class),
    FadeInUp(FadeInUpAnimator.class),
    FadeInDown(FadeInDownAnimator.class),
    FadeInLeft(FadeInLeftAnimator.class),
    FadeInRight(FadeInRightAnimator.class),

    FadeOut(FadeOutAnimator.class),
    FadeOutDown(FadeOutDownAnimator.class),
    FadeOutLeft(FadeOutLeftAnimator.class),
    FadeOutRight(FadeOutRightAnimator.class),
    FadeOutUp(FadeOutUpAnimator.class),

    FlipInX(FlipInXAnimator.class),
    FlipOutX(FlipOutXAnimator.class),
    FlipInY(FlipInYAnimator.class),
    FlipOutY(FlipOutYAnimator.class),
    RotateIn(RotateInAnimator.class),
    RotateInDownLeft(RotateInDownLeftAnimator.class),
    RotateInDownRight(RotateInDownRightAnimator.class),
    RotateInUpLeft(RotateInUpLeftAnimator.class),
    RotateInUpRight(RotateInUpRightAnimator.class),

    RotateOut(RotateOutAnimator.class),
    RotateOutDownLeft(RotateOutDownLeftAnimator.class),
    RotateOutDownRight(RotateOutDownRightAnimator.class),
    RotateOutUpLeft(RotateOutUpLeftAnimator.class),
    RotateOutUpRight(RotateOutUpRightAnimator.class),

    SlideInLeft(SlideInLeftAnimator.class),
    SlideInRight(SlideInRightAnimator.class),
    SlideInUp(SlideInUpAnimator.class),
    SlideInDown(SlideInDownAnimator.class),

    SlideOutLeft(SlideOutLeftAnimator.class),
    SlideOutRight(SlideOutRightAnimator.class),
    SlideOutUp(SlideOutUpAnimator.class),
    SlideOutDown(SlideOutDownAnimator.class),

    ZoomIn(ZoomInAnimator.class),
    ZoomInDown(ZoomInDownAnimator.class),
    ZoomInLeft(ZoomInLeftAnimator.class),
    ZoomInRight(ZoomInRightAnimator.class),
    ZoomInUp(ZoomInUpAnimator.class),

    ZoomOut(ZoomOutAnimator.class),
    ZoomOutDown(ZoomOutDownAnimator.class),
    ZoomOutLeft(ZoomOutLeftAnimator.class),
    ZoomOutRight(ZoomOutRightAnimator.class),
    ZoomOutUp(ZoomOutUpAnimator.class);

    private Class animatorClazz;

    Technique(Class clazz) {
        animatorClazz = clazz;
    }

    public BaseViewAnimator getAnimator() {
        try {
            return (BaseViewAnimator) animatorClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
