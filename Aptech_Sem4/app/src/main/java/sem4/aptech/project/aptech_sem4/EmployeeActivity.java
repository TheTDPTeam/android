package sem4.aptech.project.aptech_sem4;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import adapter.CustomListAdapter;
import adapter.ViewHolder;
import controllers.EmployeeController;
import models.outputs.EmployeeDto;

public class EmployeeActivity extends BaseActivity{
    private EmployeeController employeeController;
    private CustomListAdapter<EmployeeDto> adapter;
    private ArrayList<EmployeeDto> items;
    private GridView gridView;
    private ProgressBar progressBar;
    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_employee);
    }

    @Override
    protected void init() {
        employeeController = EmployeeController.getInstance();
        items = new ArrayList<EmployeeDto>();
        adapter = new CustomListAdapter<EmployeeDto>(getApplicationContext(), R.layout.item_employee, items) {
            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setTv_1((TextView) v.findViewById(R.id.tv_employee_name));
                vh.setTv_2((TextView) v.findViewById(R.id.tv_employee_phone));
                vh.setTv_3((TextView) v.findViewById(R.id.tv_employee_email));
                vh.setImageView_1((ImageView) v.findViewById(R.id.imv_employee));
            }

            @Override
            protected void setViewHolder(ViewHolder vh, EmployeeDto model) {
                vh.getTv_1().setText(model.getName());
                vh.getTv_2().setText(model.getPhone());
                vh.getTv_3().setText(model.getEmail());
//                Picasso.with(getBaseContext())
//                        .load(model.getImageUrl())
//                        .placeholder(R.mipmap.ic_launcher)
//                        .fit()
//                        .centerCrop()
//                        .into(vh.getImageView_1());
            }

            @Override
            protected void addListener(ViewHolder vh, EmployeeDto model) {

            }

            @Override
            protected List<EmployeeDto> modifyArrayAdapter(List<EmployeeDto> models) {
                return models;
            }
        };
    }

    @Override
    protected void getWidget() {
        progressBar = (ProgressBar) findViewById(R.id.progress_circular_employee);
        gridView = (GridView) findViewById(R.id.gv_employee);
        gridView.setHorizontalSpacing(50);
        gridView.setVerticalSpacing(50);
    }

    @Override
    protected void setWidget() {
        progressBar.setVisibility(View.VISIBLE);
        gridView.setAdapter(adapter);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    items = employeeController.getEmployees();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            adapter.setItems(items);
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
