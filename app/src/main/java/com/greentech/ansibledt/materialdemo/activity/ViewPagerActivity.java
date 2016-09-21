package com.greentech.ansibledt.materialdemo.activity;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.greentech.ansibledt.materialdemo.R;
import com.greentech.ansibledt.materialdemo.fragment.PageOneFragment;
import com.greentech.ansibledt.materialdemo.fragment.PageThreeFragment;
import com.greentech.ansibledt.materialdemo.fragment.PageTwoFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private PagerTitleStrip mTitleStrip;

    private List<Fragment> mFragmentList;
    private String[] mTitleList =  new String[]{"Page1", "Page2", "Page3"};

    private MyPagerFragmentAdapter mPagerAdapter;
//    private MyPagerAdapter mPagerAdapter;

//    private final ActionBar mActionBar = getActionBar();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_pager);

        initVews();
    }

    private void initVews() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
//        mTitleStrip = (PagerTitleStrip) findViewById(R.id.title_strip);
//        mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        mActionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

        mFragmentList = new ArrayList<>();
        PageOneFragment pageOne = new PageOneFragment();
        PageTwoFragment pageTwo = new PageTwoFragment();
        PageThreeFragment pageThree = new PageThreeFragment();
        mFragmentList.add(pageOne);
        mFragmentList.add(pageTwo);
        mFragmentList.add(pageThree);

        mPagerAdapter = new MyPagerFragmentAdapter(getSupportFragmentManager(), this, mFragmentList, mTitleList);
        mViewPager.setAdapter(mPagerAdapter);

        //绑定viewpager 和 tablayout 两种方式
//        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setupWithViewPager(mViewPager);

    }


    /**
     * 基础版本适配器
     */
    public class MyPagerFragmentAdapter extends FragmentPagerAdapter{

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


//    public static class MyPagerAdapter extends FragmentPagerAdapter implements android.support.v7.app.ActionBar.TabListener, ViewPager.OnPageChangeListener{
//
//        private final Context mContext;
//        private final ActionBar mBar;
//        private final ViewPager mPager;
//        private final ArrayList<TabInfo> mTabInfos = new ArrayList<>();
//
//
//        static final class  TabInfo{
//            private final Class<?> aClass;
//            private final Bundle bundle;
//
//            public TabInfo(Class<?> aClass, Bundle bundle) {
//                this.aClass = aClass;
//                this.bundle = bundle;
//            }
//        }
//
//        public MyPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        public MyPagerAdapter(Activity activity, ViewPager pager) {
//            super(activity.getFragmentManager());
//            this.mContext =activity;
//            this.mPager = pager;
//            mBar = activity.getActionBar();
//            mPager = pager;
//            mPager.setAdapter(this);
//            mPager.setOnPageChangeListener(this);
//
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public int getCount() {
//            return 0;
//        }
//
//
//
//        /****************OnPageChangeListener******************/
//
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//
//
//        /****************TabListener******************/
//
//        @Override
//        public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {
//
//        }
//
//        @Override
//        public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {
//
//        }
//
//        @Override
//        public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction ft) {
//
//        }
//    }

}
