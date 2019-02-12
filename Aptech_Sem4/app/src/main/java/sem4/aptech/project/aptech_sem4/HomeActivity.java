package sem4.aptech.project.aptech_sem4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import fragments.BaseFragment;

public class HomeActivity extends Fragment implements BaseFragment {
    private View view;
    private RelativeLayout rl_course;
    private RelativeLayout rl_calendar;
    private RelativeLayout rl_employee;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_home, container, false);

        init();
        getWidget(view);
        setWidget();
        addListener();
        return view;
    }

    @Override
    public void init() {

    }

    @Override
    public void getWidget(View v) {
        rl_calendar = (RelativeLayout) v.findViewById(R.id.rl_calendar);
        rl_course = (RelativeLayout) v.findViewById(R.id.rl_course);
        rl_employee = (RelativeLayout) v.findViewById(R.id.rl_employee);
    }

    @Override
    public void setWidget() {

    }

    @Override
    public void addListener() {
        rl_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CourseActivity.class);
                startActivity(intent);
            }
        });

        rl_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CalendarActivity.class);
                startActivity(intent);
            }
        });

        rl_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EmployeeActivity.class);
                startActivity(intent);
            }
        });
    }
}
