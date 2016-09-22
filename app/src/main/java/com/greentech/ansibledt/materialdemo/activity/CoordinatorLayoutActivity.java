package com.greentech.ansibledt.materialdemo.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.greentech.ansibledt.materialdemo.R;
import com.greentech.ansibledt.materialdemo.fragment.PageFourFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JerryYin on 9/21/16.
 */
public class CoordinatorLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private FloatingActionButton mActionButton;

    private List<Fragment> mFragmentList;
    private String[] mTitleList =  new String[]{"Page1", "Page2", "Page3"};
    private MyPagerFragmentAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_coordinator);

        //去掉系统的ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        initViews();

    }


    @TargetApi(Build.VERSION_CODES.M)
    private void initViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mActionButton = (FloatingActionButton) findViewById(R.id.fab);

        mActionButton.setOnClickListener(this);

        //把当前的toolbar设置为actionbar， 接着再重新获取actionbar进行属性设置
//        setSupportActionBar(mToolbar);
//        ActionBar actionBar = getSupportActionBar();
        mToolbar.setTitle("CoordinatorLayout");
        mToolbar.setLogo(android.R.drawable.ic_dialog_dialer);
        mToolbar.setSubtitle("Subtitle");
        mToolbar.setTitleTextAppearance(this, android.R.style.TextAppearance_Holo_Widget_ActionBar_Title);
        mToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        mToolbar.setSubtitleTextColor(getResources().getColor(R.color.white));
//        actionBar.setDisplayHomeAsUpEnabled(true);  //设置返回箭头
//        mToolbar.setDisplayUseLogoEnabled(false);  //设置是否显示logo
//        actionBar.setHomeAsUpIndicator(android.R.drawable.ic_lock_power_off);

        mFragmentList = new ArrayList<>();
        mFragmentList.add(new PageFourFragment());
        mFragmentList.add(new PageFourFragment());
        mFragmentList.add(new PageFourFragment());

        mPagerAdapter = new MyPagerFragmentAdapter(getSupportFragmentManager(), this, mFragmentList, mTitleList);

        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                Toast.makeText(this, "toast fab", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    /**
     * viewpager本适配器
     */
    public class MyPagerFragmentAdapter extends FragmentPagerAdapter {

        private Context mContext;
        private List<Fragment> mFragments;
        private String[] mTitles;

        public MyPagerFragmentAdapter(FragmentManager fm, Context mContext, List<Fragment> mFragments, String[] titles) {
            super(fm);
            this.mContext = mContext;
            this.mFragments = mFragments;
            this.mTitles = titles;
        }



        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }

}
