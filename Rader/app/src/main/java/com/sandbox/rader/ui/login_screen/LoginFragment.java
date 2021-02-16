package com.sandbox.rader.ui.login_screen;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.sandbox.rader.R;
import com.sandbox.rader.base.BaseFragment;
import com.sandbox.rader.databinding.LoginScreenFragmentBinding;
import com.sandbox.rader.utils.Constants;

public class LoginFragment extends BaseFragment<LoginScreenFragmentBinding> {

    private LoginViewModel mViewModel;


    @Override
    protected int getLayoutResource() {
        return R.layout.login_screen_fragment;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setFragment(this);
        binding.setViewmodel(mViewModel);
        observeLogin();
    }

    private void observeLogin() {
        mViewModel.userRepository.userMutableLiveData.observe(getViewLifecycleOwner(), user -> {
            if (user != null) {
                handleChangeFragment(Constants.DASHBOARD_SCREEN);
            }

        });
    }

    public void handleRegistrationScreen() {
        handleChangeFragment(Constants.REGISTRATION_SCREEN);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewModel.userRepository.userMutableLiveData.removeObservers(getViewLifecycleOwner());
    }
}