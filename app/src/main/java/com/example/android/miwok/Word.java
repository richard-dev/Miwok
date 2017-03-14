package com.example.android.miwok;

import android.media.Image;
import android.support.annotation.NonNull;

/**
 * Created by richard on 2/23/17.
 */

public class Word {
    private int mActivityPosition;

    private int mDrawableResource = -1;

    private int mMediaResource = -1;

    private String mDefaultTranslation;

    private String mMiwokTranslation;

    // Constructor
    public Word(int activityPosition, int drawableResource, int mediaResource, String defaultTranslation, String miwokTranslation) {
        mActivityPosition = activityPosition;
        mDrawableResource = drawableResource;
        mMediaResource = mediaResource;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    // Getters
    public int getActivityPosition() {
        return mActivityPosition;
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

    // For logging
    @Override
    public String toString() {
        return "Word{" +
                "mActivityPosition='" + mActivityPosition + '\'' +
                ", mDrawableResource=" + mDrawableResource +
                ", mMediaResource=" + mMediaResource +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                '}';
    }
}
