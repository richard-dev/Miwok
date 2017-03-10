package com.example.android.miwok;

import android.media.Image;
import android.support.annotation.NonNull;

/**
 * Created by richard on 2/23/17.
 */

public class Word {
    private String mActivity;

    private int mDrawableResource = -1;

    private int mMediaResource = -1;

    private String mDefaultTranslation;

    private String mMiwokTranslation;

    // Constructor
    public Word(String activity, int drawableResource, int mediaResource, String defaultTranslation, String miwokTranslation) {
        mActivity = activity;
        mDrawableResource = drawableResource;
        mMediaResource = mediaResource;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    // Getters
    public String getActivity() {
        return mActivity;
    }
    public int getDrawableResource() {
        return mDrawableResource;
    }

    public int getMediaResource() {
        return mMediaResource;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public boolean hasImage() {
        return mDrawableResource != -1;
    }
}
