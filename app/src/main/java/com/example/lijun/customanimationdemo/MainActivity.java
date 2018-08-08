package com.example.lijun.customanimationdemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final boolean DEBUG = true;
    public static final String BROADCAST_ACTION = "BroadcastAction";
    private static final String TAG = "MainActivity";
    private Button animatorLeftRight;
    private Button animatorUpDown;
    private Button animatorScale;
    private Button animatorSelfScale;
    private Button customAnimator;
    private Button closeExitCenter;

    private String VIEW_INFO_EXTRA = "view_info_extra";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animatorSelfScale = findViewById(R.id.scale_self_btn);
        animatorLeftRight = findViewById(R.id.left_right_btn);
        animatorUpDown = findViewById(R.id.up_down_btn);
        animatorScale = findViewById(R.id.scale_btn);
        customAnimator = findViewById(R.id.custom_animator);
        closeExitCenter = findViewById(R.id.exit_close_center);
        closeExitCenter.setOnClickListener(this);
        customAnimator.setOnClickListener(this);
        animatorLeftRight.setOnClickListener(this);
        animatorUpDown.setOnClickListener(this);
        animatorScale.setOnClickListener(this);
        animatorSelfScale.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_right_btn:
                Intent intentLeft = new Intent(MainActivity.this, LeftRightActivity.class);
                startActivity(intentLeft);
                overridePendingTransition(R.anim.activity_open_enter_left_right_anim, R.anim.activity_open_exit_left_right_anim);
                break;
            case R.id.up_down_btn:
                Intent intentUp = new Intent(MainActivity.this, UpDownActivity.class);
                startActivity(intentUp);
                overridePendingTransition(R.anim.activity_down_enter_anim, R.anim.acitivity_open_exit_anim);
                break;
            case R.id.exit_close_center:
                Intent intentScaleCenter = new Intent(MainActivity.this, SelfCenterExitActivity.class);
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    ActivityOptions activityOptions = ActivityOptions.makeClipRevealAnimation(v, 0, 0, v.getWidth(), v.getHeight());
//                    startActivity(intentScaleCenter, activityOptions.toBundle());
//                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                    ActivityOptions activityOptions = ActivityOptions.makeScaleUpAnimation(v, 0, 0, v.getWidth(), v.getHeight());
//                    startActivity(intentScaleCenter, activityOptions.toBundle());
//                }else{
//                    API==15 设置一个固定的动画
                    startActivity(intentScaleCenter);
//                }
                break;
            case R.id.scale_btn:
                Intent intentScale = new Intent(MainActivity.this, ScaleActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    ActivityOptions activityOptions = ActivityOptions.makeClipRevealAnimation(v, 0, 0, v.getWidth(), v.getHeight());
                    startActivity(intentScale, activityOptions.toBundle());
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    ActivityOptions activityOptions = ActivityOptions.makeScaleUpAnimation(v, 0, 0, v.getWidth(), v.getHeight());
                    startActivity(intentScale, activityOptions.toBundle());
                }else{
                    //API==15 设置一个固定的动画
                    startActivity(intentScale);
                }
                break;
            case R.id.scale_self_btn:
                Intent intentSelfScale = new Intent(MainActivity.this, SelfScaleActivity.class);
                    ActivityOptions activityOptions = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activityOptions = ActivityOptions.makeSceneTransitionAnimation(this, v, "shared_name");
                        startActivity(intentSelfScale, activityOptions.toBundle());
                    } else{
                    startActivity(intentSelfScale);
                }
                break;
            case R.id.custom_animator:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, CustomSharedActivity.class);
                intent.putExtra(VIEW_INFO_EXTRA, createViewInfoBundle(v));
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;
            default:
                break;

        }
    }

    private Bundle createViewInfoBundle(View view) {
        int[] screenLocation = new int[2];
        view.getLocationOnScreen(screenLocation);
        Bundle b = new Bundle();
        int left = screenLocation[0];
        int top = screenLocation[1];
        int width = view.getWidth();
        int height = view.getHeight();
        b.putInt("left", left);
        b.putInt("top", top);
        b.putInt("width", width);
        b.putInt("height", height);
        return b;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(0, R.anim.activity_down_exit_anim);
    }
}
