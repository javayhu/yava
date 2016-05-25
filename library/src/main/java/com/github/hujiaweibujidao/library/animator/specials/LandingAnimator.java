package com.github.hujiaweibujidao.library.animator.specials;

import android.view.View;

import com.github.hujiaweibujidao.library.BaseViewAnimator;
import com.github.hujiaweibujidao.library.Glider;
import com.github.hujiaweibujidao.library.Skill;
import android.animation.ObjectAnimator;

public class LandingAnimator extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorSet().playTogether(
                Glider.glide(Skill.QuintEaseOut, getAnimatorSet().getDuration(), ObjectAnimator.ofFloat(target, "scaleX", 1.5f, 1f)),
                Glider.glide(Skill.QuintEaseOut, getAnimatorSet().getDuration(), ObjectAnimator.ofFloat(target, "scaleY", 1.5f, 1f)),
                Glider.glide(Skill.QuintEaseOut, getAnimatorSet().getDuration(), ObjectAnimator.ofFloat(target, "alpha", 0, 1f))
        );
    }
}
