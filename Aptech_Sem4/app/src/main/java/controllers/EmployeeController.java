package controllers;

import java.util.ArrayList;

import models.outputs.EmployeeDto;
import services.EmployeeService;

public class EmployeeController {
    private static EmployeeController employeeController;
    private EmployeeService employeeService;
    private EmployeeController() {
        employeeService = EmployeeService.getInstance();
    }

    public static EmployeeController getInstance(){
        if(employeeController == null){
            employeeController = new EmployeeController();
        }
        return employeeController;
    }

    public ArrayList<EmployeeDto> getEmployees() throws Exception{
        return  employeeService.getEmployees();
    }
}
