package com.example.abp_android.model;


import com.example.abp_android.utils.Estado;
import com.example.abp_android.utils.Rol;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String rol;
    private Estado estado;
    private String fecha_registro;


    public User() {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
    }
    public User(String username, String password, String email, String rol) {
        this.username = username;
        this.password = password;
        this.email=email;
        this.rol = rol;
    }
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email=email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

}
