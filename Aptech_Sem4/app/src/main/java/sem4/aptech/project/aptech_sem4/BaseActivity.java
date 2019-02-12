package sem4.aptech.project.aptech_sem4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public abstract class BaseActivity extends AppCompatActivity {
    protected ProgressBar progressBar;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        init();
        getCommonWidget();
        getWidget();
        setWidget();
        addListener();
    }
    private void getCommonWidget(){
        progressBar = (ProgressBar) findViewById(R.id.progress_circular);
    }
    protected abstract void setContentView();
    protected abstract void init();
    protected abstract void getWidget();
    protected abstract void setWidget();
    protected abstract void addListener();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
