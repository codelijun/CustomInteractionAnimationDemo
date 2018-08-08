package com.example.lijun.customanimationdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by lijun on 18-1-2.
 */

public class FlowView extends LinearLayout {
    public FlowView(Context context) {
        this(context, null);
    }

    public FlowView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater mLayoutInflater = LayoutInflater.from(context);
        mLayoutInflater.inflate(R.layout.activity_vic, this);
    }
}
