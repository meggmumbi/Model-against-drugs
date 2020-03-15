package com.example.mads.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mads.R;

public class RsAdapter extends PagerAdapter {

    Context cx;
    LayoutInflater li;

    public RsAdapter(Context cx) {
        this.cx = cx;
    }

    //Arrays
    public int[] simages = {
            R.drawable.r6,
            R.drawable.r7,
            R.drawable.r8,
            R.drawable.r9,
            R.drawable.r10,
            R.drawable.r1,
            R.drawable.r2,
            R.drawable.r3,
            R.drawable.r4,
            R.drawable.r5


    };

    public String[] snames = {
      "NAIROBI PLACE",
      "ASUMBI TREATMENT CENTER",
      "JORGS",
      "MEWA",
      "SAPTA",
            "TUMAINI ",
            "The retreat rehab centre",
            "Fountain of Hope",
            "K.N.H",
            "FREEDOM"
    };

    public String[] sdescription = {
            "Adiction and specialised Treatment Centre",
            "Where theres life,theres hope",
            "charitable organization",
            "quality health care to community",
            "support for addiction and prevention in Africa",
            "Recovery and Councelling centre",
            "Transformative Rehabilitation",
            "Christian Rehabilitation centre",
            "Kenyatta National Hospital",
            "Freedom from addiction Rehab Centre "

    };


    public String[] slocation = {

            "Nirobi Place",
            "Homa Bay",
            "Limuru Rd",
            "Mwambundu Rd",
            "corner House ,11th floor, kimathi Street",
            "Ruiru, Thika super Highway",
            "Off Limuru Road",
            "Nairobi",
            "Nairobi",
            "Suite A2, 1st Floor,24/7 Building"
    } ;


    @Override
    public int getCount() {
        return snames.length;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        li = (LayoutInflater) cx.getSystemService(cx.LAYOUT_INFLATER_SERVICE);

       View view = li.inflate(R.layout.rs_layout,container,false);
        ImageView siv = (ImageView) view.findViewById(R.id.im1);
        TextView st1 = (TextView) view.findViewById(R.id.t1);
        TextView st2 = (TextView) view.findViewById(R.id.t2);
        TextView st3 = (TextView) view.findViewById(R.id.t3);

        siv.setImageResource(simages[position]);
        st1.setText(snames[position]);
        st2.setText(sdescription[position]);
        st3.setText(slocation[position]);

        container.addView(view);
       return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
