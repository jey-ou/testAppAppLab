package com.example.testapp_applab.Tips;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class TipsListModel implements Parcelable {
    String id, categorie, beschrijving, isVerwijderd, titel;

    public TipsListModel(String id, String categorie, String beschrijving, String isVerwijderd, String titel) {
        this.id = id;
        this.categorie = categorie;
        this.beschrijving = beschrijving;
        this.isVerwijderd = isVerwijderd;
        this.titel = titel;
    }

    public TipsListModel() {
    }

    protected TipsListModel(Parcel in) {
        id = in.readString();
        categorie = in.readString();
        beschrijving = in.readString();
        isVerwijderd = in.readString();
        titel = in.readString();
    }

    public static final Creator<TipsListModel> CREATOR = new Creator<TipsListModel>() {
        @Override
        public TipsListModel createFromParcel(Parcel in) {
            return new TipsListModel(in);
        }

        @Override
        public TipsListModel[] newArray(int size) {
            return new TipsListModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getIsVerwijderd() {
        return isVerwijderd;
    }

    public String getTitel() {
        return titel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setIsVerwijderd(String isVerwijderd) {
        this.isVerwijderd = isVerwijderd;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(categorie);
        parcel.writeString(beschrijving);
        parcel.writeString(isVerwijderd);
        parcel.writeString(titel);
    }
}
