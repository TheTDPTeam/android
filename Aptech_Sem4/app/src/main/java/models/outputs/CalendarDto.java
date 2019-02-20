package models.outputs;

import java.io.Serializable;
import java.util.ArrayList;

public class CalendarDto implements Serializable {
    private boolean isForCurrentStudent;
    private String classCode;
    private String teacherName;
    private String subjectName;
    private String semesterName;
    private String calendar;
    private ArrayList<AttendanceDto> attendances;

    public CalendarDto(){

    }

    public CalendarDto(boolean isForCurrentStudent, String classCode, String teacherName, String subjectName, String semesterName, String calendar, ArrayList<AttendanceDto> attendances) {
        this.isForCurrentStudent = isForCurrentStudent;
        this.classCode = classCode;
        this.teacherName = teacherName;
        this.subjectName = subjectName;
        this.semesterName = semesterName;
        this.calendar = calendar;
        this.attendances = attendances;
    }

    public boolean isForCurrentStudent() {
        return isForCurrentStudent;
    }

    public void setForCurrentStudent(boolean forCurrentStudent) {
        isForCurrentStudent = forCurrentStudent;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public ArrayList<AttendanceDto> getAttendances() {
        return attendances;
    }

    public void setAttendances(ArrayList<AttendanceDto> attendances) {
        this.attendances = attendances;
    }
}
