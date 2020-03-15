package com.example.mads.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mads.Adapters.RsAdapter;
import com.example.mads.R;

import java.util.Timer;
import java.util.TimerTask;

public class RehabActivity extends AppCompatActivity {


    int[] IMAGE1 = {R.drawable.loca,R.drawable.loca,R.drawable.loca,R.drawable.loca,R.drawable.loca,R.drawable.loca,R.drawable.loca,R.drawable.loca,R.drawable.loca,R.drawable.loca};
    int[] IMAGE2 = {R.drawable.telephone,R.drawable.telephone,R.drawable.telephone,R.drawable.telephone,R.drawable.telephone,R.drawable.telephone,R.drawable.telephone,R.drawable.telephone,R.drawable.telephone,R.drawable.telephone};
    int[] IMAGE3 = {R.drawable.web2,R.drawable.web2,R.drawable.web2,R.drawable.web2,R.drawable.web2,R.drawable.web2,R.drawable.web2,R.drawable.web2,R.drawable.web2,R.drawable.web2};
    String[] NAME = {"SAPTA","NAIROBI PLACE","JORGS","MEWA","ASUMBI","TUMAINI","The retreat rehab centre","Fountain of Hope","K.N.H","Freedom r.centre"};
    String[] description1 = {"P.O BOX 21761-00505, Nairobi","P.O BOX 139-00502 Nairobi","Limuru RD,Tigoni,Kenya","Majengo,Mombasa-80100,Kenya","P.O.BOX 49, Asumbi 40309, HomaBay","P.O BOX: 578-00618, Ruaraka Nirobi","P.O BOX 1501-00606, Nairobi","Nairobi","P.O BOX 20723-00202","KIAMBU 2088, Kenya"};
    String[] description2 = {"0203875045, 0722216032","+254-735550000","+254-713692848","254-800-7878","+254-736091565","+254-721277847,0722695347","0723565529","+254-796656300","020-2726300, 070985400","+254-0720277447"};
    String[] description3 = {"sapta.or.ke","nairobi-place.com","jorgs.org","email: secretariat@mewa.com","asumbi-tcentre.org","Email: tumainitrcc@yahoo.com","theretreatkenya.org","Email: info@fountainofhoperehab.org","knh.or.ke, Email: knhadmin@knh.or.ke","freedom-from-addiction-centre.business.site"};


    private ViewPager svPager;
    private LinearLayout dlayout;
    private TextView[] sDots;
    private RsAdapter rsAdapter;


    private Timer timer;
    private int current_position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab);

        ListView listView=(ListView)findViewById(R.id.rehablistview);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);

        svPager = (ViewPager) findViewById(R.id.rehabslideview_pager);

        rsAdapter = new RsAdapter(this);
        svPager.setAdapter(rsAdapter);

        //svPager.addOnPageChangeListener(viewListener);


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000,4000);

        Toolbar Rtoolbar = findViewById(R.id.rehabtoolbar);
        setSupportActionBar(Rtoolbar);
        getSupportActionBar().setTitle("REHABILITATION CENTRES");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Rtoolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RehabActivity.this, Home.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        //
        TextView tv = (TextView)findViewById(R.id.maptext);
        tv.setClickable(true);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapActivity = new Intent(getApplicationContext(),MAPActivity.class);
                startActivity(mapActivity);
                finish();
            }
        });


    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGE1.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.custom_layout1,null);
            ImageView imageView=(ImageView)view.findViewById(R.id.icon1);
            ImageView imageView1=(ImageView)view.findViewById(R.id.icon2);
            ImageView imageView2=(ImageView)view.findViewById(R.id.icon3);

            TextView textView=(TextView)view.findViewById(R.id.n);
            TextView textView1=(TextView)view.findViewById(R.id.loca);
            TextView textView2=(TextView)view.findViewById(R.id.tele);
            TextView textView3=(TextView)view.findViewById(R.id.web);

            imageView.setImageResource(IMAGE1[i]);
            imageView1.setImageResource(IMAGE2[i]);
            imageView2.setImageResource(IMAGE3[i]);

            textView.setText(NAME[i]);
            textView1.setText(description1[i]);
            textView2.setText(description2[i]);
            textView3.setText(description3[i]);



            return view;
        }
    }


    public class MyTimerTask extends TimerTask{
        @Override
        public  void  run(){
            RehabActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(svPager.getCurrentItem()==0){
                        svPager.setCurrentItem(1);
                    }
                    else if (svPager.getCurrentItem()==1){
                        svPager.setCurrentItem(2);
                    }
                    else if (svPager.getCurrentItem()==2){
                        svPager.setCurrentItem(3);
                    }
                    else if (svPager.getCurrentItem()==3){
                        svPager.setCurrentItem(4);
                    }
                    else if (svPager.getCurrentItem()==4){
                        svPager.setCurrentItem(5);
                    }
                    else if (svPager.getCurrentItem()==5){
                        svPager.setCurrentItem(6);
                    }
                    else if (svPager.getCurrentItem()==6){
                        svPager.setCurrentItem(7);
                    }
                    else if (svPager.getCurrentItem()==7){
                        svPager.setCurrentItem(8);
                    }
                    else if (svPager.getCurrentItem()==8){
                        svPager.setCurrentItem(9);
                    }
                    else {
                        svPager.setCurrentItem(0);
                    }



                }
            });
        }
    }

/*private void createSlideShow(){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                   current_position = i;
                if(i == 5){
                    current_position=0;
                    svPager.setCurrentItem(current_position++,true);
                }

            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(runnable);

            }
        },250,2500);


}*/

/*

   ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(final int i) {

            final Handler handler = new Handler();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                        current_position = i;
                    if (i == 5) {

                        svPager.setCurrentItem(current_position++, true);
                    }

                }
            };

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    handler.post(runnable);

                }
            }, 250, 2500);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };*/


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back:
                startActivity(new Intent(RehabActivity.this, Home.class));
                finish();
                return true;
        }
        return false;
    }*/
}
