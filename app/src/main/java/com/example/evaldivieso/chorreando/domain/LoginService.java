package com.example.evaldivieso.chorreando.domain;

import com.example.evaldivieso.chorreando.dto.GenericResponse;
import com.example.evaldivieso.chorreando.dto.LoginRequest;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by evaldivieso on 15/09/2015.
 */
public interface LoginService {
    @POST("/login")
    Call<GenericResponse> login(@Body LoginRequest request);
}
