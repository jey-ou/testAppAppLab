package com.example.testapp_applab.model;

public class ExampleItem {

    private int  mImageResource; // omdat de images opgeslagen in de resources geindexeerd zijn
    private String mText1;
    private String mText2;

    public ExampleItem() {
    }

    public ExampleItem(int mImageResource, String mText1, String mText2) {
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }
}
