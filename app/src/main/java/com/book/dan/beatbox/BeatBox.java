package com.book.dan.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUND_FOLDER = "sample_sounds";

    private AssetManager mAssetManager;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context){
        mAssetManager = context.getAssets();
        loadSamples();
    }

    private void loadSamples(){
        String[] soundNames;
        try {
            soundNames = mAssetManager.list(SOUND_FOLDER);
            Log.i(TAG,"Found "+soundNames.length+" sounds");
        } catch (IOException e) {
            Log.e(TAG,"Could not list assets", e);
            return;
        }
        for(String filename:soundNames){
            String path = SOUND_FOLDER+"/"+filename;
            Sound sound = new Sound(path);
            mSounds.add(sound);
        }
    }

    public List<Sound> getSounds() {
        return mSounds;
    }
}
