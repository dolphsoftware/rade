package com.sandbox.rader.ui.registration_screen;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sandbox.rader.R;
import com.sandbox.rader.base.BaseFragment;
import com.sandbox.rader.databinding.RegistrationFragmentBinding;
import com.sandbox.rader.repository.UserRepository;
import com.sandbox.rader.utils.Constants;

public class RegistrationFragment extends BaseFragment<RegistrationFragmentBinding> {

    private RegistrationViewModel mViewModel;

    @Override
    protected int getLayoutResource() {
        return R.layout.registration_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        binding.setViewmodel(mViewModel);
        observeLogin();
    }

    private void observeLogin() {
        mViewModel.userRepository.userMutableLiveData.observe(getViewLifecycleOwner(), user -> {
            if (user!=null){
                handleChangeFragment(Constants.DASHBOARD_SCREEN);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewModel.userRepository.userMutableLiveData.removeObservers(getViewLifecycleOwner());
    }
}