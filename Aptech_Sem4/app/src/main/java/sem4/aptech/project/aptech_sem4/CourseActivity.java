package sem4.aptech.project.aptech_sem4;

import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.ViewPagerAdapter;
import controllers.CourseController;
import fragments.FragmentActivityCourse;
import models.outputs.CourseDto;

public class CourseActivity extends BaseActivity {
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private TabLayout tabLayout;
    private CourseController courseController;
    private ArrayList<CourseDto> items;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_course);
    }

    @Override
    protected void init() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        courseController = CourseController.getInstance();
    }

    @Override
    protected void getWidget() {
        viewPager = (ViewPager) findViewById(R.id.pager_course);
        tabLayout = (TabLayout) findViewById(R.id.tabs_course);
    }

    @Override
    protected void setWidget() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    items = courseController.getCourses();
                    if(items != null){
                        for (CourseDto i : items)
                        {
                            adapter.addFragment(FragmentActivityCourse.newInstance(i), i.getName());
                        }
                    }
                    viewPager.setAdapter(adapter);
                    tabLayout.setupWithViewPager(viewPager);
                }
                catch (Exception ex){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),getString(R.string.error_message), Toast.LENGTH_LONG);
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void addListener() {

    }
}
