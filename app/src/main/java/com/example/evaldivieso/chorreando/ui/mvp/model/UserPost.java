package com.example.evaldivieso.chorreando.ui.mvp.model;

/**
 * Created by evaldivieso on 15/09/2015.
 */
public class UserPost {
    private String username;
    private String lugar;
    private String fecha;
    private String fotoURL;

    public UserPost(String username, String lugar, String fecha) {
        this.username = username;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }
}