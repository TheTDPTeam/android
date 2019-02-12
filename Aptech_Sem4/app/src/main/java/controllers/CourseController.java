package controllers;

import java.util.ArrayList;

import models.outputs.CourseDto;
import services.CourseService;

public class CourseController {
    private static CourseController courseController;
    private CourseService courseService;
    private CourseController(){
        courseService = CourseService.getInstance();
    }

    public static CourseController getInstance(){
        if(courseController == null){
            courseController = new CourseController();
        }
        return courseController;
    }

    public ArrayList<CourseDto> getCourses()throws Exception{
        return courseService.getCourses();
    }
}
