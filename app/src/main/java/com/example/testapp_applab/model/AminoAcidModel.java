package com.example.testapp_applab.model;

public class AminoAcidModel {

    String aminoAcidName;
    String aminoAcidAbbreviation;
    String aminoAcidAbreviationSmall;
    int image;

    public AminoAcidModel(String aminoAcidName, String aminoAcidAbbreviation, String aminoAcidAbreviationSmall, int image) {
        this.aminoAcidName = aminoAcidName;
        this.aminoAcidAbbreviation = aminoAcidAbbreviation;
        this.aminoAcidAbreviationSmall = aminoAcidAbreviationSmall;
        this.image = image;
    }

    public String getAminoAcidName() {
        return aminoAcidName;
    }

    public String getAminoAcidAbbreviation() {
        return aminoAcidAbbreviation;
    }

    public String getAminoAcidAbreviationSmall() {
        return aminoAcidAbreviationSmall;
    }

    public int getImage() {
        return image;
    }

    public AminoAcidModel() {
    }

}
