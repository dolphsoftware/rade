package com.sandbox.rader.ui.login_screen;

import android.util.Log;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.sandbox.rader.repository.UserRepository;

public class LoginViewModel extends ViewModel {

    public ObservableField<String> userName = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");

    public void login() {
        Log.d("Tag" , "radi bre");
        UserRepository.getInstance().login(userName.get(), password.get());
    }
}