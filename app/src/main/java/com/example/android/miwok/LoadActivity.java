package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;

public class LoadActivity extends AppCompatActivity {
    // Global variables
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    // Audio Focus Change Listener
    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    switch (focusChange) {
                        case AUDIOFOCUS_LOSS_TRANSIENT:
                            // Pause if loss of audio focus for a short period of time
                            break;
                        case AudioManager.AUDIOFOCUS_GAIN:
                            // Resume playback
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS:
                            // Stop playback if audio focus completely lost
                            am.unregisterMediaButtonEventReceiver(RemoteControlReceiver);
                            am.abandonAudioFocus(audioFocusChangeListener);
                            break;
                    }
                }
            };
    private ArrayList<Word> words;


    // Set a single instance of an OnCompletionListener that releases MediaPlayer on completion.
    private MediaPlayer.OnCompletionListener mediaCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        // Get incoming intent
        Intent incomingIntent = getIntent();
        String activity = incomingIntent.getStringExtra("loadActivity");

        // Get the content of WordAdapater
        WordAdapter adapter = new WordAdapter(this, getWords(activity));
        ListView listView = (ListView) findViewById(R.id.list);

        // Load adapter into listView
        listView.setAdapter(adapter);

        // Set Audio Focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Onclick listener for media files
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);

                // Release existing mediaPlayer
                mediaPlayerRelease();

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(audioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                // If Audio Focus is granted, create MediaPlayer
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mAudioManager.registerMediaButtonEventReceiver(RemoteControlreceiver);

                    // Create media player
                    mMediaPlayer = MediaPlayer.create(LoadActivity.this, word.getMediaResource());
                    mMediaPlayer.start();

                    // Set OnCompletionListener to mMedia Player
                    mMediaPlayer.setOnCompletionListener(mediaCompletionListener);
                }
            }
        });

        // Set title
        getSupportActionBar().setTitle(activity);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayerRelease();
    }

    private void mediaPlayerRelease() {
        // Check if existing media player
        if (mMediaPlayer != null) {
            // If media player exists, then release it.
            mMediaPlayer.release();
        }

    }

    private ArrayList<Word> getWords(String activity) {
        words = new ArrayList<>();

        switch (activity) {
            case "Colors":
                words.add(new Word(activity,R.drawable.color_red,R.raw.color_red,"red","weṭeṭṭi"));
                words.add(new Word(activity,R.drawable.color_green,R.raw.color_green, "green","chokokki"));
                words.add(new Word(activity,R.drawable.color_brown,R.raw.color_brown,"brown","taktaakki"));
                words.add(new Word(activity,R.drawable.color_gray,R.raw.color_gray, "gray","topoppi"));
                words.add(new Word(activity,R.drawable.color_black,R.raw.color_black,"black","kululli"));
                words.add(new Word(activity,R.drawable.color_white,R.raw.color_white,"white","kelelli"));
                words.add(new Word(activity,R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow,"dusty yellow","ṭopiisә"));
                words.add(new Word(activity,R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow,"mustard yellow","chiwiiṭә"));
                break;
            case "Family":
                words.add(new Word(activity,R.drawable.family_father,R.raw.family_father,"father","әpә"));
                words.add(new Word(activity,R.drawable.family_mother,R.raw.family_mother,"mother","әṭa"));
                words.add(new Word(activity,R.drawable.family_son,R.raw.family_son,"son","angsi"));
                words.add(new Word(activity,R.drawable.family_daughter,R.raw.family_daughter,"daughter","tune"));
                words.add(new Word(activity,R.drawable.family_older_brother,R.raw.family_older_brother,"older brother","taachi"));
                words.add(new Word(activity,R.drawable.family_younger_brother,R.raw.family_younger_brother,"younger brother","chalitti"));
                words.add(new Word(activity,R.drawable.family_older_sister,R.raw.family_younger_sister,"older sister","tete"));
                words.add(new Word(activity,R.drawable.family_younger_sister,R.raw.family_younger_sister,"younger sister","kolliti"));
                words.add(new Word(activity,R.drawable.family_grandmother,R.raw.family_grandmother,"grandmother","ama"));
                words.add(new Word(activity,R.drawable.family_grandfather,R.raw.family_grandfather,"grandfather","paapa"));
                break;
            case "Numbers":
                words.add(new Word(activity,R.drawable.number_one,R.raw.number_one,"one","lutti"));
                words.add(new Word(activity,R.drawable.number_two,R.raw.number_two,"two","otiiko"));
                words.add(new Word(activity,R.drawable.number_three,R.raw.number_three,"three","tolookosu"));
                words.add(new Word(activity,R.drawable.number_four,R.raw.number_four,"four","oyyisa"));
                words.add(new Word(activity,R.drawable.number_five,R.raw.number_five,"five","massokka"));
                words.add(new Word(activity,R.drawable.number_six,R.raw.number_six,"six","temmokka"));
                words.add(new Word(activity,R.drawable.number_seven,R.raw.number_seven,"seven","kenekaku"));
                words.add(new Word(activity,R.drawable.number_eight,R.raw.number_eight,"eight","kawinta"));
                words.add(new Word(activity,R.drawable.number_nine,R.raw.number_nine,"nine","wo`e"));
                words.add(new Word(activity,R.drawable.number_ten,R.raw.number_ten,"ten","na`aacha"));
                break;
            case "Phrases":
                words.add(new Word(activity,-1,R.raw.phrase_where_are_you_going,"Where are you going?","minto wuksus"));
                words.add(new Word(activity,-1,R.raw.phrase_what_is_your_name,"What is your name?","tinnә oyaase'nә"));
                words.add(new Word(activity,-1,R.raw.phrase_my_name_is,"My name is...","oyaaset..."));
                words.add(new Word(activity,-1,R.raw.phrase_how_are_you_feeling,"How are you feeling","michәksәs?"));
                words.add(new Word(activity,-1,R.raw.phrase_im_feeling_good,"I'm feeling good.","kuchi achit"));
                words.add(new Word(activity,-1,R.raw.phrase_are_you_coming,"Are you coming?","әәnәs'aa?"));
                words.add(new Word(activity,-1,R.raw.phrase_yes_im_coming,"Yes, I'm coming.","hәә’ әәnәm"));
                words.add(new Word(activity,-1,R.raw.phrase_im_coming,"I'm coming.","әәnәm"));
                words.add(new Word(activity,-1,R.raw.phrase_lets_go,"Let's go.","yoowutis"));
                words.add(new Word(activity,-1,R.raw.phrase_come_here,"Come here.","әnni'nem"));
                break;
        }

        return words;
    }

    //    switch (activityIntent) {
//        case "Colors":
//            break;
//        case "Family":
//            break;
//        case "Numbers":
//            break;
//        case "Phrases":
//            break;
//    }

}
