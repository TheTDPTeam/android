package sem4.aptech.project.aptech_sem4;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import adapter.ViewPagerAdapter;
import fragments.FragmentCourse;
import fragments.FragmentInfor;

public class InformationActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_information);
    }

    @Override
    protected void init() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentInfor(), "Info");
        viewPagerAdapter.addFragment(new FragmentCourse(), "Course");
    }

    @Override
    protected void getWidget() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout= (TabLayout) findViewById(R.id.tabs);
    }

    @Override
    protected void setWidget() {
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void addListener() {

    }
}
