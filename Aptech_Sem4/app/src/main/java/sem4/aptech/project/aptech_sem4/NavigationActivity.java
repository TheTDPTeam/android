package sem4.aptech.project.aptech_sem4;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import adapter.ViewPagerAdapter;
import services.CurrentUserService;

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
        isAuthorize();
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new AnnounceActivity(),"");
        viewPagerAdapter.addFragment(new HomeActivity(), "");
        viewPagerAdapter.addFragment(new InformationActivity(), "");
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
        for (int i = 0; i < tabLayout.getTabCount(); i++)
        {
            switch (i){
                case 0 : tabLayout.getTabAt(i).setIcon(R.drawable.icon_menu_notification); break;
                case 1 : tabLayout.getTabAt(i).setIcon(R.drawable.icon_menu_home); break;
                case 2 : tabLayout.getTabAt(i).setIcon(R.drawable.infor_user); break;
            }
        }
        tabLayout.getTabAt(2).select();
    }

    @Override
    protected void addListener() {

    }

    private void isAuthorize(){
        if(CurrentUserService.getToken().isEmpty()){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
