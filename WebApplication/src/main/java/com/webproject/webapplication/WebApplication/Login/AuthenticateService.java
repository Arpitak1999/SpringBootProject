package com.webproject.webapplication.WebApplication.Login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {
    public boolean authenticate(String username, String password){
        boolean isValidUsername = username.equalsIgnoreCase("Arpita");
        boolean isValidPassword = password.equalsIgnoreCase("test");
        return isValidUsername && isValidPassword;
    }
}
