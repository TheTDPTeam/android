package fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.CustomListAdapter;
import adapter.ViewHolder;
import common.Utils;
import controllers.InformationController;
import models.outputs.CourseDetailDto;
import models.outputs.CourseSemesterDto;
import sem4.aptech.project.aptech_sem4.R;

public class FragmentCourse extends Fragment implements BaseFragment{
    private View view;
    private ListView listView;
    private CustomListAdapter<CourseSemesterDto> adapter;
    private InformationController informationController;
    private ArrayList<CourseSemesterDto> items;
    public FragmentCourse() {
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
        view = inflater.inflate(R.layout.fragment_course, container, false);

        init();
        getWidget(view);
        setWidget();

        return view;
    }

    @Override
    public void init(){
        informationController = InformationController.getInstance();
        items = new ArrayList<CourseSemesterDto>();
        adapter = new CustomListAdapter<CourseSemesterDto>(getActivity(), R.layout.item_course_semester, items) {
            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setTv_1((TextView) v.findViewById(R.id.tv_course_semester));
                vh.setLv_1((ListView) v.findViewById(R.id.lv_course_semester));
            }
            @Override
            protected void setViewHolder(ViewHolder vh, CourseSemesterDto model) {
                vh.getTv_1().setText(model.getName());

                CustomListAdapter<CourseDetailDto> adapterDetails = new CustomListAdapter<CourseDetailDto>(getActivity(), R.layout.item_course_details, model.getSubjects()) {
                    @Override
                    protected void getViewHolder(ViewHolder vh, View v) {
                        vh.setTv_1((TextView) v.findViewById(R.id.tv_course_name));
                        vh.setTv_2((TextView) v.findViewById(R.id.tv_course_socreTheory));
                        vh.setTv_3((TextView) v.findViewById(R.id.tv_course_socrePractice));
                        vh.setTv_4((TextView) v.findViewById(R.id.tv_course_socreRoll));
                        vh.setImageView_1((ImageView) v.findViewById(R.id.imv_course_check));
                    }

                    @Override
                    protected void setViewHolder(ViewHolder vh, CourseDetailDto model) {
                        vh.getTv_1().setText(model.getName());
                        vh.getTv_2().setText(getString(R.string.socre_theory) + model.getSocreTheory().toString());
                        vh.getTv_3().setText(getString(R.string.socre_practice) + model.getSocrePractice().toString());
                        vh.getTv_4().setText(getString(R.string.roll_call) + model.getRollCall());
                        if(model.isSuccess()){
                            vh.getImageView_1().setImageResource(R.drawable.infor_phone_yes);
                        }else {
                            vh.getImageView_1().setImageResource(R.drawable.infor_phone_no);
                        }
                    }

                    @Override
                    protected void addListener(ViewHolder vh, CourseDetailDto model) {

                    }

                    @Override
                    protected List<CourseDetailDto> modifyArrayAdapter(List<CourseDetailDto> models) {
                        return models;
                    }
                };
                vh.getLv_1().setAdapter(adapterDetails);
                Utils.setListViewHeightBasedOnChildren(vh.getLv_1());
            }
            @Override
            protected void addListener(ViewHolder vh, CourseSemesterDto model) {
            }

            @Override
            protected List<CourseSemesterDto> modifyArrayAdapter(List<CourseSemesterDto> models) {
                return models;
            }
        };
    }

    @Override
    public void getWidget(View v) {
        listView = (ListView) v.findViewById(R.id.lv_course);
    }

    @Override
    public void setWidget(){
        listView.setAdapter(adapter);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    items = informationController.getCourseDetails();
                    adapter.setItems(items);
                    Utils.setListViewHeightBasedOnChildren(listView);
                }
                catch (Exception ex){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(),getString(R.string.error_message), Toast.LENGTH_LONG);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void addListener() {

    }
}
