package com.example.mads.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mads.Adapters.storiesadapter;
import com.example.mads.Models.stories;
import com.example.mads.R;

import java.util.ArrayList;
import java.util.List;

public class MentorListActivity extends AppCompatActivity {
   RecyclerView storiesRecyclerview;
   storiesadapter adapt;
   List<stories> mData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_list);

        Toolbar Stoolbar = findViewById(R.id.mentorlisttoolbar);
        setSupportActionBar(Stoolbar);
        getSupportActionBar().setTitle("LIFE STORIES");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Stoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MentorListActivity.this, Home.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });


        //
        storiesRecyclerview = findViewById(R.id.stories_recycler);
        mData = new ArrayList<>();

        mData.add(new stories("John, This is my story","My goal in life wasn't living...it was getting high. I was falling in a downward spiral towards a point of no return. Over the years, I turned to cocaine, marijuana and alcohol under a false belief it would allow me to escape my problems. It just made things worse.I kept saying to myself, I’m going to stop permanently after using this last time. It never happened.There were even moments I had thought of giving up on life.But he best decision I ever made was accepting that I needed help. ","6 th july 2018",R.drawable.pumpkin));
        mData.add(new stories("Ben, This is my story","It started with the weed, then the pills, making cocktails of all sorts of drugs, even overdosing to make the rushes last longer.This was until I had a bad trip one night and went into toxic psychosis. I prayed and cried for this feeling to go away, I had voices in my head, had the shakes and couldn't leave home for six months. I became very withdrawn and thought everyone was watching me.I decided that I had had enough and realized that I could want life more.","6/7/2018",R.drawable.pumpkin));

        mData.add(new stories("Debby This is my story","I borrowed a friend’s ADHD medication to stay focused on a test. That was the beginning of the end. At first, the signs were subtle: new friends, later returns home, excuses but this was until i was arrested for bringing drugs to school and sent to court, where a police officer recommended me to a rehabilitation center.I don’t know what to tell people other than to seek help, seek help for themselves, I know it gets frustrating sometimes but the family and a good support system are so vital to their getting better. Don’t give up.","09/10/ 2019",R.drawable.pumpkin));
        mData.add(new stories("Miriam, THis is my story","I started suffering from undiagnosed anxiety, depression, post-traumatic stress disorder (PTSD) and schizophrenia, which produced audio and visual hallucinations.I started drinking to quiet the voices, It worked, at first When I later sought professional help, i was prescribed antipsychotics. i maintained a period of sobriety until the symptoms worsened and she turned back to alcohol. One day, albeit still afraid. i searched . online for alcohol treatment near me.","11/10/2019",R.drawable.pumpkin));
        mData.add(new stories("Nick, This is my story","Addiction was nothing new to me. my father drank routinely, and after watching my family fall apart, i told myself i would never drink or do drugs. Yet, as the stress of school, friends and the pressure to fit in grew stronger, i fell victim to the disease of addiction. Beginning in the ninth grade, i connected with a new crowd that introduced me to drugs. At 17, my habit had already spun out of control. As the days passed, i found myself living in my car or in jail. i overdosed eight or nine times but after treatment, I am back in school and giving back.","12/10/2019",R.drawable.pumpkin));
        mData.add(new stories("James, This is my story","But that’s not the case for so many of those stigmatized by shame and guilt, and unwilling to step out of the shadows and own their story. That’s why I have become resolute in my mission to offer transparency and hope as a recovery advocate. In truth, I receive several hundred messages daily from substance users wanting to break the cycle of addiction, and most are living the . same suburban drug dependence nightmare.My addiction didn’t happen overnight; it started with a few innocent pills.","13/10/2019",R.drawable.pumpkin));
        mData.add(new stories("Mary, THis is my story","Feelings of isolation, fear, lack of control and failure were all too familiar for me. I found comfort in alcohol and drugs at age 15. I was attracted to the culture and the people who smoked marijuana, but what started as a leisurely activity soon got out of hand. until an officer told me that i should look into a rehab. I was done living in fear.I finally accepted my addiction,Now a straight-A student.","14/10/2019",R.drawable.pumpkin));
        mData.add(new stories("Mike, This is my story","Drinking began for me when i was working at a liquor store at age 13. my friend’s father owned a store, and i was responsible for stocking the shelves and checking inventory. It was easy to steal a bottle here and there because i was the one in charge. As the years passed,i began experimenting with inhalants; as the highs became less intense, Things only got worse.at one time i was left to die in a basement after overdosing. Realizing i needed help, i decided it was time. Rehabs have the ability to rid you of the image you had.","15/10/2019",R.drawable.pumpkin));
        mData.add(new stories("Kevin, THis is my story","Addiction destroyed everything,it is a brain disease; it is not an issue of moral failing or willpower.I’ve been sober for two and a half years… I have a great job that has insurance and benefits and the whole works… It’s a total turnaround from who I was to who I am today… I gave this thing a shot and I actually gave myself that chance.There is fun in sobriety.","16/10/2019",R.drawable.pumpkin));
        mData.add(new stories("Mathew, THis is my story","i drank, and although i considered my drinking recreational,i would occasionally embarrass myself or upset others while intoxicated.my drinking escalated over time.I was extremely depressed, drinking at work during the day. Things were not good.I went to as rehabilitation center and it was a great reset button.","17/10/2019",R.drawable.pumpkin));
        mData.add(new stories("Craig, This is my story","I’m in the ring and I’m not even swinging anymore – just taking punches, and I’m wondering why nobody threw in the towel, why nobody’s helping me. I turn around and look in my corner and I notice there’s nobody there, nobody at the fight with me. So I had the bright idea to get out of the ring.Participating in treatment was one of the best experiences of my life.","6 th july 2018",R.drawable.pumpkin));
        mData.add(new stories("Paul, THis is my story","What I have come to believe is that it doesn't matter how old you are, how much you drank or used, the color of your skin, what you believe or don't believe, you can practice these principles of life.I took copious amounts of these chemicals every day for as long as two years.I ended up homeless and on the streets, living and sleeping in a cardboard box, begging and struggling to find ways to get my next meal.While observing these homeless people I decided that I had had enough.","7/08/2018",R.drawable.pumpkin));
        mData.add(new stories("Peggy, This is my story","If you read this and you think you have a problem, chances are you do. Please do not let your fear and your denial get in the way of your recovery. I did not live to live life without drugs. I lived so that I could help others like myself.I had everything, a good job, money, a loving family, yet I felt so empty inside. As if I had nothing.","08/09/2018",R.drawable.pumpkin));

        //adapter
        adapt = new storiesadapter(this,mData);
        storiesRecyclerview.setAdapter(adapt);
        storiesRecyclerview.setLayoutManager(new LinearLayoutManager(this));






    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back:
                startActivity(new Intent(MentorListActivity.this, Home.class));
                finish();
                return true;
        }
        return false;
    }*/
}