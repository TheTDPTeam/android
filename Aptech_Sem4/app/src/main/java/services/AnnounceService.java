package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import adapter.FakeData;
import http.AbstractHttpApi;
import models.outputs.AnnounceDto;

public class AnnounceService extends AbstractHttpApi {
    private static AnnounceService announceService;

    private AnnounceService(){

    }

    public static AnnounceService getInstance(){
        if(announceService == null){
            announceService = new AnnounceService();
        }
        return announceService;
    }

    public ArrayList<AnnounceDto> getAnnounces()throws Exception{
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization","Bearer " + CurrentUserService.getToken());
        //String response = executeHttpGet(UrlAPI.myDetail,header,null);
        try{
            //ArrayList<AnnounceDto> announces = gson.fromJson(response, new TypeToken<List<AnnounceDto>>(){}.getType());
            ArrayList<AnnounceDto> announces = FakeData.getAnnounces();
            return announces;
        }catch (Exception ex){
            throw new Exception();
        }
    }
}
