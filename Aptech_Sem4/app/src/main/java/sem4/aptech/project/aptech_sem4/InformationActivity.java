package sem4.aptech.project.aptech_sem4;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import adapter.ViewPagerAdapter;
import controllers.InformationController;
import fragments.BaseFragment;
import fragments.FragmentCourse;
import fragments.FragmentInfor;
import models.outputs.LearningProgressInfoDto;

import static android.content.Context.MODE_PRIVATE;

public class InformationActivity extends Fragment implements BaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private Button btn_logout;
    private View view;
    private TextView tv_score, tv_semester, tv_credit;
    private InformationController informationController;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_information, container, false);

        init();
        getWidget(view);
        setWidget();
        addListener();
        return view;
    }

    @Override
    public void init() {
        informationController = InformationController.getInstance();
        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentInfor(), "Info");
        viewPagerAdapter.addFragment(new FragmentCourse(), "Course");
    }

    @Override
    public void getWidget(View v) {
        btn_logout = (Button) v.findViewById(R.id.btn_logout);
        viewPager = (ViewPager) v.findViewById(R.id.pager);
        tabLayout= (TabLayout) v.findViewById(R.id.tabs);
        tv_semester = (TextView) v.findViewById(R.id.tv_infor_semester);
        tv_score = (TextView) v.findViewById(R.id.tv_infor_score);
        tv_credit = (TextView) v.findViewById(R.id.tv_infor_credit);
    }

    @Override
    public void setWidget() {
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    LearningProgressInfoDto learningProgressInfo = informationController.getLastSemesterSocore();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tv_credit.setText(learningProgressInfo.getGradeNeededToGetNextLevel() + "");
                            tv_score.setText(learningProgressInfo.getCumulativeGradePointAverage() + "");

                            String semester = "Unknown";
                            switch (learningProgressInfo.getLatestSemester()){
                                case 1 : semester = "I"; break;
                                case 2 : semester = "II"; break;
                                case 3 : semester = "III"; break;
                                case 4 : semester = "IV"; break;
                            }
                            tv_semester.setText(semester);
                        }
                    });
                }
                catch (Exception ex){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(),getString(R.string.error_message), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    @Override
    public void addListener() {
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setTitle("Confirm");
                builder.setMessage("Do you want to logout?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        saveSharedPreferences();
                        Intent intent = new Intent(getContext(), LoginActivity.class);
                        getActivity().startActivity(intent);
                        getActivity().finish();
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    private void saveSharedPreferences(){
        SharedPreferences pre = getActivity().getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor edit= pre.edit();
        edit.putString("user", "");
        edit.putString("password", "");
        edit.commit();
    }
}
