package service;

import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;

import constant.UrlAPI;
import http.AbstractHttpApi;
import model.inputs.LoginDto;
import model.outputs.LoginReponse;

public class LoginService extends AbstractHttpApi {
    private static LoginService loginService;
    private static LoginReponse loginReponse;
    private Gson gson;
    private LoginService(){
        gson = new Gson();
    }

    public static LoginService getInstance(){
        if(loginService == null){
            loginService = new LoginService();
        }
        return loginService;
    }

    public static String getToken(){
        if(loginReponse == null){
            return "";
        }
        return loginReponse.getToken();
    }

    public boolean login(String userName, String password) {

        try {
            LoginDto myData = new LoginDto("nguyencongphu98@gmail.com", "rEdUTQay");

            String jsonObject = gson.toJson(myData);

            String response = executeHttpPost(UrlAPI.loginPath,null,jsonObject);

            loginReponse = gson.fromJson(response, LoginReponse.class);

            if(loginReponse.getToken() != null){
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
