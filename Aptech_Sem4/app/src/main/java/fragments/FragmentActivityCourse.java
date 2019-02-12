package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import adapter.CustomListAdapter;
import adapter.ViewHolder;
import common.Utils;
import models.outputs.CourseDto;
import models.outputs.CourseSemesterSubjectDto;
import sem4.aptech.project.aptech_sem4.R;

public class FragmentActivityCourse extends Fragment implements BaseFragment{
    private View view;
    private CourseDto data;
    private ListView listView;
    private CustomListAdapter<CourseSemesterSubjectDto> adapter;

    public FragmentActivityCourse() {
    }

    public static FragmentActivityCourse newInstance(CourseDto course) {
        FragmentActivityCourse fragment = new FragmentActivityCourse();
        Bundle bundle = new Bundle();
        if(course == null){
            course = new CourseDto();
        }
        bundle.putSerializable("data", course);
        fragment.setArguments(bundle);
        return fragment ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = (CourseDto) getArguments().getSerializable("data");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_activity_course, container, false);

        init();
        getWidget(view);
        setWidget();
        return  view;
    }

    @Override
    public void init() {
        adapter = new CustomListAdapter<CourseSemesterSubjectDto>(getContext(), R.layout.item_listview_course, data.getDetails()) {
            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setTv_1((TextView) v.findViewById(R.id.tv_activity_course_semester));
                vh.setLv_1((ListView) v.findViewById(R.id.lv_activity_course_semester));
            }
            @Override
            protected void setViewHolder(ViewHolder vh, CourseSemesterSubjectDto model) {
                vh.getTv_1().setText(model.getSemester());

                CustomListAdapter<String> adapterDetails = new CustomListAdapter<String>(getContext(), R.layout.item_listview_course_infor, model.getSubjects()) {
                    @Override
                    protected void getViewHolder(ViewHolder vh, View v) {
                        vh.setTv_1((TextView) v.findViewById(R.id.tv_activity_course_subject_name));
                    }

                    @Override
                    protected void setViewHolder(ViewHolder vh, String model) {
                        vh.getTv_1().setText(model);
                    }

                    @Override
                    protected void addListener(ViewHolder vh, String model) {

                    }

                    @Override
                    protected List<String> modifyArrayAdapter(List<String> models) {
                        return models;
                    }
                };
                vh.getLv_1().setAdapter(adapterDetails);
                Utils.setListViewHeightBasedOnChildren(vh.getLv_1());
            }
            @Override
            protected void addListener(ViewHolder vh, CourseSemesterSubjectDto model) {
            }

            @Override
            protected List<CourseSemesterSubjectDto> modifyArrayAdapter(List<CourseSemesterSubjectDto> models) {
                return models;
            }
        };
    }

    @Override
    public void getWidget(View v) {
        listView = (ListView) v.findViewById(R.id.lv_course_subjects);
    }

    @Override
    public void setWidget() {
        listView.setAdapter(adapter);
        Utils.setListViewHeightBasedOnChildren(listView);
    }

    @Override
    public void addListener() {

    }
}
