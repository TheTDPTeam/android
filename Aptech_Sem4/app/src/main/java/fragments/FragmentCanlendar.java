package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import models.outputs.CalendarDto;
import sem4.aptech.project.aptech_sem4.R;
import view.CalendarCustomView;

public class FragmentCanlendar extends Fragment implements BaseFragment {
    private View view;
    private CalendarCustomView calendarView;
    private CalendarDto data;

    public static FragmentCanlendar newInstance(CalendarDto calendar) {
        FragmentCanlendar fragment = new FragmentCanlendar();
        Bundle bundle = new Bundle();
        if(calendar == null){
            calendar = new CalendarDto();
        }
        bundle.putSerializable("data", calendar);
        fragment.setArguments(bundle);
        return fragment ;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = (CalendarDto) getArguments().getSerializable("data");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_calendar, container, false);

        init();
        getWidget(view);
        setWidget();

        return view;
    }

    @Override
    public void init()
    {

    }

    @Override
    public void getWidget(View v)
    {
        calendarView = (CalendarCustomView) v.findViewById(R.id.calendarView);
    }

    @Override
    public void setWidget()
    {
        calendarView.setItems(data);
    }

    @Override
    public void addListener()
    {
    }
}
