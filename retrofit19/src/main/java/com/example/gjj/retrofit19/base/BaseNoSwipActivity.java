package com.example.gjj.retrofit19.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;

import com.example.gjj.retrofit19.R;

/**
 * 作者：gjj on 2015/12/1 18:29
 * 邮箱：Gujj512@163.com
 */
public class BaseNoSwipActivity extends FragmentActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }
    // Press the back button in mobile phone
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }
}
