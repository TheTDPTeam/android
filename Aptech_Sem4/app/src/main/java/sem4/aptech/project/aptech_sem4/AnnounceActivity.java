package sem4.aptech.project.aptech_sem4;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.CustomListAdapter;
import adapter.ViewHolder;
import controllers.AnnounceController;
import models.outputs.AnnounceDetailDto;
import models.outputs.AnnounceDto;

public class AnnounceActivity extends BaseActivity {
    private AnnounceController announceController;
    private ListView listView;
    private CustomListAdapter<AnnounceDto> adapter;
    private ArrayList<AnnounceDto> items;
    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_announce);
    }

    @Override
    protected void init() {
        announceController = AnnounceController.getInstance();
        items = new ArrayList<AnnounceDto>();
        adapter = new CustomListAdapter<AnnounceDto>(getApplicationContext(), R.layout.item_listview_announce, items) {
            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setLv_1((ListView) v.findViewById(R.id.lv_announce_detail));
            }

            @Override
            protected void setViewHolder(ViewHolder vh, AnnounceDto model) {
                CustomListAdapter<AnnounceDetailDto> adapterDetails = new CustomListAdapter<AnnounceDetailDto>(getApplicationContext(), R.layout.item_listview_announce_detail, model.getDetails()) {
                    @Override
                    protected void getViewHolder(ViewHolder vh, View v) {
                        vh.setTv_1((TextView) v.findViewById(R.id.tv_announce_title));
                        vh.setTv_2((TextView) v.findViewById(R.id.tv_announce_content));
                    }

                    @Override
                    protected void setViewHolder(ViewHolder vh, AnnounceDetailDto model) {
                        vh.getTv_1().setText(model.getTitle());
                        vh.getTv_2().setText(model.getContent());
                    }

                    @Override
                    protected void addListener(ViewHolder vh, AnnounceDetailDto model) {

                    }

                    @Override
                    protected List<AnnounceDetailDto> modifyArrayAdapter(List<AnnounceDetailDto> models) {
                        return models;
                    }
                };
                vh.getLv_1().setAdapter(adapterDetails);
            }

            @Override
            protected void addListener(ViewHolder vh, AnnounceDto model) {

            }

            @Override
            protected List<AnnounceDto> modifyArrayAdapter(List<AnnounceDto> models) {
                return models;
            }
        };
    }

    @Override
    protected void getWidget() {
        listView = (ListView) findViewById(R.id.lv_announce);
    }

    @Override
    protected void setWidget() {
        listView.setAdapter(adapter);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    items = announceController.getAnnounces();
                    adapter.setItems(items);
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
