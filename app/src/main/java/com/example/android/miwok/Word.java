package com.example.android.miwok;

import android.media.Image;
import android.support.annotation.NonNull;

/**
 * Created by richard on 2/23/17.
 */

public class Word {
    private int mDrawableResource = -1;

    private String mDefaultTranslation;

    private String mMiwokTranslation;

    // Constructor
    public Word(int drawableResource, String defaultTranslation, String miwokTranslation) {
        mDrawableResource = drawableResource;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    // Getters
    public int getDrawableResource() {
        return mDrawableResource;
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
