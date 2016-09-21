package com.greentech.ansibledt.materialdemo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.greentech.ansibledt.materialdemo.R;

/**
 * Created by JerryYin on 9/20/16.
 */
public class PageThreeFragment extends Fragment {


    /**Constants*/
    private View mContentView;
    private Activity mSelf;


    private TextView mText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null != mContentView){
            ViewGroup vg = (ViewGroup) mContentView.getParent();
            if (null != vg){
                vg.removeView(mContentView);
            }
        }else {mSelf = getActivity();
            mContentView = inflater.inflate(R.layout.layout_fragment, null);
            mSelf = getActivity();
            setupViews();
        }
        return mContentView;

    }

    private void setupViews() {
        mText = (TextView) mContentView.findViewById(R.id.text);
        mText.setText("PageThree");
    }



}
