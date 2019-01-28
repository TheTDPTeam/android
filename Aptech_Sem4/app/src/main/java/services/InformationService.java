package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.FakeData;
import constant.UrlAPI;
import http.AbstractHttpApi;
import models.outputs.CourseDetailDto;
import models.outputs.UserDetail;
import realm.reponsitories.UserRealmRepository;

public class InformationService extends AbstractHttpApi {
    private static InformationService informationService;
    private UserRealmRepository userRealmRepository;
    private Gson gson;

    private InformationService(){
        gson = new Gson();
        userRealmRepository = UserRealmRepository.getInstance();
    }

    public static InformationService getInstance(){
        if(informationService == null){
            informationService = new InformationService();
        }
        return informationService;
    }

    public UserDetail get() throws Exception {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization","Bearer " + CurrentUserService.getToken());
        String response = executeHttpGet(UrlAPI.myDetail,header,null);
        try{
            UserDetail userDetail = gson.fromJson(response, UserDetail.class);
            //userRealmRepository.saveAsync(userDetail);
            //UserDetail userDetail1 = userRealmRepository.getUserDetailById(userDetail.getId());
            return userDetail;
        }catch (Exception ex){
            throw new Exception();
        }

    }

    public ArrayList<CourseDetailDto> getCourseDetails() throws Exception{
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization","Bearer " + CurrentUserService.getToken());
        //String response = executeHttpGet(UrlAPI.myDetail,header,null);
        try{
            //ArrayList<CourseDetailDto> courses = gson.fromJson(response, new TypeToken<List<CourseDetailDto>>(){}.getType());
            ArrayList<CourseDetailDto> courses = FakeData.getCourseDetails();
            return courses;
        }catch (Exception ex){
            throw new Exception();
        }
    }
}
