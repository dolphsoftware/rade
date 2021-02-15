package com.sandbox.rader.api.livaData;

import androidx.databinding.ObservableField;

import com.sandbox.rader.model.GetExchangeRateTable;

public class CurrenciesLiveData {
    public ObservableField<String> date = new ObservableField<>("");
    public ObservableField<String> eurValue = new ObservableField<>("");
    public ObservableField<String> usdValue = new ObservableField<>("");
    public ObservableField<String> chfValue = new ObservableField<>("");
    public ObservableField<String> gbValue = new ObservableField<>("");

    public void createFrom(GetExchangeRateTable body) {
        date.set(body.getCurrencyTimestampModel().getDate());
        eurValue.set(body.getCurrencyTimestampModel().getEur().getSre());
        usdValue.set(body.getCurrencyTimestampModel().getUsd().getSre());
        chfValue.set(body.getCurrencyTimestampModel().getChf().getSre());
        gbValue.set(body.getCurrencyTimestampModel().getGbp().getSre());
    }
}
