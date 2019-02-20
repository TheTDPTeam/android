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
                    int index = 0;
                    if(items != null){
                        for (int i = 0; i < items.size(); i++)
                        {
                            if(items.get(i).isForCurrentStudent()){
                                index = i;
                                adapter.addFragment(FragmentCanlendar.newInstance(items.get(i)), "My course");
                            }else {
                                adapter.addFragment(FragmentCanlendar.newInstance(items.get(i)), items.get(i).getClassCode());
                            }
                        }
                    }

                    final int index1 = index;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            viewPager.setAdapter(adapter);
                            tabLayout.setupWithViewPager(viewPager);
                            tabLayout.getTabAt(index1).select();
                        }
                    });
                }
                catch (Exception ex){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),getString(R.string.error_message), Toast.LENGTH_LONG).show();
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
