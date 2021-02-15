package com.sandbox.rader.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetExchangeRateTable {

    @SerializedName("result")
    @Expose
    private CurrencyTimestampModel currencyTimestampModel;

    public CurrencyTimestampModel getCurrencyTimestampModel() {
        return currencyTimestampModel;
    }
}
