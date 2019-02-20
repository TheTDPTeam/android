package adapter;

import java.util.ArrayList;
import java.util.Calendar;

import models.outputs.AnnounceDetailDto;
import models.outputs.AnnounceDto;
import models.outputs.AttendanceDto;
import models.outputs.CalendarDto;
import models.outputs.CourseDetailDto;
import models.outputs.CourseDto;
import models.outputs.CourseSemesterDto;
import models.outputs.CourseSemesterSubjectDto;
import models.outputs.EmployeeDto;
import models.outputs.SubjectDto;

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
        details.add(new AnnounceDetailDto(0,"Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
        details.add(new AnnounceDetailDto(1,"Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
        details.add(new AnnounceDetailDto(2,"Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
        details.add(new AnnounceDetailDto(3,"Nghỉ học","Nghỉ lễ tết nguyên đán nhé."));
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
        ArrayList<SubjectDto> subjects = new ArrayList<SubjectDto>();
        ArrayList<SubjectDto> subjects1 = new ArrayList<SubjectDto>();

        SubjectDto subjectDto = new SubjectDto("mon hoc",true,true,"C#",5);
        subjects.add(subjectDto);
        subjects.add(subjectDto);
        subjects.add(subjectDto);
        subjects1.add(subjectDto);

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

        ArrayList<CalendarDto> calendarDetails = new ArrayList<CalendarDto>();
        ArrayList<CalendarDto> calendarDetail1s = new ArrayList<CalendarDto>();
        ArrayList<AttendanceDto> dates = new ArrayList<AttendanceDto>();
        ArrayList<AttendanceDto> date1s = new ArrayList<AttendanceDto>();


        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 10);

        dates.add(new AttendanceDto("status", cal.getTime()));


        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 20);
        date1s.add(new AttendanceDto("status", cal.getTime()));

        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 12);

        dates.add(new AttendanceDto("status", cal.getTime()));

        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 19);
        date1s.add(new AttendanceDto("status", cal.getTime()));

        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 14);

        dates.add(new AttendanceDto("status", cal.getTime()));

        calendars.add(new CalendarDto(false,"I12","Ngo Thanh Tung","SQL","Alive","5/10", dates));
        calendars.add(new CalendarDto(true,"I13","Ngo Thanh Binh","Java","Alive","6/10", date1s));
        calendars.add(new CalendarDto(false,"I14","Ngo Thanh Binh","Java","Alive","6/10", date1s));

        return calendars;
    }
}
