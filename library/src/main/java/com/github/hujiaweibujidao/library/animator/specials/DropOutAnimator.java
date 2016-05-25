package com.github.hujiaweibujidao.library.animator.specials;

import android.view.View;

import com.github.hujiaweibujidao.library.BaseViewAnimator;
import com.github.hujiaweibujidao.library.Glider;
import com.github.hujiaweibujidao.library.Skill;
import android.animation.ObjectAnimator;

public class DropOutAnimator extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        int distance = target.getTop() + target.getHeight();
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(target, "alpha", 0, 1),
                Glider.glide(Skill.BounceEaseOut, getAnimatorSet().getDuration(), ObjectAnimator.ofFloat(target, "translationY", -distance, 0))
        );
    }
}
