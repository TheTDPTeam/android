package sem4.aptech.project.aptech_sem4;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import adapter.ViewPagerAdapter;
import fragments.BaseFragment;
import fragments.FragmentCourse;
import fragments.FragmentInfor;

import static android.content.Context.MODE_PRIVATE;

public class InformationActivity extends Fragment implements BaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private Button btn_logout;
    private View view;
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
        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentInfor(), "Info");
        viewPagerAdapter.addFragment(new FragmentCourse(), "Course");
    }

    @Override
    public void getWidget(View v) {
        btn_logout = (Button) v.findViewById(R.id.btn_logout);
        viewPager = (ViewPager) v.findViewById(R.id.pager);
        tabLayout= (TabLayout) v.findViewById(R.id.tabs);
    }

    @Override
    public void setWidget() {
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
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
