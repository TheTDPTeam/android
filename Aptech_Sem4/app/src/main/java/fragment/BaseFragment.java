package fragment;

import android.view.View;

public interface BaseFragment {
    void init();
    void getWidget(View v);
    void setWidget();
    void addListener();
}
