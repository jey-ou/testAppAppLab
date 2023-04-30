package com.example.testapp_applab.model;

import com.google.gson.annotations.SerializedName;

public class Adress {
    @SerializedName("country")
    String mCountry ;
    @SerializedName("city")
    String mCity;

    public Adress(String mCountry, String mCity) {
        this.mCountry = mCountry;
        this.mCity = mCity;
    }

    public Adress() {
    }

    @Override
    public String toString(){
        return "country: " + mCountry + ", city: " + mCity;
    }
}
