package com.sandbox.rader.repository;

import android.util.Log;

import com.sandbox.rader.app.App;
import com.sandbox.rader.model.GetRegionsResponse;
import com.sandbox.rader.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void getRegionInfo() {
        Call<GetRegionsResponse> call = App.getInstance().getConnection().getApiService().getAllRegions();
        call.enqueue(new Callback<GetRegionsResponse>() {
            @Override
            public void onResponse(Call<GetRegionsResponse> call, Response<GetRegionsResponse> response) {
                Log.e("Response: ", response.body().getListOfRegions().toArray().toString());
            }

            @Override
            public void onFailure(Call<GetRegionsResponse> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    public void registerUser(String userName, String password) {
        App.getInstance().getDatabase().userDao().insertAll(new User(userName, password));

    }

    public void login(String userName, String password) {
        App.getInstance().getDatabase().userDao().getLoggedInUser(userName, password);
    }
}
