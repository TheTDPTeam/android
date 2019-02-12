package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import adapter.FakeData;
import http.AbstractHttpApi;
import models.outputs.CourseDto;

public class CourseService extends AbstractHttpApi {
    private static CourseService courseService;

    private CourseService(){

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
        //String response = executeHttpGet(UrlAPI.myDetail,header,null);
        try{
            //ArrayList<CourseDto> announces = gson.fromJson(response, new TypeToken<List<CourseDto>>(){}.getType());
            ArrayList<CourseDto> courses = FakeData.getCourses();
            return courses;
        }catch (Exception ex){
            throw new Exception();
        }
    }
}
