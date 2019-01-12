package sem4.aptech.project.aptech_sem4;

import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import org.json.JSONException;

import java.io.IOException;

import adapter.ViewPagerAdapter;
import controller.InformationController;
import fragment.FragmentCourse;
import fragment.FragmentInfor;

public class InformationActivity extends BaseActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private InformationController informationController;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_information);
    }

    @Override
    protected void init() {
        informationController = InformationController.getInstance();
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
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    informationController.get();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
