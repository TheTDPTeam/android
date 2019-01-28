package models.outputs;

import java.io.Serializable;

public class CourseDetailDto implements Serializable {
    private int id;
    private String name;
    private Double socreTheory;
    private Double socrePractice;
    private String rollCall;
    private boolean isSuccess;

    public CourseDetailDto() {
    }

    public CourseDetailDto(int id, String name, Double socreTheory, Double socrePractice, String rollCall, boolean isSuccess) {
        this.id = id;
        this.name = name;
        this.socreTheory = socreTheory;
        this.socrePractice = socrePractice;
        this.rollCall = rollCall;
        this.isSuccess = isSuccess;
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

    public Double getSocreTheory() {
        return socreTheory;
    }

    public void setSocreTheory(Double socreTheory) {
        this.socreTheory = socreTheory;
    }

    public Double getSocrePractice() {
        return socrePractice;
    }

    public void setSocrePractice(Double socrePractice) {
        this.socrePractice = socrePractice;
    }

    public String getRollCall() {
        return rollCall;
    }

    public void setRollCall(String rollCall) {
        this.rollCall = rollCall;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
