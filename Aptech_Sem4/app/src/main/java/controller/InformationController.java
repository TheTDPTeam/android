package controller;

import org.json.JSONException;

import java.io.IOException;

import model.outputs.UserDetail;
import service.InformationService;

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

    public UserDetail get() throws IOException, JSONException {
        return informationService.get();
    }
}
