package com.example.lijun.customanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by lijun on 18-1-4.
 */

public class CustomSharedActivity extends Activity {
    boolean DEBUG = true;
    String TAG = "CustomSharedActivity";

    private ConstraintLayout layout;
    private int originViewLeft;
    private int originViewTop;
    private int originViewWidth;
    private int originViewHeight;
    private float scaleX;
    private float scaleY;
    private int deltaX;
    private int deltaY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vic);
        layout = findViewById(R.id.layout_vic);
        extractViewInfoFromBundle(getIntent());
        onUiReady();
    }

    private void extractViewInfoFromBundle(Intent intent) {
        Bundle bundle = intent.getBundleExtra("view_info_extra");
        originViewLeft = bundle.getInt("left");
        originViewTop = bundle.getInt("top");
        originViewWidth = bundle.getInt("width");
        originViewHeight = bundle.getInt("height");
    }

    private void onUiReady() {
        layout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                // remove previous listener
                layout.getViewTreeObserver().removeOnPreDrawListener(this);
                //准备场景
                prepareScene();
                //播放动画
                runEnterAnimation();
                return true;
            }
        });
    }

    private void prepareScene() {
        //移动到起始view位置
        deltaX = originViewLeft - (layout.getWidth() - layout.getLeft())/2 + originViewWidth/2;
        deltaY = originViewTop - (layout.getHeight() - layout.getTop())/2;

        layout.setTranslationX(deltaX);
        layout.setTranslationY(deltaY);
        //缩放到起始view大小
        scaleX = (float) originViewWidth / layout.getWidth();
        scaleY = (float) originViewHeight / layout.getHeight();
        layout.setScaleX(scaleX);
        layout.setScaleY(scaleY);
    }

    private void runEnterAnimation() {
        layout.setAlpha(0f);
        //执行动画
        layout.animate()
                .setDuration(150)
                .scaleX(1f)
                .alpha(1f)
                .scaleY(1f)
                .setInterpolator(new LinearInterpolator())
                .translationX(0)
                .translationY(0)
                .start();

    }



    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        runExitAnimation();
    }

    private void runExitAnimation() {
            ViewPropertyAnimator viewPropertyAnimator = layout.animate();
            viewPropertyAnimator.setDuration(150)
                    .scaleX(scaleX)
                    .scaleY(scaleY)
                    .alpha(0)
                    .setInterpolator(new LinearInterpolator())
                    .translationX(deltaX)
                    .translationY(deltaY)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            finish();
                        }
                    });
            viewPropertyAnimator.start();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
