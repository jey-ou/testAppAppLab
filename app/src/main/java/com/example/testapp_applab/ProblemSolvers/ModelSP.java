package com.example.testapp_applab.ProblemSolvers;

public class ModelSP {
    private String item;
    private String place;
    private int aantal;
    private String datum;

    public ModelSP(String item, String place, int aantal) {
        this.item = item;
        this.place = place;
        this.aantal = aantal;
        this.datum = "00/00/2023";
    }

    public ModelSP(String item, String datum) {
        this.item = item;
        this.datum = datum;
        this.aantal = 0;
        this.place ="";
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getItem() {
        return item;
    }

    public String getPlace() {
        return place;
    }

    public int getAantal() {
        return aantal;
    }
    public String getDatum(){
        return datum;
    }
    public void setItem(String item) {
        this.item = item;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setAantal(int aantal) {
        this.aantal = aantal;
    }
}
