package models.outputs;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseDto implements Serializable {
    private int id;
    private String courseCode;
    private ArrayList<CourseSemesterSubjectDto> semesters;

    public CourseDto() {
    }

    public CourseDto(int id, String name, ArrayList<CourseSemesterSubjectDto> details) {
        this.id = id;
        this.courseCode = name;
        this.semesters = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public ArrayList<CourseSemesterSubjectDto> getSemesters() {
        return semesters;
    }

    public void setSemesters(ArrayList<CourseSemesterSubjectDto> semesters) {
        this.semesters = semesters;
    }
}
