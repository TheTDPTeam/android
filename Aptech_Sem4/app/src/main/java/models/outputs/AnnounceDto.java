package models.outputs;

import java.io.Serializable;
import java.util.ArrayList;

public class AnnounceDto implements Serializable {
    private String date;
    private ArrayList<AnnounceDetailDto> details;

    public AnnounceDto() {
    }

    public AnnounceDto(String date, ArrayList<AnnounceDetailDto> details) {
        this.date = date;
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<AnnounceDetailDto> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<AnnounceDetailDto> details) {
        this.details = details;
    }
}
