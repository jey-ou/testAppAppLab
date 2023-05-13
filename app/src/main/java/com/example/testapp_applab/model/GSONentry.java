package com.example.testapp_applab.model;

public class GSONentry {

    private String info1;
    private String info2;
    private String info3;
    private String info4;

    private int iwaarde1;
    private int iwaarde2;

    private double dwaarde1;
    private double dwaarde2;

    public GSONentry(String info1, String info2, String info3) {
        this.info1 = info1;
        this.info2 = info2;
        this.info3 = info3;
    }

    public GSONentry(String info1, String info2, int iwaarde1) {
        this.info1 = info1;
        this.info2 = info2;
        this.iwaarde1 = iwaarde1;
    }

    public GSONentry() {
    }

    public String getInfo1() {
        return info1;
    }

    public String getInfo2() {
        return info2;
    }

    public String getInfo3() {
        return info3;
    }

    public String getInfo4() {
        return info4;
    }

    public int getIwaarde1() {
        return iwaarde1;
    }

    public int getIwaarde2() {
        return iwaarde2;
    }

    public double getDwaarde1() {
        return dwaarde1;
    }

    public double getDwaarde2() {
        return dwaarde2;
    }
}
