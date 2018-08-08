package com.example.lijun.customanimationdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by lijun on 18-1-5.
 */

public class SelfCenterExitActivity extends Activity {

    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vic);
        btnClick = findViewById(R.id.btn_click);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLeft = new Intent(SelfCenterExitActivity.this, LeftRightActivity.class);
                startActivity(intentLeft);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(0, R.anim.activity_close_exit_left_anim);
    }
}
