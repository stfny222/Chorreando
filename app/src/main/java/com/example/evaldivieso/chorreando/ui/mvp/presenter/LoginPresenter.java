package com.example.evaldivieso.chorreando.ui.mvp.presenter;

import android.util.Log;

import com.example.evaldivieso.chorreando.domain.IService;
import com.example.evaldivieso.chorreando.dto.GenericResponse;
import com.example.evaldivieso.chorreando.dto.LoginRequest;
import com.example.evaldivieso.chorreando.ui.mvp.view.LoginView;

import java.io.IOException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class LoginPresenter implements LoginPresenterIf {
    private static final String url = "http://192.168.0.14:8080/ChorreandoBackend/login";

    private LoginView view;

    public LoginPresenter(LoginView view){
        this.view = view;
    }
    @Override
    public void login(String usuario, String password){

        // Create a very simple REST adapter which points the GitHub API.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an instance of our GitHub API interface.
        IService iService = retrofit.create(IService.class);

        LoginRequest user = new LoginRequest(usuario, password);

        // Create a call instance for looking up Retrofit contributors.
        Call<GenericResponse> call = iService.loginRequestCall(user);

        // Fetch and print a list of the contributors to the library.
        try {
            GenericResponse loginResponse = call.execute().body();
            Log.i("Status", loginResponse.getMsgStatus());

            if (loginResponse.getMsgStatus().equals("OK")){
                view.onLoginCorrecto();
            }else if (loginResponse.getMsgStatus().equals("ERROR")){
                view.onLoginIncorrecto();
            }else{
                view.onError(loginResponse.getMsgError());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }





        /*LoginRequest loginRequest = new LoginRequest(usuario, password);
        final String json = new Gson().toJson(loginRequest);

        RequestQueue queue = view.getApplicationController().getRequestQueue();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                GenericResponse loginResponse =
                        new Gson().fromJson(response, GenericResponse.class);

                if (loginResponse.getMsgStatus().equals("OK")){
                    view.onLoginCorrecto();
                }else if (loginResponse.getMsgStatus().equals("ERROR")){
                    view.onLoginIncorrecto();
                }else{
                    view.onError(loginResponse.getMsgError());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                view.onError("LoginPresenter (5XX): " + error.getMessage());
            }
        }){
            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                return json.getBytes();
            }
        };


        stringRequest.setTag("LOGIN");
        queue.add(stringRequest);

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();*/
    }
}
