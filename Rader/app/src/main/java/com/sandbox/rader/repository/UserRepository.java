package com.sandbox.rader.repository;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.sandbox.rader.api.livaData.CurrenciesLiveData;
import com.sandbox.rader.app.App;
import com.sandbox.rader.model.GetExchangeRateTable;
import com.sandbox.rader.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static UserRepository instance;

    public MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void fetchExchangeRates(CurrenciesLiveData currenciesLiveData) {
        Call<GetExchangeRateTable> call = App.getInstance().getConnection().getApiService().fetchExchangeRates();
        call.enqueue(new Callback<GetExchangeRateTable>() {
            @Override
            public void onResponse(Call<GetExchangeRateTable> call, Response<GetExchangeRateTable> response) {
               currenciesLiveData.createFrom(response.body());
            }

            @Override
            public void onFailure(Call<GetExchangeRateTable> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    public void registerUser(String userName, String password) {

        new AsyncTask<User, Void, User>() {

            @Override
            protected User doInBackground(User... users) {
                App.getInstance().getDatabase().userDao().insertAll(new User(userName, password));
                return App.getInstance().getDatabase().userDao().getLoggedInUser(userName, password);
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);
                App.getUserManager().startSession(user);
                userMutableLiveData.postValue(user);
            }
        }.execute();
    }

    public void login(String userName, String password) {

        new AsyncTask<Void, Void, User>() {
            @Override
            protected User doInBackground(Void... voids) {
                return App.getInstance().getDatabase().userDao().getLoggedInUser(userName, password);
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);
                App.getUserManager().startSession(user);
                userMutableLiveData.postValue(user);
            }
        }.execute();

    }

    public void logout() {
        App.getUserManager().endSession();
        userMutableLiveData.postValue(null);
    }
}
