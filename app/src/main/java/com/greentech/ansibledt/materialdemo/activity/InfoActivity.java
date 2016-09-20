package com.greentech.ansibledt.materialdemo.activity;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toolbar;

import com.greentech.ansibledt.materialdemo.R;

public class InfoActivity extends AppCompatActivity {



    TextView titleView = null;
    Bitmap bitmap =null;

//    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayout_info);

//        this.setActionBar(new Toolbar(this));

        initViews();
    }

    private void initViews() {



    }

    /**
     * com.android.support:palette-v7
     * 调色板使用方法
     * 根据图片来自动调整内容色调
     */
    public void palette(){
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {

                //一个采集的样本
                Palette.Swatch swatch =
                        palette.getVibrantSwatch();

                Palette.Swatch swatch1 = palette.getDarkVibrantSwatch();

                if (swatch != null) {
                    // If we have a vibrant color
                    // update the title TextView
                    titleView.setBackgroundColor(
                            swatch.getRgb());
                    titleView.setTextColor(
                            swatch.getTitleTextColor());
                }
            }
        });
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCompat.finishAfterTransition(this);
    }

}
