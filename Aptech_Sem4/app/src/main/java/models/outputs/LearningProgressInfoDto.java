package models.outputs;

import java.io.Serializable;

public class LearningProgressInfoDto implements Serializable {
    private double cumulativeGradePointAverage;
    private double gradeNeededToGetNextLevel;
    private int latestSemester;

    public LearningProgressInfoDto(double cumulativeGradePointAverage, double gradeNeededToGetNextLevel, int latestSemester) {
        this.cumulativeGradePointAverage = cumulativeGradePointAverage;
        this.gradeNeededToGetNextLevel = gradeNeededToGetNextLevel;
        this.latestSemester = latestSemester;
    }

    public double getCumulativeGradePointAverage() {
        return cumulativeGradePointAverage;
    }

    public void setCumulativeGradePointAverage(double cumulativeGradePointAverage) {
        this.cumulativeGradePointAverage = cumulativeGradePointAverage;
    }

    public double getGradeNeededToGetNextLevel() {
        return gradeNeededToGetNextLevel;
    }

    public void setGradeNeededToGetNextLevel(double gradeNeededToGetNextLevel) {
        this.gradeNeededToGetNextLevel = gradeNeededToGetNextLevel;
    }

    public int getLatestSemester() {
        return latestSemester;
    }

    public void setLatestSemester(int latestSemester) {
        this.latestSemester = latestSemester;
    }
}
