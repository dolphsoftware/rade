package com.sandbox.rader.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetRegionsResponse {

    @SerializedName("listOfregions")
    @Expose
    private List<Region> listOfRegions = null;

    public List<Region> getListOfRegions() {
        return listOfRegions;
    }

}
