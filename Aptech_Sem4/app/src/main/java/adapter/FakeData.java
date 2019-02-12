package adapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.DataFormatException;

import models.outputs.AnnounceDetailDto;
import models.outputs.AnnounceDto;
import models.outputs.CalendarDetailDto;
import models.outputs.CalendarDto;
import models.outputs.CourseDetailDto;
import models.outputs.CourseDto;
import models.outputs.CourseSemesterDto;
import models.outputs.CourseSemesterSubjectDto;
import models.outputs.EmployeeDto;

public class FakeData {
    public static ArrayList<CourseSemesterDto> getCourseDetails(){
        ArrayList<CourseSemesterDto> semester = new ArrayList<CourseSemesterDto>();
        ArrayList<CourseDetailDto> courses = new ArrayList<CourseDetailDto>();
        courses.add(new CourseDetailDto(0,"C#", 7.8,7.8,"6/10", true));
        courses.add(new CourseDetailDto(0,"Java", 7.8,7.8,"4/10", false));
        courses.add(new CourseDetailDto(0,"Android", 7.8,7.8,"5/10", true));
        semester.add(new CourseSemesterDto("Semester I",courses));
        semester.add(new CourseSemesterDto("Semester II",courses));
        return  semester;
    }

    public static ArrayList<AnnounceDto> getAnnounces(){
        ArrayList<AnnounceDto> announces = new ArrayList<AnnounceDto>();

        ArrayList<AnnounceDetailDto> details = new ArrayList<AnnounceDetailDto>();
        details.add(new AnnounceDetailDto("Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
        details.add(new AnnounceDetailDto("Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
        details.add(new AnnounceDetailDto("Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
        details.add(new AnnounceDetailDto("Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
        announces.add(new AnnounceDto("Today",details));
        announces.add(new AnnounceDto("Yesterday",details));
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

    public static ArrayList<CourseDto> getCourses(){
        ArrayList<CourseDto> courses = new ArrayList<CourseDto>();

        ArrayList<CourseSemesterSubjectDto> courseSemesters = new ArrayList<CourseSemesterSubjectDto>();
        ArrayList<CourseSemesterSubjectDto> courseSemesters1 = new ArrayList<CourseSemesterSubjectDto>();
        ArrayList<String> subjects = new ArrayList<String>();
        ArrayList<String> subjects1 = new ArrayList<String>();

        subjects.add("C#");
        subjects.add("Java");
        subjects.add("Android");
        subjects1.add("Android");

        courseSemesters.add(new CourseSemesterSubjectDto("Semester I", subjects));
        courseSemesters.add(new CourseSemesterSubjectDto("Semester II", subjects));
        courseSemesters1.add(new CourseSemesterSubjectDto("Semester I", subjects1));
        courseSemesters1.add(new CourseSemesterSubjectDto("Semester II", subjects1));

        courses.add(new CourseDto(0,"i13", courseSemesters));
        courses.add(new CourseDto(0,"i15", courseSemesters1));
        courses.add(new CourseDto(0,"i17", courseSemesters));

        return  courses;
    }

    public static ArrayList<CalendarDto> getCalendars(){
        ArrayList<CalendarDto> calendars = new ArrayList<CalendarDto>();

        ArrayList<CalendarDetailDto> calendarDetails = new ArrayList<CalendarDetailDto>();
        ArrayList<CalendarDetailDto> calendarDetail1s = new ArrayList<CalendarDetailDto>();
        ArrayList<Date> dates = new ArrayList<Date>();
        ArrayList<Date> date1s = new ArrayList<Date>();


        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 10);

        dates.add(cal.getTime());

        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 20);
        date1s.add(cal.getTime());

        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 12);

        dates.add(cal.getTime());

        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 19);
        date1s.add(cal.getTime());

        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 14);

        dates.add(cal.getTime());

        calendarDetails.add(new CalendarDetailDto("Ngo Thanh Tung","SQL","Alive","5/10", dates));
        calendarDetails.add(new CalendarDetailDto("Ngo Thanh Binh","Java","Alive","6/10", date1s));
        calendarDetail1s.add(new CalendarDetailDto("Ngo Thanh Binh","Java","Alive","6/10", date1s));

        calendars.add(new CalendarDto("Batch130",calendarDetails));
        calendars.add(new CalendarDto("Batch131",calendarDetail1s));
        calendars.add(new CalendarDto("Batch132",calendarDetails));
        calendars.add(new CalendarDto("Batch133",calendarDetails));
        calendars.add(new CalendarDto("Batch134",calendarDetails));
        calendars.add(new CalendarDto("Batch135",calendarDetails));
        return calendars;
    }
}
