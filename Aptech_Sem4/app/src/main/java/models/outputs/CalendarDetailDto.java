package models.outputs;

import java.util.ArrayList;
import java.util.Date;

public class CalendarDetailDto {
    private String teacher;
    private String subject;
    private String status;
    private String attendance;
    private ArrayList<Date> dates;

    public CalendarDetailDto(){

    }

    public CalendarDetailDto(String teacher, String subject, String status, String attendance, ArrayList<Date> dates) {
        this.teacher = teacher;
        this.subject = subject;
        this.status = status;
        this.attendance = attendance;
        this.dates = dates;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public ArrayList<Date> getDates() {
        return dates;
    }

    public void setDates(ArrayList<Date> dates) {
        this.dates = dates;
    }
}
