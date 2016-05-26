package com.github.hujiaweibujidao.library.animator;

import android.view.View;

import com.github.hujiaweibujidao.library.BaseViewAnimator;
import com.github.hujiaweibujidao.library.Glider;
import com.github.hujiaweibujidao.library.Skill;
import android.animation.ObjectAnimator;

public class TakingOffAnimator extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorSet().playTogether(
                Glider.glide(Skill.QuintEaseOut, getAnimatorSet().getDuration(), ObjectAnimator.ofFloat(target, "scaleX", 1f, 1.5f)),
                Glider.glide(Skill.QuintEaseOut, getAnimatorSet().getDuration(), ObjectAnimator.ofFloat(target, "scaleY", 1f, 1.5f)),
                Glider.glide(Skill.QuintEaseOut, getAnimatorSet().getDuration(), ObjectAnimator.ofFloat(target, "alpha", 1, 0))
        );
    }
}
