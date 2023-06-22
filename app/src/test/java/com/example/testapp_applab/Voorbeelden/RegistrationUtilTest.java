package com.example.testapp_applab.Voorbeelden;

import static org.junit.Assert.*;
//import com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class RegistrationUtilTest {

    @Test
    public void testOntbrekendeUsername(){
        RegistrationUtil test = new RegistrationUtil();
        boolean resultaat = test.validRegistrationInput("", "hupeldepup21", "hupeldepup21");
        assertFalse(resultaat);
        //assertFalse(resultaat);
        //assertThat(result).isFalse(); // is een beter leesbare expressie met google  thruth
    }

    @Test
    public void BestaandeUsername(){
        RegistrationUtil test = new RegistrationUtil();
        boolean resultaat = test.validRegistrationInput("Peter", "hupeldepup21", "hupeldepup21");
        assertFalse(resultaat);
        //assertFalse(resultaat);
        //assertThat(result).isFalse(); // is een beter leesbare expressie met google  thruth
    }
    @Test
    public void NieuweUsername(){
        RegistrationUtil test = new RegistrationUtil();
        boolean resultaat = test.validRegistrationInput("David", "hupeldepup21", "hupeldepup21");
        assertTrue(resultaat);
        //assertFalse(resultaat);
        //assertThat(result).isFalse(); // is een beter leesbare expressie met google  thruth
    }
    @Test
    public void fouteBevestigingPaswoord(){
        RegistrationUtil test = new RegistrationUtil();
        boolean resultaat = test.validRegistrationInput("David", "hupeldepup21", "hupeldepup21");
        assertFalse(resultaat);
        //assertFalse(resultaat);
        //assertThat(result).isFalse(); // is een beter leesbare expressie met google  thruth
    }
    @Test
    public void OntbrekendeBevesigingPaswoord(){
        RegistrationUtil test = new RegistrationUtil();
        boolean resultaat = test.validRegistrationInput("", "hupeldepup21", "hupeldepup21");
        assertFalse(resultaat);
        //assertFalse(resultaat);
        //assertThat(result).isFalse(); // is een beter leesbare expressie met google  thruth
    }

}