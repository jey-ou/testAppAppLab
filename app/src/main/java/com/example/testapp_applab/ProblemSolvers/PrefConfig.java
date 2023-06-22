package com.example.testapp_applab.ProblemSolvers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

//import androidx.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrefConfig {

    private static final String MY_PREFERENCE_NAME = "com.example.testapp_applab";
    public static final String PREF_TOTAL_KEY = "pref_total_key";
    private static final String LIST_KEY = "list_key";
    private static final String LIST_KEY2 = "list_key2";

    public static void saveTotalInPref(Context context, int total){

        SharedPreferences pref = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(PREF_TOTAL_KEY, total); //andere methodes zijn naast putIn, putString, putStringSet, putBoolean, putLong, putFloat
        editor.apply();
    }

    public static int loadTotalFromPrefs(Context context){
        SharedPreferences pref = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return pref.getInt(PREF_TOTAL_KEY, 0);
    }

    public static void removeDataFromPref(Context context){
        SharedPreferences pref = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(PREF_TOTAL_KEY);
        //editor.remove("unique_key");
        //editor.clear();
        editor.apply();
    }

    public static void writeListInPref(Context context, List<ModelSP> list){
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY2, jsonString);
        editor.apply();
    }
    public static List<ModelSP> readListFromPrefs(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY2,"");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<ModelSP>>(){}.getType();
        List<ModelSP>list = gson.fromJson(jsonString, type);
        return list;

    }

// aanvullende methodes om het gebruik van listenes mogelijk te maken
    public static void registerPref(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener){
        SharedPreferences pref = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        pref.registerOnSharedPreferenceChangeListener(listener);
    }

    public static void unRegisterPref(Context context, SharedPreferences.OnSharedPreferenceChangeListener listener){
        SharedPreferences pref = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        pref.unregisterOnSharedPreferenceChangeListener(listener);
    }


}
