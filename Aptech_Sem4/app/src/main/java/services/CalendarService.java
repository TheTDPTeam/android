package services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constant.UrlAPI;
import http.AbstractHttpApi;
import models.outputs.CalendarDto;

public class CalendarService extends AbstractHttpApi {
    private static CalendarService calendarService;
    private Gson gson;
    private CalendarService(){
        gson = new Gson();
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
        String response = executeHttpGet(UrlAPI.calendar,header,null);
        try{
            ArrayList<CalendarDto> calendars = gson.fromJson(response, new TypeToken<List<CalendarDto>>(){}.getType());
            return calendars;
        }catch (Exception ex){
            throw new Exception();
        }
    }
}
