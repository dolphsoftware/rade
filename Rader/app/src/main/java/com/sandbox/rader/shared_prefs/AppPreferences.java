package com.sandbox.rader.shared_prefs;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.sandbox.rader.model.User;

public class AppPreferences {

    private static final String PREF_USER = "pref_user";

    private final AppPreferenceManager appPreferenceManager;
    private final Gson gson;

    public AppPreferences(AppPreferenceManager appPreferenceManager, Gson gson) {
        this.appPreferenceManager = appPreferenceManager;
        this.gson = gson;
    }

    public void storeUser(User user) {
        String serializedUser = gson.toJson(user);
        appPreferenceManager.putString(PREF_USER, serializedUser);
    }

    public User readUser() {
        User retUserData = null;
        String serializedUser = appPreferenceManager.getString(PREF_USER, "");
        if (!TextUtils.isEmpty(serializedUser)) {
            retUserData = gson.fromJson(serializedUser, User.class);
        }
        return retUserData;
    }
    public void removeUser() {
        appPreferenceManager.removePref(PREF_USER);
    }

}
