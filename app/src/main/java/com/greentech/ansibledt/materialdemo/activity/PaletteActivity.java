package com.greentech.ansibledt.materialdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.greentech.ansibledt.materialdemo.R;

public class PaletteActivity extends AppCompatActivity {


    private static final String TAG = "PaletteActivity";
    private ImageView mImage;
    private TextView mViewLB, mViewB, mViewDB, mViewLM, mViewM, mViewDM;


    private Palette mPalette;
    private Bitmap mBitmap;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_palette);

        initViews();
        initValues();
    }

    private void initViews() {
        mImage = (ImageView) findViewById(R.id.image);
        mViewLB = (TextView) findViewById(R.id.view_vibrant_light);
        mViewB = (TextView) findViewById(R.id.view_vibrant);
        mViewDB = (TextView) findViewById(R.id.view_vibrant_dark);
        mViewLM = (TextView) findViewById(R.id.view_muted_light);
        mViewM = (TextView) findViewById(R.id.view_muted);
        mViewDM = (TextView) findViewById(R.id.view_muted_dark);
    }


    private void initValues() {
        mBitmap = ((BitmapDrawable) mImage.getDrawable()).getBitmap();
//        BitmapFactory.decodeResource(getResources().getDrawable(), R.drawable.toolbar);
//        BitmapFactory.de

        //同步的synchronously
        Palette.Builder builder =  Palette.from(mBitmap);
//        mPalette = builder.generate();


        //异步的AsyncTask
        builder.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch1 = checkVibrantSwatch(palette);
                if (swatch1 != null){
                    mViewB.setBackgroundColor(swatch1.getRgb());
                    Log.d(TAG, "rgb = "+swatch1.getRgb());
                    Log.d(TAG, "text = "+swatch1.getBodyTextColor());
                    Log.d(TAG, "title = "+swatch1.getTitleTextColor());
                }


                Palette.Swatch swatch2 = checkLightVibrantSwatch(palette);
                if (swatch2 != null){
                    mViewLB.setBackgroundColor(swatch2.getRgb());
                }

                Palette.Swatch swatch3 = checkDarkVibrantSwatch(palette);
                if (swatch3 != null){
                    mViewDB.setBackgroundColor(swatch3.getRgb());
                }

                Palette.Swatch swatch4 = checkLightMutedSwatch(palette);
                if (swatch4 != null){
                    mViewLM.setBackgroundColor(swatch4.getRgb());
                }

                Palette.Swatch swatch5 = checkMutedSwatch(palette);
                if (swatch5 != null){
                    mViewM.setBackgroundColor(swatch5.getRgb());
                }
                Palette.Swatch swatch6 = checkDarkMutedSwatch(palette);
                if (swatch6 != null){
                    mViewDM.setBackgroundColor(swatch6.getRgb());
                }
            }
        });

    }



    @Override
    protected void onResume() {
        super.onResume();


    }






    /**
     * 获取6种颜色开关以获取颜色(每种开关又包含3种颜色，Rgb, bodyColor 和  TitleColor)

     * getBodyTextColor();      //适用于描述文字
     * getRgb();                //主要颜色  适用于设置toolbar颜色
     * getTitleTextColor();     //适合toolbar标题颜色
     */


    /**
     * 1. 明亮
     * @param p
     * @return
     */
    private Palette.Swatch checkVibrantSwatch(Palette p) {
        Palette.Swatch vibrant = p.getVibrantSwatch();
        if (vibrant != null) {
            return vibrant;
        }

        // Throw error
        return null;
    }

    /**
     * 2.Light明亮
     * @param p
     * @return
     */
    private Palette.Swatch checkLightVibrantSwatch(Palette p) {
        Palette.Swatch vibrant = p.getLightVibrantSwatch();
        if (vibrant != null) {
            return vibrant;
        }
        // Throw error
        return null;
    }

    /**
     * 3. Dark明亮
     * @param p
     * @return
     */
    private Palette.Swatch checkDarkVibrantSwatch(Palette p) {
        Palette.Swatch vibrant = p.getDarkVibrantSwatch();
        if (vibrant != null) {
            return vibrant;
        }
        // Throw error
        return null;
    }

    /**
     * 4.柔和
     * @param p
     * @return
     */
    private Palette.Swatch checkMutedSwatch(Palette p) {
        Palette.Swatch vibrant = p.getMutedSwatch();
        if (vibrant != null) {
            return vibrant;
        }
        // Throw error
        return null;
    }


    /**
     * 5.Light柔和
     * @param p
     * @return
     */
    private Palette.Swatch checkLightMutedSwatch(Palette p) {
        Palette.Swatch vibrant = p.getLightMutedSwatch();
        if (vibrant != null) {
            return vibrant;
        }
        // Throw error
        return null;
    }


    /**
     * 6.Dark柔和
     * @param p
     * @return
     */
    private Palette.Swatch checkDarkMutedSwatch(Palette p) {
        Palette.Swatch vibrant = p.getDarkMutedSwatch();
        if (vibrant != null) {
            return vibrant;
        }
        // Throw error
        return null;
    }
    }
