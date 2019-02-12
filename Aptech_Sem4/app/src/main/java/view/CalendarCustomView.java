package view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import adapter.GridAdapter;
import models.outputs.CalendarDetailDto;
import sem4.aptech.project.aptech_sem4.R;

public class CalendarCustomView extends LinearLayout {
    private ArrayList<CalendarDetailDto> data;
    private static final String TAG = CalendarCustomView.class.getSimpleName();
    private ImageView previousButton, nextButton;
    private Button currentButton;
    private TextView currentDate, currentYear, currentDay, tv_subject, tv_teacher, tv_status, tv_attendance;
    private GridView calendarGridView;
    private static final int MAX_CALENDAR_COLUMN = 42;
    private int month, year, day, dayOfWeek;
    private Calendar currentTime = Calendar.getInstance();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM", Locale.ENGLISH);
    private SimpleDateFormat formatter2 = new SimpleDateFormat("MMMM", Locale.ENGLISH);
    private Calendar cal = Calendar.getInstance(Locale.ENGLISH);
    private Context context;
    private GridAdapter mAdapter;
    public CalendarCustomView(Context context) {
        super(context);
    }
    public CalendarCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initializeUILayout();
        setUpCalendarAdapter();
        setPreviousButtonClickEvent();
        setNextButtonClickEvent();
        setGridCellClickEvents();
        goToCurrentDayClickEvent();
    }
    public CalendarCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void initializeUILayout(){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.calendar_layout, this);

        init();
        getWidget(view);
        setWidget();
    }

    private void getWidget(View v){
        previousButton = (ImageView)v.findViewById(R.id.previous_month);
        nextButton = (ImageView)v.findViewById(R.id.next_month);
        calendarGridView = (GridView)v.findViewById(R.id.calendar_grid);
        currentButton = (Button) v.findViewById(R.id.date_display_today);
        tv_attendance = (TextView) v.findViewById(R.id.tv_calendar_attendance);
        tv_status = (TextView) v.findViewById(R.id.tv_calendar_status);
        tv_subject = (TextView) v.findViewById(R.id.tv_calendar_subject);
        tv_teacher = (TextView) v.findViewById(R.id.tv_calendar_teacher);
        currentDate = (TextView)v.findViewById(R.id.display_current_date);
        currentDay = (TextView)v.findViewById(R.id.date_display_day);
        currentYear = (TextView)v.findViewById(R.id.date_display_year);
    }

    private void init(){
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        year = cal.get(Calendar.YEAR);
    }

    private void setWidget(){
        currentDate.setText(formatter.format(currentTime.getTime()));
        currentYear.setText(year + "");
        currentDay.setText(convertDay(dayOfWeek));
    }

    private String convertDay(int dayOfWeek){
        switch (dayOfWeek){
            case 2: return "MonDay";
            case 3: return "TuesDay";
            case 4: return "WednesDay";
            case 5: return "ThursDay";
            case 6: return "FriDay";
            case 7: return "SaturDay";
            default: return "SunDay";
        }
    }

    private void goToCurrentDayClickEvent(){
        currentButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cal = Calendar.getInstance(Locale.ENGLISH);
                currentDate.setText(formatter.format(cal.getTime()));
                setUpCalendarAdapter();
                for (CalendarDetailDto i: data)
                {
                    if(setWidgetDetail(i, currentTime.getTime())){
                        break;
                    }
                }
            }
        });
    }

    private void setPreviousButtonClickEvent(){
        previousButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.add(Calendar.MONTH, -1);
                if(cal.get(Calendar.MONTH) == month && cal.get(Calendar.YEAR) == year){
                    currentDate.setText(formatter.format(cal.getTime()));
                }else {
                    currentDate.setText(formatter2.format(cal.getTime()));
                }
                setUpCalendarAdapter();
            }
        });
    }
    private void setNextButtonClickEvent(){
        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.add(Calendar.MONTH, 1);
                if(cal.get(Calendar.MONTH) == month && cal.get(Calendar.YEAR) == year){
                    currentDate.setText(formatter.format(cal.getTime()));
                }else {
                    currentDate.setText(formatter2.format(cal.getTime()));
                }
                setUpCalendarAdapter();
            }
        });
    }

    private void setGridCellClickEvents(){
        calendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView dateValue;
                Date date = new Date();
                for (CalendarDetailDto i: data)
                {
                    dateValue = (TextView) view.findViewById(R.id.tv1);
                    try {
                        date.setTime(Date.parse(dateValue.getText().toString()));
                        if(setWidgetDetail(i,date)){
                            break;
                        }
                    }catch (Exception ex){
                        setWidgetDetail(i,null);
                    }
                }
            }
        });
    }

    private boolean setWidgetDetail(CalendarDetailDto data, Date dateCompare){
        tv_teacher.setText("");
        tv_attendance.setText("");
        tv_status.setText("");
        tv_subject.setText("");
        if(dateCompare != null){
            for (Date i: data.getDates())
            {
                SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
                if(dt1.format(i).equals(dt1.format(dateCompare))){
                    tv_teacher.setText(data.getTeacher());
                    tv_attendance.setText(data.getAttendance());
                    tv_status.setText(data.getStatus());
                    tv_subject.setText(data.getSubject());
                    return true;
                }
            }
        }
        return false;
    }

    public void setItems(ArrayList<CalendarDetailDto> data){
        this.data = data;
        setUpCalendarAdapter();
        for (CalendarDetailDto i: data)
        {
            if(setWidgetDetail(i, currentTime.getTime())){
                break;
            }
        }
    }

    private void setUpCalendarAdapter(){
        List<Date> dayValueInCells = new ArrayList<Date>();

        ArrayList<Date> dates = new ArrayList<Date>();
        if(data != null){
            for (CalendarDetailDto i : data)
            {
                dates.addAll(i.getDates());
            }
        }

        Calendar mCal = (Calendar)cal.clone();
        mCal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfTheMonth = mCal.get(Calendar.DAY_OF_WEEK) - 1;
        mCal.add(Calendar.DAY_OF_MONTH, -firstDayOfTheMonth);
        while(dayValueInCells.size() < MAX_CALENDAR_COLUMN){
            dayValueInCells.add(mCal.getTime());
            mCal.add(Calendar.DAY_OF_MONTH, 1);
        }

        mAdapter = new GridAdapter(context, dayValueInCells, cal, currentTime, dates);
        calendarGridView.setAdapter(mAdapter);
    }
}
