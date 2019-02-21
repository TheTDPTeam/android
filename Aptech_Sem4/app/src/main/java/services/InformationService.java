package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.FakeData;
import constant.UrlAPI;
import http.AbstractHttpApi;
import models.inputs.ChangePassworDto;
import models.inputs.UpdateUserDetailDto;
import models.outputs.CourseSemesterDto;
import models.outputs.LearningProgressInfoDto;
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
            return userDetail;
        }catch (Exception ex){
            throw new Exception();
        }

    }

    public UserDetail update(UpdateUserDetailDto dto) throws Exception {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization","Bearer " + CurrentUserService.getToken());

        String jsonObject = gson.toJson(dto);
        String response = executeHttpPost(UrlAPI.updateUser,header,jsonObject);

        try{
            UserDetail userDetail = gson.fromJson(response, UserDetail.class);
            return userDetail;
        }catch (Exception ex){
            throw new Exception();
        }

    }

    public boolean changePassword(ChangePassworDto dto) throws Exception {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization","Bearer " + CurrentUserService.getToken());

        String jsonObject = gson.toJson(dto);
        String response = executeHttpPost(UrlAPI.changePassword,header,jsonObject);

        try{
            return true;
        }catch (Exception ex){
            throw new Exception();
        }

    }

    public ArrayList<CourseSemesterDto> getCourseDetails() throws Exception{
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization","Bearer " + CurrentUserService.getToken());
        String response = executeHttpGet(UrlAPI.myScore,header,null);
        try{
            ArrayList<CourseSemesterDto> courses = gson.fromJson(response, new TypeToken<List<CourseSemesterDto>>(){}.getType());
            return courses;
        }catch (Exception ex){
            throw new Exception();
        }
    }

    public LearningProgressInfoDto getLastSemesterSocore() throws Exception {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization","Bearer " + CurrentUserService.getToken());
        String response = executeHttpGet(UrlAPI.progressInfo,header,null);
        try{
            LearningProgressInfoDto learningProgressInfo = gson.fromJson(response, LearningProgressInfoDto.class);
            return learningProgressInfo;
        }catch (Exception ex){
            throw new Exception();
        }

    }
}
