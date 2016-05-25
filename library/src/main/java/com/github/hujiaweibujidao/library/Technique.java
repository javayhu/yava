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

import com.github.hujiaweibujidao.library.animator.attention.BounceAnimator;
import com.github.hujiaweibujidao.library.animator.attention.FlashAnimator;
import com.github.hujiaweibujidao.library.animator.attention.PulseAnimator;
import com.github.hujiaweibujidao.library.animator.attention.RubberBandAnimator;
import com.github.hujiaweibujidao.library.animator.attention.ShakeAnimator;
import com.github.hujiaweibujidao.library.animator.attention.StandUpAnimator;
import com.github.hujiaweibujidao.library.animator.attention.SwingAnimator;
import com.github.hujiaweibujidao.library.animator.attention.TadaAnimator;
import com.github.hujiaweibujidao.library.animator.attention.WaveAnimator;
import com.github.hujiaweibujidao.library.animator.attention.WobbleAnimator;
import com.github.hujiaweibujidao.library.animator.bouncing_entrances.BounceInAnimator;
import com.github.hujiaweibujidao.library.animator.bouncing_entrances.BounceInDownAnimator;
import com.github.hujiaweibujidao.library.animator.bouncing_entrances.BounceInLeftAnimator;
import com.github.hujiaweibujidao.library.animator.bouncing_entrances.BounceInRightAnimator;
import com.github.hujiaweibujidao.library.animator.bouncing_entrances.BounceInUpAnimator;
import com.github.hujiaweibujidao.library.animator.fading_entrances.FadeInAnimator;
import com.github.hujiaweibujidao.library.animator.fading_entrances.FadeInDownAnimator;
import com.github.hujiaweibujidao.library.animator.fading_entrances.FadeInLeftAnimator;
import com.github.hujiaweibujidao.library.animator.fading_entrances.FadeInRightAnimator;
import com.github.hujiaweibujidao.library.animator.fading_entrances.FadeInUpAnimator;
import com.github.hujiaweibujidao.library.animator.fading_exits.FadeOutAnimator;
import com.github.hujiaweibujidao.library.animator.fading_exits.FadeOutDownAnimator;
import com.github.hujiaweibujidao.library.animator.fading_exits.FadeOutLeftAnimator;
import com.github.hujiaweibujidao.library.animator.fading_exits.FadeOutRightAnimator;
import com.github.hujiaweibujidao.library.animator.fading_exits.FadeOutUpAnimator;
import com.github.hujiaweibujidao.library.animator.flippers.FlipInXAnimator;
import com.github.hujiaweibujidao.library.animator.flippers.FlipInYAnimator;
import com.github.hujiaweibujidao.library.animator.flippers.FlipOutXAnimator;
import com.github.hujiaweibujidao.library.animator.flippers.FlipOutYAnimator;
import com.github.hujiaweibujidao.library.animator.rotating_entrances.RotateInAnimator;
import com.github.hujiaweibujidao.library.animator.rotating_entrances.RotateInDownLeftAnimator;
import com.github.hujiaweibujidao.library.animator.rotating_entrances.RotateInDownRightAnimator;
import com.github.hujiaweibujidao.library.animator.rotating_entrances.RotateInUpLeftAnimator;
import com.github.hujiaweibujidao.library.animator.rotating_entrances.RotateInUpRightAnimator;
import com.github.hujiaweibujidao.library.animator.rotating_exits.RotateOutAnimator;
import com.github.hujiaweibujidao.library.animator.rotating_exits.RotateOutDownLeftAnimator;
import com.github.hujiaweibujidao.library.animator.rotating_exits.RotateOutDownRightAnimator;
import com.github.hujiaweibujidao.library.animator.rotating_exits.RotateOutUpLeftAnimator;
import com.github.hujiaweibujidao.library.animator.rotating_exits.RotateOutUpRightAnimator;
import com.github.hujiaweibujidao.library.animator.sliders.SlideInDownAnimator;
import com.github.hujiaweibujidao.library.animator.sliders.SlideInLeftAnimator;
import com.github.hujiaweibujidao.library.animator.sliders.SlideInRightAnimator;
import com.github.hujiaweibujidao.library.animator.sliders.SlideInUpAnimator;
import com.github.hujiaweibujidao.library.animator.sliders.SlideOutDownAnimator;
import com.github.hujiaweibujidao.library.animator.sliders.SlideOutLeftAnimator;
import com.github.hujiaweibujidao.library.animator.sliders.SlideOutRightAnimator;
import com.github.hujiaweibujidao.library.animator.sliders.SlideOutUpAnimator;
import com.github.hujiaweibujidao.library.animator.specials.DropOutAnimator;
import com.github.hujiaweibujidao.library.animator.specials.HingeAnimator;
import com.github.hujiaweibujidao.library.animator.specials.LandingAnimator;
import com.github.hujiaweibujidao.library.animator.specials.RollInAnimator;
import com.github.hujiaweibujidao.library.animator.specials.RollOutAnimator;
import com.github.hujiaweibujidao.library.animator.specials.TakingOffAnimator;
import com.github.hujiaweibujidao.library.animator.zooming_entrances.ZoomInAnimator;
import com.github.hujiaweibujidao.library.animator.zooming_entrances.ZoomInDownAnimator;
import com.github.hujiaweibujidao.library.animator.zooming_entrances.ZoomInLeftAnimator;
import com.github.hujiaweibujidao.library.animator.zooming_entrances.ZoomInRightAnimator;
import com.github.hujiaweibujidao.library.animator.zooming_entrances.ZoomInUpAnimator;
import com.github.hujiaweibujidao.library.animator.zooming_exits.ZoomOutAnimator;
import com.github.hujiaweibujidao.library.animator.zooming_exits.ZoomOutDownAnimator;
import com.github.hujiaweibujidao.library.animator.zooming_exits.ZoomOutLeftAnimator;
import com.github.hujiaweibujidao.library.animator.zooming_exits.ZoomOutRightAnimator;
import com.github.hujiaweibujidao.library.animator.zooming_exits.ZoomOutUpAnimator;

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
