package com.greentech.ansibledt.materialdemo.activity;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.greentech.ansibledt.materialdemo.R;

public class InfoActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_info2);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        ActivityCompat.finishAfterTransition(this);
    }
}
