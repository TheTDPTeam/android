package models.outputs;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseSemesterDto implements Serializable {
    private String semesterName;
    private ArrayList<CourseDetailDto> subjects;

    public CourseSemesterDto() {
    }

    public CourseSemesterDto(String name, ArrayList<CourseDetailDto> subjects) {
        this.semesterName = name;
        this.subjects = subjects;
    }

    public String getName() {
        return semesterName;
    }

    public void setName(String name) {
        this.semesterName = name;
    }

    public ArrayList<CourseDetailDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<CourseDetailDto> subjects) {
        this.subjects = subjects;
    }
}
