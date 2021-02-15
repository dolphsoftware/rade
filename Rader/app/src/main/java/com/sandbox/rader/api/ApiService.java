package com.sandbox.rader.api;

import com.sandbox.rader.model.GetRegionsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/nectar/WS_GetAllRegions")
    Call<GetRegionsResponse> getAllRegions();
}
