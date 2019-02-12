package sem4.aptech.project.aptech_sem4;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import adapter.ViewPagerAdapter;
import fragments.BaseFragment;
import fragments.FragmentCourse;
import fragments.FragmentInfor;

public class InformationActivity extends Fragment implements BaseFragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
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

    }
}
