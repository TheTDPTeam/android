package models.outputs;

import java.util.ArrayList;

public class CourseSemesterSubjectDto {
    private String semester;
    private ArrayList<String> subjects;

    public CourseSemesterSubjectDto() {
    }

    public CourseSemesterSubjectDto(String semester, ArrayList<String> subjects) {
        this.semester = semester;
        this.subjects = subjects;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<String> subjects) {
        this.subjects = subjects;
    }
}
