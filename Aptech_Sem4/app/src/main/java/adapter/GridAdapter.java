package adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import constant.CalendarStatus;
import models.outputs.AttendanceDto;
import sem4.aptech.project.aptech_sem4.R;

public class GridAdapter extends ArrayAdapter {
    private static final String TAG = GridAdapter.class.getSimpleName();
    private LayoutInflater mInflater;
    private List<Date> monthlyDates;
    private Calendar currentSelectedDate;
    private Calendar currentDate;
    private List<AttendanceDto> attendances;
    public GridAdapter(Context context, List<Date> monthlyDates, Calendar currentSelectedDate, Calendar currentDate,List<AttendanceDto> attendances) {
        super(context, R.layout.single_cell_layout);
        this.monthlyDates = monthlyDates;
        this.currentSelectedDate = currentSelectedDate;
        this.attendances = attendances;
        this.currentDate = currentDate;
        mInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Date mDate = monthlyDates.get(position);
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(mDate);
        int dayValue = dateCal.get(Calendar.DAY_OF_MONTH);
        int displayMonth = dateCal.get(Calendar.MONTH) + 1;
        int displayYear = dateCal.get(Calendar.YEAR);
        int currentMonth = currentSelectedDate.get(Calendar.MONTH) + 1;
        int currentYear = currentSelectedDate.get(Calendar.YEAR);

        View view = convertView;
        if(view == null){
            view = mInflater.inflate(R.layout.single_cell_layout, parent, false);
        }

        if(currentDate.get(Calendar.DAY_OF_MONTH) == dayValue && (currentDate.get(Calendar.MONTH) + 1) == displayMonth && currentDate.get(Calendar.YEAR) == displayYear){
            view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.currentDate));
        }
        else if(displayMonth == currentMonth && displayYear == currentYear){
            view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.selectedMonth));
        }
        else {
            view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.notSelectedMonth));
        }

        //Add day to calendar
        TextView cellNumber = (TextView)view.findViewById(R.id.calendar_date_id);
        TextView cellValue = (TextView)view.findViewById(R.id.tv1);
        cellNumber.setText(String.valueOf(dayValue));
        //Add events to the calendar

        Calendar noteCalendar = Calendar.getInstance();
        for(int i = 0; i < attendances.size(); i++){
            noteCalendar.setTime(attendances.get(i).getCheckingDate());
            if(dayValue == noteCalendar.get(Calendar.DAY_OF_MONTH) && displayMonth == noteCalendar.get(Calendar.MONTH) + 1
                    && displayYear == noteCalendar.get(Calendar.YEAR)){

                switch (attendances.get(i).getStatus()){
                    case CalendarStatus.notYet: view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.calendarNotYet)); break;
                    case CalendarStatus.notAttended: view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.calendarNotAttended)); break;
                    case CalendarStatus.authorizedLeave: view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.calendarAuthorizedLeave)); break;
                    case CalendarStatus.unauthorizedLeave: view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.calendarUnauthorizedLeave)); break;
                    case CalendarStatus.attended: view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.calendarAttended)); break;
                    case CalendarStatus.skipped: view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.calendarSkipped)); break;
                    default: view.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.error)); break;
                }


                cellValue.setText(attendances.get(i).getCheckingDate().toString());
            }
        }
        return view;
    }
    @Override
    public int getCount() {
        return monthlyDates.size();
    }
    @Nullable
    @Override
    public Object getItem(int position) {
        return monthlyDates.get(position);
    }
    @Override
    public int getPosition(Object item) {
        return monthlyDates.indexOf(item);
    }
}
