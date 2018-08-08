package com.example.lijun.customanimationdemo;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.transition.Explode;
import android.util.Log;
import android.view.Window;


/**
 * Created by lijun on 18-1-3.
 */

public class SelfScaleActivity extends Activity {

    ConstraintLayout constraintLayout;

    boolean DEBUG = true;
    String TAG = "SelfScaleActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vic);
        constraintLayout = findViewById(R.id.layout_vic);
    }

    @Override
    public void finish() {
        super.finish();
        if (DEBUG) {
            Log.d(TAG, " finish() ");
        }
//        overridePendingTransition(0, R.anim.activity_exit_alpha_anim);
    }
}
