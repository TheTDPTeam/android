package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sem4.aptech.project.aptech_sem4.R;

public class FragmentActivityCourse extends Fragment implements BaseFragment{

    public FragmentActivityCourse() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activity_course, container, false);
    }

    @Override
    public void init() {

    }

    @Override
    public void getWidget(View v) {

    }

    @Override
    public void setWidget() {

    }

    @Override
    public void addListener() {

    }
}