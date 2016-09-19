package com.greentech.ansibledt.materialdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.greentech.ansibledt.materialdemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private CardView mCardView1, mCardView2, mCardView3, mCardView4, mCardView5;
    private TextView mTextView4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        initViews();
    }

    private void initViews() {
        mCardView1 = (CardView) findViewById(R.id.card1);
        mCardView2 = (CardView) findViewById(R.id.card2);
        mCardView3 = (CardView) findViewById(R.id.card3);
        mCardView4 = (CardView) findViewById(R.id.card4);
        mTextView4 = (TextView) findViewById(R.id.text4);

        mCardView1.setOnClickListener(this);
        mCardView2.setOnClickListener(this);
        mCardView3.setOnClickListener(this);
        mCardView4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card1:
//                Intent intent = new Intent(this, InfoActivity.class);
//                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.translate_in, R.anim.translate_none);
//                ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
                break;

            case R.id.card2:
                //放大
                Intent intent2 = new Intent(this, InfoActivity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(mCardView2, mCardView2.getWidth()/2, mCardView2.getHeight()/2, 0, 0);
                ActivityCompat.startActivity(this, intent2, optionsCompat.toBundle());
                break;

            case R.id.card3:
                //场景动画1  单一的view
                Intent intent3 = new Intent(this, InfoActivity.class);
                ActivityOptionsCompat optionsCompat3 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, mCardView3, getString(R.string.transition));
                ActivityCompat.startActivity(this, intent3, optionsCompat3.toBundle());
                break;

            case R.id.card4:
                //场景动画2  多个view 分别绑定对应的 transitionName
                Intent intent4 = new Intent(this, InfoActivity2.class);
                Pair<View, String> cardPair = Pair.create( ((View)mCardView4), getString(R.string.transition));
                Pair<View, String> textPair = Pair.create(((View)mTextView4), getString(R.string.transition_name));

                ActivityOptionsCompat optionsCompat4 = ActivityOptionsCompat.makeSceneTransitionAnimation(this, cardPair, textPair);
                ActivityCompat.startActivity(this, intent4, optionsCompat4.toBundle());
                break;

//            case R.id.card5:
//
//                break;
        }

    }
}
