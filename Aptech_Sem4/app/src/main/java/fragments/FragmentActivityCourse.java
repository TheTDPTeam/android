package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
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
import models.outputs.SubjectDto;
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
        adapter = new CustomListAdapter<CourseSemesterSubjectDto>(getContext(), R.layout.item_listview_course, data.getSemesters()) {
            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setTv_1((TextView) v.findViewById(R.id.tv_activity_course_semester));
                vh.setLv_1((ListView) v.findViewById(R.id.lv_activity_course_semester));
            }
            @Override
            protected void setViewHolder(ViewHolder vh, CourseSemesterSubjectDto model) {
                vh.getTv_1().setText(model.getSemesterName());
                CustomListAdapter<SubjectDto> adapterDetails = new CustomListAdapter<SubjectDto>(getContext(), R.layout.item_listview_course_infor, model.getSubjects()) {
                    @Override
                    protected void getViewHolder(ViewHolder vh, View v) {
                        vh.setTv_1((TextView) v.findViewById(R.id.tv_activity_course_subject_name));
                        vh.setTv_2((TextView) v.findViewById(R.id.tv_activity_course_subject_desc));
                    }

                    @Override
                    protected void setViewHolder(ViewHolder vh, SubjectDto model) {
                        vh.getTv_1().setText(model.getName());
                        vh.getTv_2().setText(model.getDescription());
                    }

                    @Override
                    protected void addListener(ViewHolder vh, SubjectDto model) {

                    }

                    @Override
                    protected List<SubjectDto> modifyArrayAdapter(List<SubjectDto> models) {
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
