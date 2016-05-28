package com.github.hujiaweibujidao.viewanimation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.github.hujiaweibujidao.viewanimation.R;
import com.github.hujiaweibujidao.library.EasingFunction;
import com.github.hujiaweibujidao.viewanimation.view.CursorView;
import com.github.hujiaweibujidao.viewanimation.view.InterpolatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * Interpolator list adapter
 * <p/>
 */
public class InterpolatorAdapter extends BaseAdapter {

    private int mSelectIndex = -1;
    private long mDuration;
    private LayoutInflater mInflater;
    private List<String> mNames;
    private EasingFunction[] mInterpolators;

    public InterpolatorAdapter(Context context, long duration) {
        mInflater = LayoutInflater.from(context);
        mDuration = duration;

        mInterpolators = EasingFunction.values();
        mNames = new ArrayList<String>();
        for (EasingFunction function : EasingFunction.values()) {
            mNames.add(function.name());
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder = null;
        if (convertView == null) {
            mHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.adapter, null);
            mHolder.interpolatorName = (TextView) convertView.findViewById(R.id.name);
            mHolder.interpolatorView = (InterpolatorView) convertView.findViewById(R.id.view);
            mHolder.cursor = (CursorView) convertView.findViewById(R.id.cursor);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }

        final Interpolator interpolator = mInterpolators[position];
        mHolder.interpolatorName.setText(String.format("%s Interpolator", mNames.get(position).replace("_", " ")));
        mHolder.interpolatorView.setDurationAndInterpolator(mDuration, interpolator);//

        int bottomMargin = mHolder.interpolatorView.blankTB - mHolder.cursor.height / 2;
        LayoutParams params = (LayoutParams) mHolder.cursor.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.view);
        params.bottomMargin = bottomMargin;
        mHolder.cursor.setLayoutParams(params);

        //选定项开始做Ease动画，这里操控cursorview使用的只是普通的位移动画而已
        if (position == mSelectIndex) {
            int toYDelta = mHolder.interpolatorView.height - 2 * mHolder.interpolatorView.blankTB;
            Animation anim = new TranslateAnimation(0, 0, 0, -toYDelta);
            anim.setDuration(mDuration);
            anim.setInterpolator(interpolator);
            anim.setStartOffset(300);
            mHolder.cursor.startAnimation(anim);
            mSelectIndex = -1;
        }

        return convertView;
    }

    public void setSelectIndex(int index) {
        mSelectIndex = index;
        notifyDataSetChanged();
    }

    private class ViewHolder {
        public TextView interpolatorName;
        public InterpolatorView interpolatorView;
        public CursorView cursor;
    }

    @Override
    public int getCount() {
        return mInterpolators == null ? 0 : mInterpolators.length;
    }

    @Override
    public Object getItem(int position) {
        return mInterpolators == null ? null : mInterpolators[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}