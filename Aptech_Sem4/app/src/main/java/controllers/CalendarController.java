package controllers;

import java.util.ArrayList;

import models.outputs.CalendarDto;
import services.CalendarService;

public class CalendarController {
    private static CalendarController calendarController;
    private CalendarService calendarService;
    private CalendarController(){
        calendarService = CalendarService.getInstance();
    }

    public static CalendarController getInstance(){
        if(calendarController == null){
            calendarController = new CalendarController();
        }
        return calendarController;
    }

    public ArrayList<CalendarDto> getCalendars() throws Exception {
        return calendarService.getCalendars();
    }
}
