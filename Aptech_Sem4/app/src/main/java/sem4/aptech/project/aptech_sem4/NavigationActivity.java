package sem4.aptech.project.aptech_sem4;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import adapter.ViewPagerAdapter;

public class NavigationActivity extends BaseActivity{
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_navigation);
    }

    @Override
    protected void init() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new AnnounceActivity(), "Notification");
        viewPagerAdapter.addFragment(new HomeActivity(), "Home");
        viewPagerAdapter.addFragment(new InformationActivity(), "Infor");
    }

    @Override
    protected void getWidget() {
        viewPager = (ViewPager) findViewById(R.id.pager_navigation);
        tabLayout= (TabLayout) findViewById(R.id.tabs_navigation);
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
