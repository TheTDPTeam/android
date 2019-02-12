package controllers;

import java.util.ArrayList;
import models.outputs.CourseSemesterDto;
import models.outputs.UserDetail;
import services.InformationService;

public class InformationController {
    private static InformationController informationController;
    private InformationService informationService;

    private InformationController(){
        informationService = InformationService.getInstance();
    }

    public static InformationController getInstance(){
        if(informationController == null){
            informationController = new InformationController();
        }
        return informationController;
    }

    public UserDetail get() throws Exception {
        return informationService.get();
    }

    public ArrayList<CourseSemesterDto> getCourseDetails() throws Exception{
        return informationService.getCourseDetails();
    }
}
