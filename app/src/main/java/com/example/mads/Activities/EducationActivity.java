package com.example.mads.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mads.Adapters.EDUAdapter;
import com.example.mads.R;

public class EducationActivity extends AppCompatActivity {

    private ViewPager eslideviewPager;
    private LinearLayout eDotLayout;
    private TextView[] mDots;

    private EDUAdapter eduAdapter;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        eslideviewPager = (ViewPager) findViewById(R.id.eduviewpager);
        eDotLayout = (LinearLayout) findViewById(R.id.edudotslayout);
        eduAdapter = new EDUAdapter(this);
        eslideviewPager.setAdapter(eduAdapter);

        addDotsIndicator(0);
        eslideviewPager.addOnPageChangeListener(viewListener);

        Toolbar mentor_toolbar = findViewById(R.id.edutoolbar);
        setSupportActionBar(mentor_toolbar);
        getSupportActionBar().setTitle("DRUGS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mentor_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EducationActivity.this, Home.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }

    private void addDotsIndicator(int position) {
        mDots = new TextView[8];
        eDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.green));

            eDotLayout.addView(mDots[i]);

        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        };

 /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                startActivity(new Intent(EducationActivity.this, Home.class));
                finish();
                return true;
        }
        return false;
    }*/

    }
