package com.example.lijun.customanimationdemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by lijun on 18-1-2.
 */

public class LeftRightActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_third_activity);
    }


    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(R.anim.activity_close_enter_left_anim, R.anim.activity_close_exit_left_anim);
    }
}
