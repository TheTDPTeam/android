package controllers;

import java.util.ArrayList;

import models.outputs.AnnounceDto;
import services.AnnounceService;

public class AnnounceController {
    private AnnounceService announceService;
    private static AnnounceController announceController;
    private AnnounceController(){
        announceService = AnnounceService.getInstance();
    }

    public static AnnounceController getInstance(){
        if(announceController == null){
            announceController = new AnnounceController();
        }
        return announceController;
    }

    public ArrayList<AnnounceDto> getAnnounces() throws Exception{
        return announceService.getAnnounces();
    }
}
