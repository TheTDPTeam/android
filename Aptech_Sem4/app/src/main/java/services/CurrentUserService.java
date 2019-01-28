package services;

import models.outputs.LoginReponseDto;

public class CurrentUserService {
    private static LoginReponseDto loginReponse;
    private static CurrentUserService currentUserService;

    private CurrentUserService(){
    }

    public static CurrentUserService getInstance(){
        if(currentUserService == null){
            currentUserService = new CurrentUserService();
        }
        return currentUserService;
    }

    public static String getToken(){
        if(loginReponse == null){
            return "";
        }
        return loginReponse.getToken();
    }

    public void setCurrentUser(LoginReponseDto loginReponse){
        this.loginReponse = loginReponse;
    }
}
