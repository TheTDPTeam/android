package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import adapter.FakeData;
import http.AbstractHttpApi;
import models.outputs.CalendarDto;

public class CalendarService extends AbstractHttpApi {
    private static CalendarService calendarService;

    private CalendarService(){

    }

    public static CalendarService getInstance(){
        if(calendarService == null){
            calendarService = new CalendarService();
        }
        return calendarService;
    }

    public ArrayList<CalendarDto> getCalendars()throws Exception{
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization","Bearer " + CurrentUserService.getToken());
        //String response = executeHttpGet(UrlAPI.myDetail,header,null);
        try{
            //ArrayList<CourseDto> announces = gson.fromJson(response, new TypeToken<List<CourseDto>>(){}.getType());
            ArrayList<CalendarDto> calendars = FakeData.getCalendars();
            return calendars;
        }catch (Exception ex){
            throw new Exception();
        }
    }
}
