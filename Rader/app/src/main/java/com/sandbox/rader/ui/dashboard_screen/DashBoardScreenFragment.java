package com.sandbox.rader.ui.dashboard_screen;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.sandbox.rader.R;
import com.sandbox.rader.base.BaseFragment;
import com.sandbox.rader.databinding.DashboardScreenFragmentBinding;
import com.sandbox.rader.utils.Constants;

public class DashBoardScreenFragment extends BaseFragment<DashboardScreenFragmentBinding> {

    public DashBoardScreenViewModel mViewModel;

    public static DashBoardScreenFragment newInstance() {
        return new DashBoardScreenFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.dashboard_screen_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DashBoardScreenViewModel.class);
        binding.setViewmodel(mViewModel);
        observeLogin();
        fetchExchangeRates();
    }

    private void fetchExchangeRates() {
        mViewModel.userRepository.fetchExchangeRates(mViewModel.currenciesLiveData);
    }

    private void observeLogin() {
        mViewModel.userRepository.userMutableLiveData.observe(getViewLifecycleOwner(), user -> {
            if (user == null) {
                handleChangeFragment(Constants.LOGIN_SCREEN);
            }

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewModel.userRepository.userMutableLiveData.removeObservers(getViewLifecycleOwner());
    }
}