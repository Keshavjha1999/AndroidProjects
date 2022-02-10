package com.example.fifthapplication;

public class Word {

    private final String mDefaultTranslation;
    private final String mMiwokTranslation;
    private int myImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioResourceId;

    public Word(String defaultTranslation, String mivokTranslation, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = mivokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public Word(String defaultTranslation, String mivokTranslation, int imageResourceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = mivokTranslation;
        myImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMivokTranslation(){
        return mMiwokTranslation;
    }

    public int getMyImageResourceId(){return myImageResourceId;}

    public boolean hasImage(){
        return myImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId(){ return mAudioResourceId;}
}
