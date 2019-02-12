package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import models.outputs.CalendarDetailDto;
import sem4.aptech.project.aptech_sem4.R;
import view.CalendarCustomView;

public class FragmentCanlendar extends Fragment implements BaseFragment {
    private View view;
    private CalendarCustomView calendarView;
    private ArrayList<CalendarDetailDto> data;

    public static FragmentCanlendar newInstance(ArrayList<CalendarDetailDto> dto) {
        FragmentCanlendar fragment = new FragmentCanlendar();
        Bundle bundle = new Bundle();
        if(dto == null){
            dto = new ArrayList<CalendarDetailDto>();
        }
        bundle.putSerializable("data", dto);
        fragment.setArguments(bundle);
        return fragment ;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = (ArrayList<CalendarDetailDto>) getArguments().getSerializable("data");
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
        calendarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
