package com.example.mads.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mads.R;

public class EDUAdapter  extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public EDUAdapter(Context context) {
        this.context = context;
    }

    //ARRAYS

    public int[] slideImages = {

            R.drawable.alcohol,
            R.drawable.cocaine,
            R.drawable.marijuana,
            R.drawable.tobacco,
            R.drawable.miraaa,
            R.drawable.glue,
            R.drawable.mandraxx,
            R.drawable.heroin

    };

    public String[] names ={
            "ALCOHOL",
            "COCAINE",
            "BHANG",
            "TOBACCO",
            "MIRAA",
            "GLUE",
            "mandrax",
            "HEROIN"

    };

    public String[] header = {
            "DESCRIPTION",
            "DESCRIPTION",
            "DESCRIPTION",
            "DESCRIPTION",
            "DESCRIPTION",
            "DESCRIPTION",
            "DESCRIPTION",
            "DESCRIPTION"

    };

    public String[] description = {

            "Alcohol  is  contained  in  drinks  such as beer, wine, brandy,spirits and whisky\n"+"It is an extremely potent drug. It acts on the body primarily as a depressant" +


                    "used  in  excess,  it  will  damage  or  even  kill  body tissues including muscles and brain cells",

            "Cocaine is a powerfully addictive stimulant drug made from the leaves of the coca plant.As a street drug, cocaine looks like a fine, white, crystal powder.Popular nickname: crack.health effects of cocaine depend on the method of use;",


            "commonly known as marijuana and hashish.Marijuana refers to the dried leaves, flowers, stems, and seeds from the hemp plant, Cannabis sativa",
            "Tobacco is a plant grown for its leaves, which are dried and fermented before being put in tobacco products. Tobacco contains nicotine, an ingredient that can lead to addiction. It comes in form of cigarettes,cigars,snuff and in smokeless tobacco",
            "Miraa(Khat) is a plant. The leaf and stem are used as a recreational drug and as medicine.\n"+"As a drug, the leaves and stems are chewed by people",
            "Because glue has a chemical reaction with the air and gives off a gas that when inhaled for long periods of time can cause people to have reactions. ",
           "Mandrax is a synthetic drug that is compiled by means of the mixing of chemicals in a chemical process and a tablet is then produced.The active ingredient in Mandrax is Methaqualone. ",
            "Heroin is an opioid drug made from morphine, a natural substance taken from the seed pod of the various opium poppy plants. This narcotic drug lowers perception of pain.it is white/brown powder chemically extracted."


    };

    public String[] header2 = {
            "EFFECTS",
            "EFFECTS",
            "EFFECTS",
            "EFFECTS",
            "EFFECTS",
            "EFFECTS",
            "EFFECTS",
            "EFFECTS"
    };

    public String[] description2 = {

            "1) Brain: Alcohol interferes with the brain’s communication pathways, and can affect the way the brain looks and works.\n"+"2) Heart: Cardiomyopathy – Stretching and drooping of heart muscle, Arrhythmias – Irregular heart beat, Stroke, High blood pressure. \n"+"3) Liver: Steatosis, or fatty liver, Alcoholic hepatitis, Fibrosis, Cirrhosis.\n"+"4) Cancer: Esophageal cancer, Liver cancer, etc",
            "1) snorting: loss of smell, nosebleeds, frequent runny nose, and problems with swallowing\n"+"2) smoking: cough, asthma, respiratory distress, and higher risk of infections like pneumonia\n"+"3) consuming by mouth: severe bowel decay from reduced blood flow\n"+"4) needle injection: higher risk for contracting HIV, hepatitis C, and other bloodborne diseases, skin or soft tissue infections, as well as scarring or collapsed veins",
            "1) Reduce ability to perform tasks\n"+"2) Marijuana affects brain development - impair thinking, memory, and learning functions and affect how the brain builds connections between the areas necessary for these functions\n"+"3) Breathing problems\n"+"4) Increased heart rate\n"+"5) Marijuana smoke contains more cancer cells\n"+"6) Causes mental problems such as depression and hallucination",
            "1) Tobacco smoking can lead to lung cancer, chronic bronchitis, and emphysema\n"+"2) It increases the risk of heart disease, which can lead to stroke or heart attack.\n"+"3) Smoking has also been linked to other cancers, leukemia, cataracts, and pneumonia.\n"+"4) Pregnant women who smoke cigarettes run an increased risk of miscarriage, stillborn or premature infants, or infants with low birth weight",

            "Side efects include:\n"+"1) Mood changes\n"+"2) Elevated blood pressure\n"+"3) Insomnia\n"+"4) Loss of energy\n"+"5) manic behaviour and psychosis",
            "1) Causes hallucination\n"+"2) Loss of coordination\n"+"3) Mental deterioration\n"+"4) Slurring of speech\n"+"5) Drowsiness which can lead on to coma and respiratory failure.",
            "Mandrax has more and stronger side effects:\n"+"1) Depression\n"+"2) Drastic weight loss\n"+"3) Epilepsy\n"+"4) Muscle control of the body is affected\n"+"5) Aggression and toxic psychosis",
            "1) Leads to Euphoria,Reduced appetite,chronic bronchitis,tetanus and hepatitis\n"+"2) lung complications, including pneumonia\n"+"3) collapsed veins for people who inject the drug\n"+"4) Abscesses (swollen tissue filled with pus)\n"+"5) Liver and kidney disease."

    };



    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(RelativeLayout)object;
    }

    @Override

public Object instantiateItem(ViewGroup container, int position){
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.eduslide_layout,container,false);
        ImageView eduImageView = (ImageView)view.findViewById(R.id.drug1);
        TextView td5 = (TextView)view.findViewById(R.id.textdescription);

        TextView td2 = (TextView)view.findViewById(R.id.td);
        TextView td3 = (TextView)view.findViewById(R.id.texteffects);
        TextView td4 = (TextView)view.findViewById(R.id.te);
        TextView td = (TextView)view.findViewById(R.id.name_d);
        eduImageView.setImageResource(slideImages[position]);
        td.setText(names[position]);

        td2.setText(description[position]);
        td3.setText(header2[position]);
        td4.setText(description2[position]);
        td5.setText(header[position]);

        container.addView(view);

return view;
}

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
