package com.example.abp_android.adapters;

import com.example.abp_android.model.User;
import com.example.abp_android.utils.Rol;

import java.util.ArrayList;
import java.util.List;

public class LoginAdaptar {

    private List<User> usuarios;

    public LoginAdaptar(){
        usuarios=new ArrayList<>();
        usuarios.add(new User("mandeep","1234","mandeep@gmail.com","admin"));
        usuarios.add(new User("angel","1234","angel@gmail.com","admin"));
        usuarios.add(new User("john","1234","john@gmail.com","cliente"));
        usuarios.add(new User("hector","1234","hector@gmail.com","cliente"));
        usuarios.add(new User("joan","1234","joan@gmail.com","cliente"));
    }

    public String autenticar(String username, String password){
        for(User usuario: usuarios){
            if(usuario.getUsername().equals(username) && usuario.getPassword().equals(password)){
                return usuario.getRol();
            }
        }
        return null;
    }

}
