package com.sandbox.rader.shared_prefs;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppPreferenceManager {

    private final SharedPreferences mPreferences;

    public SharedPreferences getPrefs(){
        return mPreferences;
    }

    public AppPreferenceManager(Application application) {
        this.mPreferences = PreferenceManager.getDefaultSharedPreferences(application);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return mPreferences.getBoolean(key, defaultValue);
    }

    public void putBoolean(String key, boolean value) {
        mPreferences.edit().putBoolean(key, value).apply();
    }

    public int getInt(String key, int defaultValue) {
        return mPreferences.getInt(key, defaultValue);
    }

    public void putInt(String key, int value) {
        mPreferences.edit().putInt(key, value).apply();
    }

    public String getString(String key, String defaultValue) {
        return mPreferences.getString(key, defaultValue);
    }

    void putString(String key, String value) {
        mPreferences.edit().putString(key, value).apply();
    }

    void removePref(String key) {
        mPreferences.edit().remove(key).apply();
    }
}
