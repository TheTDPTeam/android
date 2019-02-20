package models.outputs;

import java.util.ArrayList;

public class CourseSemesterSubjectDto {
    private String semesterName;
    private ArrayList<SubjectDto> subjects;

    public CourseSemesterSubjectDto() {
    }

    public CourseSemesterSubjectDto(String semester, ArrayList<SubjectDto> subjects) {
        this.semesterName = semester;
        this.subjects = subjects;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public ArrayList<SubjectDto> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<SubjectDto> subjects) {
        this.subjects = subjects;
    }
}
