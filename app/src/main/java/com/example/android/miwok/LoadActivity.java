package com.example.android.miwok;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

import android.view.View;
import android.widget.ListView;

import static com.example.android.miwok.R.color.category_default;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        // Get incoming intent
        Intent incomingIntent = getIntent();
        String activity = incomingIntent.getStringExtra("loadActivity");

        WordAdapter adapter = new WordAdapter(this, loadWords(activity));
        ListView listView = (ListView) findViewById(R.id.list);

        // Load adapter into listView
        listView.setAdapter(adapter);

        // Set colors
        setColors(activity, listView);

        // Set title
        getSupportActionBar().setTitle(activity);
    }


//    switch (activity) {
//        case "Colors":
//            break;
//        case "Family":
//            break;
//        case "Numbers":
//            break;
//        case "Phrases":
//            break;
//    }

    private ArrayList<Word> loadWords(String activity) {
        ArrayList<Word> words = new ArrayList<>();

        switch (activity) {
            case "Colors":
                words.add(new Word(R.drawable.color_red,"red","weṭeṭṭi"));
                words.add(new Word(R.drawable.color_green, "green","chokokki"));
                words.add(new Word(R.drawable.color_brown,"brown","taktaakki"));
                words.add(new Word(R.drawable.color_gray, "gray","topoppi"));
                words.add(new Word(R.drawable.color_black,"black","kululli"));
                words.add(new Word(R.drawable.color_white,"white","kelelli"));
                words.add(new Word(R.drawable.color_dusty_yellow,"dusty yellow","ṭopiisә"));
                words.add(new Word(R.drawable.color_mustard_yellow,"mustard yellow","chiwiiṭә"));
                break;
            case "Family":
                words.add(new Word(R.drawable.family_father, "father","әpә"));
                words.add(new Word(R.drawable.family_mother,"mother","әṭa"));
                words.add(new Word(R.drawable.family_son,"son","angsi"));
                words.add(new Word(R.drawable.family_daughter,"daughter","tune"));
                words.add(new Word(R.drawable.family_older_brother,"older brother","taachi"));
                words.add(new Word(R.drawable.family_younger_brother,"younger brother","chalitti"));
                words.add(new Word(R.drawable.family_older_sister,"older sister","tete"));
                words.add(new Word(R.drawable.family_younger_brother,"younger brother","kolliti"));
                words.add(new Word(R.drawable.family_grandmother,"grandmother","ama"));
                words.add(new Word(R.drawable.family_grandfather,"grandfather","paapa"));
                break;
            case "Numbers":
                words.add(new Word(R.drawable.number_one,"one","lutti"));
                words.add(new Word(R.drawable.number_two,"two","otiiko"));
                words.add(new Word(R.drawable.number_three,"three","tolookosu"));
                words.add(new Word(R.drawable.number_four,"four","oyyisa"));
                words.add(new Word(R.drawable.number_five,"five","massokka"));
                words.add(new Word(R.drawable.number_six,"six","temmokka"));
                words.add(new Word(R.drawable.number_seven,"seven","kenekaku"));
                words.add(new Word(R.drawable.number_eight,"eight","kawinta"));
                words.add(new Word(R.drawable.number_nine,"nine","wo`e"));
                words.add(new Word(R.drawable.number_ten,"ten","na`aacha"));
                break;
            case "Phrases":
//                words.add(new Word(R.mipmap.ic_launcher,"Where are you going?","minto wuksus"));
//                words.add(new Word(R.mipmap.ic_launcher,"What is your name?","tinnә oyaase'nә"));
//                words.add(new Word(R.mipmap.ic_launcher,"My name is...","oyaaset..."));
//                words.add(new Word(R.mipmap.ic_launcher,"How are you feeling","michәksәs?"));
//                words.add(new Word(R.mipmap.ic_launcher,"I'm feeling good.","kuchi achit"));
//                words.add(new Word(R.mipmap.ic_launcher,"Are you coming?","әәnәs'aa?"));
//                words.add(new Word(R.mipmap.ic_launcher,"Yes, I'm coming.","hәә’ әәnәm"));
//                words.add(new Word(R.mipmap.ic_launcher,"I'm coming.","әәnәm"));
//                words.add(new Word(R.mipmap.ic_launcher,"Let's go.","yoowutis"));
//                words.add(new Word(R.mipmap.ic_launcher,"Come here.","әnni'nem"));
                words.add(new Word(0,"What is your name?","tinnә oyaase'nә"));
                words.add(new Word(0,"My name is...","oyaaset..."));
                words.add(new Word(0,"How are you feeling","michәksәs?"));
                words.add(new Word(0,"I'm feeling good.","kuchi achit"));
                words.add(new Word(0,"Are you coming?","әәnәs'aa?"));
                words.add(new Word(0,"Yes, I'm coming.","hәә’ әәnәm"));
                words.add(new Word(0,"I'm coming.","әәnәm"));
                words.add(new Word(0,"Let's go.","yoowutis"));
                words.add(new Word(0,"Come here.","әnni'nem"));
                break;
        }

        return words;
    }

    private void setColors(String activity, ListView listView) {
        int colorResource = R.color.category_default;

        switch (activity) {
            case "Colors":
                colorResource = R.color.category_numbers;
                break;
            case "Family":
                colorResource = R.color.category_family;
                break;
            case "Numbers":
                colorResource = R.color.category_numbers;
                break;
            case "Phrases":
                colorResource = R.color.category_phrases;
                break;
        }

        // Set Title bar
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ResourcesCompat.getColor(getResources(), colorResource, null));
        }
        // Set Action Bar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), colorResource, null)));

    }
}
