package com.sandbox.rader.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrencyTimestampModel {

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("eur")
    @Expose
    private EurModel eur;

    @SerializedName("usd")
    @Expose
    private EurModel usd;

    @SerializedName("chf")
    @Expose
    private EurModel chf;

    @SerializedName("gbp")
    @Expose
    private EurModel gbp;

    public String getDate() {
        return date;
    }

    public EurModel getEur() {
        return eur;
    }

    public EurModel getUsd() {
        return usd;
    }

    public EurModel getChf() {
        return chf;
    }

    public EurModel getGbp() {
        return gbp;
    }

    public class EurModel extends CurrencyModel {

    }

    public class UsdModel extends CurrencyModel {

    }

    public class ChfModel extends CurrencyModel {

    }

    public class GbpModel extends CurrencyModel {

    }


    public class CurrencyModel {
        @SerializedName("kup")
        @Expose
        private String kup;

        @SerializedName("sre")
        @Expose
        private String sre;

        @SerializedName("pro")
        @Expose
        private String pro;

        public String getKup() {
            return kup;
        }

        public String getSre() {
            return sre;
        }

        public String getPro() {
            return pro;
        }
    }
}
