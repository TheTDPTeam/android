package models.outputs;

public class SubjectDto {
    private String description;
    private Boolean hasPracticalExamination;
    private Boolean hasTheoryExamination;
    private String name;
    private int numberOfLessons;

    public SubjectDto(String description, Boolean hasPracticalExamination, Boolean hasTheoryExamination, String name, int numberOfLessons) {
        this.description = description;
        this.hasPracticalExamination = hasPracticalExamination;
        this.hasTheoryExamination = hasTheoryExamination;
        this.name = name;
        this.numberOfLessons = numberOfLessons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHasPracticalExamination() {
        return hasPracticalExamination;
    }

    public void setHasPracticalExamination(Boolean hasPracticalExamination) {
        this.hasPracticalExamination = hasPracticalExamination;
    }

    public Boolean getHasTheoryExamination() {
        return hasTheoryExamination;
    }

    public void setHasTheoryExamination(Boolean hasTheoryExamination) {
        this.hasTheoryExamination = hasTheoryExamination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfLessons() {
        return numberOfLessons;
    }

    public void setNumberOfLessons(int numberOfLessons) {
        this.numberOfLessons = numberOfLessons;
    }
}
