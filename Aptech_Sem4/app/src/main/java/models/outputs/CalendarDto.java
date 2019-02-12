package models.outputs;

import java.io.Serializable;
import java.util.ArrayList;

public class CalendarDto implements Serializable {
    private String name;
    private ArrayList<CalendarDetailDto> details;

    public CalendarDto(){

    }

    public CalendarDto(String name, ArrayList<CalendarDetailDto> details) {
        this.name = name;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CalendarDetailDto> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<CalendarDetailDto> details) {
        this.details = details;
    }
}
