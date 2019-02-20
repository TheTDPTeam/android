package models.outputs;

import java.io.Serializable;

public class CourseDetailDto implements Serializable {
    private int id;
    private String subjectName;
    private Double theoryScore;
    private Double practicalScore;
    private String attendingRate;
    private boolean success;

    public CourseDetailDto() {
    }

    public CourseDetailDto(int id, String name, Double socreTheory, Double socrePractice, String rollCall, boolean isSuccess) {
        this.id = id;
        this.subjectName = name;
        this.theoryScore = socreTheory;
        this.practicalScore = socrePractice;
        this.attendingRate = rollCall;
        this.success = isSuccess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return subjectName;
    }

    public void setName(String name) {
        this.subjectName = name;
    }

    public Double getSocreTheory() {
        return theoryScore;
    }

    public void setSocreTheory(Double socreTheory) {
        this.theoryScore = socreTheory;
    }

    public Double getSocrePractice() {
        return practicalScore;
    }

    public void setSocrePractice(Double socrePractice) {
        this.practicalScore = socrePractice;
    }

    public String getRollCall() {
        return attendingRate;
    }

    public void setRollCall(String rollCall) {
        this.attendingRate = rollCall;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        success = success;
    }
}
