package com.example.testapp_applab.model;
import com.google.gson.annotations.SerializedName;

public class Employee {
    @SerializedName("firstName")
    private String mFirstName;
    @SerializedName("age")
    private int mAge;
    @SerializedName("mail")
    private String mMail;
    @SerializedName("adress")
    private Adress mAdress;
    public Employee() {
    }
    public Employee(String firstName, int age, String mail) {
        this.mFirstName = firstName;
        this.mAge = age;
        this.mMail = mail;
        //mAdress = new Adress("", "");
    }

    public Employee(String mFirstName, int mAge, String mMail, Adress mAdress) {
        this.mFirstName = mFirstName;
        this.mAge = mAge;
        this.mMail = mMail;
        this.mAdress = mAdress;
    }

    public String getFirstName() {
        return mFirstName;
    }
    public int getAge() {
        return mAge;
    }
    public String getMail() {
        return mMail;
    }
    @Override
    public String toString(){
        String res = "firstName: " + mFirstName + ", age: " + mAge + ", mail: " + mMail ;

        if (mAdress != null){
           res += ", Adress: " + mAdress.toString();
        }

        return res;
    }
}
