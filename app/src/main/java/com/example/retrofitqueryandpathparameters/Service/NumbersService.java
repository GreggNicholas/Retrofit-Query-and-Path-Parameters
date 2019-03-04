package com.example.retrofitqueryandpathparameters.Service;

import com.example.retrofitqueryandpathparameters.Model.NumberModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NumbersService {

    String ENDPOINT = "/math?json";
    String PATH = "{numInput}";

    @GET(PATH + ENDPOINT)
    Call<NumberModel> getNumbers(@Path("numInput") String numInput);
}
