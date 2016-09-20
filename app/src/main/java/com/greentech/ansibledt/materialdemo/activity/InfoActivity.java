package com.greentech.ansibledt.materialdemo.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.greentech.ansibledt.materialdemo.R;

public class InfoActivity extends AppCompatActivity {

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayout_info);

//        this.setActionBar(new Toolbar(this));
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        ActivityCompat.finishAfterTransition(this);
    }
}
