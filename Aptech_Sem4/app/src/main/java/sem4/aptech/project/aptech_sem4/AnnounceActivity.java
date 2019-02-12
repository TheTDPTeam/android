package sem4.aptech.project.aptech_sem4;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.CustomListAdapter;
import adapter.ViewHolder;
import common.Utils;
import controllers.AnnounceController;
import fragments.BaseFragment;
import models.outputs.AnnounceDetailDto;
import models.outputs.AnnounceDto;

public class AnnounceActivity extends Fragment implements BaseFragment {
    private AnnounceController announceController;
    private ListView listView;
    private CustomListAdapter<AnnounceDto> adapter;
    private ArrayList<AnnounceDto> items;
    private View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_announce, container, false);

        init();
        getWidget(view);
        setWidget();

        return view;
    }

    @Override
    public void init() {
        announceController = AnnounceController.getInstance();
        items = new ArrayList<AnnounceDto>();
        adapter = new CustomListAdapter<AnnounceDto>(getActivity(), R.layout.item_listview_announce, items) {
            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setTv_1((TextView) v.findViewById(R.id.tv_announce_date));
                vh.setLv_1((ListView) v.findViewById(R.id.lv_announce_detail));
            }

            @Override
            protected void setViewHolder(ViewHolder vh, AnnounceDto model) {
                vh.getTv_1().setText(model.getDate());
                CustomListAdapter<AnnounceDetailDto> adapterDetails = new CustomListAdapter<AnnounceDetailDto>(getActivity(), R.layout.item_listview_announce_detail, model.getDetails()) {
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
                Utils.setListViewHeightBasedOnChildren(vh.getLv_1());
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
    public void getWidget(View v) {
        listView = (ListView) v.findViewById(R.id.lv_announce);
    }

    @Override
    public void setWidget() {
        listView.setAdapter(adapter);
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    items = announceController.getAnnounces();
                    adapter.setItems(items);
                    Utils.setListViewHeightBasedOnChildren(listView);
                }
                catch (Exception ex){
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(),getString(R.string.error_message), Toast.LENGTH_LONG);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void addListener() {

    }
}
