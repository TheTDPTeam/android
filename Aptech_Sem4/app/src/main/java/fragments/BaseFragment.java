package fragments;

import android.view.View;

public interface BaseFragment {
    void init() throws Exception;
    void getWidget(View v);
    void setWidget() throws Exception;
    void addListener();
}
