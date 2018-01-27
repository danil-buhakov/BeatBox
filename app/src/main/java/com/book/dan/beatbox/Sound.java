package com.book.dan.beatbox;

public class Sound {
    private String mAssetPath;
    private String mName;

    public Sound(String assetPath){
        mAssetPath = assetPath;
        String[] sounds = assetPath.split("/");
        String filename = sounds[sounds.length-1];
        mName = filename.replace(".wav","");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }
}
