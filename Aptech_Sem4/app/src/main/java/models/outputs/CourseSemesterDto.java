package models.outputs;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseSemesterDto implements Serializable {
    private String name;
    private ArrayList<CourseDetailDto> subjects;

    public CourseSemesterDto() {
    }

    public CourseSemesterDto(String name, ArrayList<CourseDetailDto> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CourseDetailDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<CourseDetailDto> subjects) {
        this.subjects = subjects;
    }
}
