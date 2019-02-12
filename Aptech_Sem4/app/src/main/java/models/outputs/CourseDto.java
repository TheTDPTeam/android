package models.outputs;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseDto implements Serializable {
    private int id;
    private String name;
    private ArrayList<CourseSemesterSubjectDto> details;

    public CourseDto() {
    }

    public CourseDto(int id, String name, ArrayList<CourseSemesterSubjectDto> details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CourseSemesterSubjectDto> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<CourseSemesterSubjectDto> details) {
        this.details = details;
    }
}
