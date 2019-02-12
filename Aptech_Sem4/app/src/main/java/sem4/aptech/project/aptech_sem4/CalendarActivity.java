package sem4.aptech.project.aptech_sem4;

import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.ViewPagerAdapter;
import controllers.CalendarController;
import fragments.FragmentCanlendar;
import models.outputs.CalendarDto;

public class CalendarActivity extends BaseActivity {
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private TabLayout tabLayout;
    private ArrayList<CalendarDto> items;
    private CalendarController calendarController;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_calendar);
    }

    @Override
    protected void init() {
        calendarController = CalendarController.getInstance();
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    @Override
    protected void getWidget() {
        viewPager = (ViewPager) findViewById(R.id.pager_calendar);
        tabLayout = (TabLayout) findViewById(R.id.tabs_calendar);
    }

    @Override
    protected void setWidget() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    items = calendarController.getCalendars();
                    if(items != null){
                        for (CalendarDto i : items)
                        {
                            adapter.addFragment(FragmentCanlendar.newInstance(i.getDetails()), i.getName());
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
