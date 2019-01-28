package sem4.aptech.project.aptech_sem4;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import adapter.ViewPagerAdapter;
import fragments.FragmentActivityCourse;

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager_course);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragments to adapter one by one
        adapter.addFragment(new FragmentActivityCourse(), "i13");
        adapter.addFragment(new FragmentActivityCourse(), "i15");
        adapter.addFragment(new FragmentActivityCourse(), "i17");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_course);
        tabLayout.setupWithViewPager(viewPager);
    }
}
