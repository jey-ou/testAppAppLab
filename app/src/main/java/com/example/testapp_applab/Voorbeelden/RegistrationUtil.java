package com.example.testapp_applab.Voorbeelden;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegistrationUtil {

    private String[] usernames = {"Peter", "Carl"};

    /**
     * the input is not valid if...
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as the real password
     * ...the password contains less than 2 digits
     */
    public boolean validRegistrationInput(String username, String password, String confirmedpw){
        if(username.isEmpty() || password.isEmpty()) {
            return false;
        }

        for(int i = 0; i<= usernames.length-1; i++){
            if (usernames.equals(username)){
                return false;
            }
        }

        if(password != confirmedpw) {
            return false;
        }

        int teller = 0;
        for(int i = 0; i<= password.length()-1; i++){
            String c = "" + password.charAt(i);
            if (password.contains(c)){
                teller ++;
            }
            if (teller <2) return false;
        }


        return true;
    }
}
