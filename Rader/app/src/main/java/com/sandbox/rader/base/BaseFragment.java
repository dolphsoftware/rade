package com.sandbox.rader.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.sandbox.rader.ui.HomeHostCallback;
import com.sandbox.rader.ui.MainActivity;

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {

    protected abstract int getLayoutResource();

    private Toast toast;

    public T binding;

    private HomeHostCallback callback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutResource() != -1)
            binding = DataBindingUtil.inflate(inflater, getLayoutResource(), container, false);
        return binding.getRoot();
    }

    public void showToast(int message) {
        showToast(getString(message));
    }

    public void showToast(String message) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }

        toast = Toast.makeText(getContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    protected void handleChangeFragment(int screenType) {
        callback.navigateToScreen(screenType);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            callback = (MainActivity) context;
        }
    }
}
