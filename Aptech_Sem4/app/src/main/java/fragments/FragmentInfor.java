package fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import controllers.InformationController;
import models.outputs.UserDetail;
import sem4.aptech.project.aptech_sem4.R;

public class FragmentInfor extends Fragment implements BaseFragment{
    private UserDetail userDetail;
    private InformationController informationController;
    private EditText et_mail;
    private EditText et_name;
    private EditText et_phone;
    private View view;

    public FragmentInfor() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_infor, container, false);

        init();
        getWidget(view);
        setWidget();

        return view;
    }

    @Override
    public void init(){
        informationController = InformationController.getInstance();
    }

    @Override
    public void getWidget(View v){
        et_mail = (EditText) v.findViewById(R.id.et_info_mail);
        et_name = (EditText) v.findViewById(R.id.et_info_name);
        et_phone = (EditText) v.findViewById(R.id.et_info_phone);
    }

    @Override
    public void setWidget(){
        AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                try {
                    userDetail = informationController.get();
                    if(userDetail.getEmail() != null){
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                et_mail.setText(userDetail.getEmail());
                                et_name.setText(userDetail.getFullName());
                                et_phone.setText(userDetail.getPhone());
                            }
                        });
                    }
                } catch (Exception e) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getContext(),getString(R.string.error_message), Toast.LENGTH_LONG);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void addListener(){

    }
}