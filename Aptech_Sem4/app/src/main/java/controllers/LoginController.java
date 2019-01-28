package controllers;

import services.LoginService;

public class LoginController {
    private static LoginController loginController;
    private LoginService loginService;

    private LoginController(){
        loginService = LoginService.getInstance();
    }

    public static LoginController getInstance(){
        if(loginController == null){
            loginController = new LoginController();
        }
        return loginController;
    }

    public boolean login(String email, String password){
        return loginService.login(email,password);
    }
}
