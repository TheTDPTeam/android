package sem4.aptech.project.aptech_sem4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

import adapter.CustomExpandableListAdapter;

public class CalendarActivity extends AppCompatActivity {

    CustomExpandableListAdapter elva;
    ExpandableListView elvHuman;
    ArrayList<String> alHeader;
    HashMap<String, ArrayList<String>> hmItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Tham chiếu ExpandableListView
        elvHuman = (ExpandableListView) findViewById(R.id.elv_calendar);
        // Đọc dữ liệu từ SQLite
        loadData();
        elva = new CustomExpandableListAdapter(this, alHeader, hmItem);
        // Chỉ định Adapter cho ExpandableListView
        elvHuman.setAdapter(elva);
    }

    /*
     * Đọc dữ liệu từ SQLite
     */
    private void loadData() {
//        HumanDBHandling db = new HumanDBHandling(this);
//        hmItem = new HashMap<String, ArrayList<String>>();
//
//        // Dữ liệu cho header được lấy từ bảng department
        alHeader = new ArrayList<String>();
        alHeader.add("Batch130");
//
//        // Dữ liệu tương ứng với mỗi header được lấy từ bảng employee
//        ArrayList<String> itItem = new ArrayList<String>();
//        itItem = db.getAllEmployees("IT");
//
//        ArrayList<String> marketingItem = new ArrayList<String>();
//        marketingItem = db.getAllEmployees("MARKETING");
//
//        hmItem.put(alHeader.get(1), marketingItem);
    }
}
