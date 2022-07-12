package com.garfild63.coffee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @POST("/auth/register")
    Call<User> registerUser(@Body User user);

    @POST("/auth/login")
    Call<User> loginUser(@Body User user);

    @GET("/locations")
    Call<List<MyCafe>> getCafes();

    @GET("/location/{id}/menu")
    Call<List<MyCoffee>> getCoffees(@Path("id") int id);
}
