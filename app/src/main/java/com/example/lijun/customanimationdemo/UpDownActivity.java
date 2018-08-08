package com.example.lijun.customanimationdemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by lijun on 18-1-2.
 */

public class UpDownActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vic);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.activity_down_exit_anim);
    }
}
