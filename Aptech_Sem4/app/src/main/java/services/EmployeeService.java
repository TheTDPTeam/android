package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import adapter.FakeData;
import http.AbstractHttpApi;
import models.outputs.EmployeeDto;

public class EmployeeService extends AbstractHttpApi {
    private static EmployeeService employeeService;
    private EmployeeService(){

    }

    public static EmployeeService getInstance(){
        if(employeeService == null){
            employeeService = new EmployeeService();
        }
        return employeeService;
    }

    public ArrayList<EmployeeDto> getEmployees() throws Exception{
        Map<String, String> header = new HashMap<String, String>();
        header.put("Authorization","Bearer " + CurrentUserService.getToken());
        //String response = executeHttpGet(UrlAPI.myDetail,header,null);
        try{
            //ArrayList<CourseDetailDto> courses = gson.fromJson(response, new TypeToken<List<CourseDetailDto>>(){}.getType());
            ArrayList<EmployeeDto> employees = FakeData.getEmployees();
            return employees;
        }catch (Exception ex){
            throw new Exception();
        }
    }
}
