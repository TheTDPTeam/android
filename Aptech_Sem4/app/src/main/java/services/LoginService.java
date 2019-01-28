package services;

import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;

import constant.UrlAPI;
import http.AbstractHttpApi;
import models.inputs.LoginDto;
import models.outputs.LoginReponseDto;

public class LoginService extends AbstractHttpApi {
    private static LoginService loginService;
    private CurrentUserService currentUserService;
    private Gson gson;
    private LoginService(){

        gson = new Gson();
        currentUserService = CurrentUserService.getInstance();
    }

    public static LoginService getInstance(){
        if(loginService == null){
            loginService = new LoginService();
        }
        return loginService;
    }

    public boolean login(String userName, String password) {

        try {
            LoginDto myData = new LoginDto("nguyencongphu98@gmail.com", "rEdUTQay");

            String jsonObject = gson.toJson(myData);

            String response = executeHttpPost(UrlAPI.loginPath,null,jsonObject);

            currentUserService.setCurrentUser(gson.fromJson(response, LoginReponseDto.class));

            if(currentUserService.getToken() != null){
                return true;
            }else {
                return false;
            }
        }catch (IOException e){
            return false;
        }catch (JSONException e){
            return false;
        }
    }
}
