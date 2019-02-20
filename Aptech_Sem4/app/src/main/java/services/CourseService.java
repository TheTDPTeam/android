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
import models.outputs.CourseDto;

public class CourseService extends AbstractHttpApi {
    private static CourseService courseService;
    private Gson gson;

    private CourseService(){
        gson = new Gson();
    }

    public static CourseService getInstance(){
        if(courseService == null){
            courseService = new CourseService();
        }
        return courseService;
    }

    public ArrayList<CourseDto> getCourses()throws Exception{
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization","Bearer " + CurrentUserService.getToken());
        String response = executeHttpGet(UrlAPI.courses,header,null);
        try{
            ArrayList<CourseDto> courses = gson.fromJson(response, new TypeToken<List<CourseDto>>(){}.getType());
            //ArrayList<CourseDto> courses = FakeData.getCourses();
            return courses;
        }catch (Exception ex){
            throw new Exception();
        }
    }
}
