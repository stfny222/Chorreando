package com.example.evaldivieso.chorreando.domain;

import com.example.evaldivieso.chorreando.dto.GenericResponse;
import com.example.evaldivieso.chorreando.dto.LoginRequest;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by evaldivieso on 15/09/2015.
 */
public interface IService {
    @GET("")
    Call<GenericResponse> loginRequestCall(
            LoginRequest user);
}
