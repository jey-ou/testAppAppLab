package com.example.testapp_applab.Tips;

public class TipsListModel {
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
}
