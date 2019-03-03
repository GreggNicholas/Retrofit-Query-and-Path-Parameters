package com.example.retrofitqueryandpathparameters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NumbersService {

    String ENDPOINT = "NumberPath/math?json";

    @GET(ENDPOINT)
    Call<NumberModel> getNumbers(@Path("numInput") String numInput);
}
