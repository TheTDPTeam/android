package adapter;

import java.util.ArrayList;

import models.outputs.AnnounceDetailDto;
import models.outputs.AnnounceDto;
import models.outputs.CourseDetailDto;
import models.outputs.EmployeeDto;

public class FakeData {
    public static ArrayList<CourseDetailDto> getCourseDetails(){
        ArrayList<CourseDetailDto> courses = new ArrayList<CourseDetailDto>();
        courses.add(new CourseDetailDto(0,"C#", 7.8,7.8,"6/10", true));
        courses.add(new CourseDetailDto(0,"Java", 7.8,7.8,"4/10", false));
        courses.add(new CourseDetailDto(0,"Android", 7.8,7.8,"5/10", true));
        return  courses;
    }

    public static ArrayList<AnnounceDto> getAnnounces(){
        ArrayList<AnnounceDto> announces = new ArrayList<AnnounceDto>();

        ArrayList<AnnounceDetailDto> details = new ArrayList<AnnounceDetailDto>();
        details.add(new AnnounceDetailDto("Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
        details.add(new AnnounceDetailDto("Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
        details.add(new AnnounceDetailDto("Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
        details.add(new AnnounceDetailDto("Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
        announces.add(new AnnounceDto("Today",details));
        return  announces;
    }

    public static ArrayList<EmployeeDto> getEmployees(){
        ArrayList<EmployeeDto> employees = new ArrayList<EmployeeDto>();

        employees.add(new EmployeeDto("","Ten nhan vien","0132564","abc@gmail.com"));
        employees.add(new EmployeeDto("","Ten nhan vien","0132564","abc@gmail.com"));
        employees.add(new EmployeeDto("","Ten nhan vien","0132564","abc@gmail.com"));
        employees.add(new EmployeeDto("","Ten nhan vien","0132564","abc@gmail.com"));
        employees.add(new EmployeeDto("","Ten nhan vien","0132564","abc@gmail.com"));

        return employees;
    }
}
