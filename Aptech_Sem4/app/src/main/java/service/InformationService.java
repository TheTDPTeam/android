package service;

import com.google.gson.Gson;

import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import constant.UrlAPI;
import http.AbstractHttpApi;
import model.outputs.UserDetail;

public class InformationService extends AbstractHttpApi {
    private static InformationService informationService;
    private Gson gson;

    private InformationService(){
        gson = new Gson();
    }

    public static InformationService getInstance(){
        if(informationService == null){
            informationService = new InformationService();
        }
        return informationService;
    }

    public UserDetail get() throws IOException, JSONException {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization","Bearer " + LoginService.getToken());
        String response = executeHttpGet(UrlAPI.myDetail,header,null);
        try{
            return gson.fromJson(response, UserDetail.class);
        }catch (Exception ex){
            return new UserDetail();
        }

    }
}
