package models.outputs;

import java.util.Date;

public class AttendanceDto {
    private String status;
    private Date checkingDate;

    public AttendanceDto(String status, Date checkingDate) {
        this.status = status;
        this.checkingDate = checkingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCheckingDate() {
        return checkingDate;
    }

    public void setCheckingDate(Date checkingDate) {
        this.checkingDate = checkingDate;
    }
}
