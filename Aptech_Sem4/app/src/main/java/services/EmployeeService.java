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
import models.outputs.EmployeeDto;

public class EmployeeService extends AbstractHttpApi {
    private static EmployeeService employeeService;
    private Gson gson;
    private EmployeeService(){
        gson = new Gson();
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
        String response = executeHttpGet(UrlAPI.staffs,header,null);
        try{
            ArrayList<EmployeeDto> employees = gson.fromJson(response, new TypeToken<List<EmployeeDto>>(){}.getType());
            //ArrayList<EmployeeDto> employees = FakeData.getEmployees();
            return employees;
        }catch (Exception ex){
            throw new Exception();
        }
    }
}
