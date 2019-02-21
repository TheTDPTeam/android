package fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import controllers.InformationController;
import models.inputs.UpdateUserDetailDto;
import models.outputs.UserDetail;
import sem4.aptech.project.aptech_sem4.R;

public class FragmentInfor extends Fragment implements BaseFragment{
    private UserDetail userDetail;
    private InformationController informationController;
    private EditText et_mail;
    private EditText et_firstName, et_lastName;
    private EditText et_phone;
    private ProgressBar progressBar;
    private View view;
    private Boolean isNotFirstValue = false;
    private Button btn_update, btn_reset;

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
        addListener();
        return view;
    }

    @Override
    public void init(){
        informationController = InformationController.getInstance();
    }

    @Override
    public void getWidget(View v){
        et_mail = (EditText) v.findViewById(R.id.et_info_mail);
        et_firstName = (EditText) v.findViewById(R.id.et_info_firstName);
        et_lastName = (EditText) v.findViewById(R.id.et_info_Lastname);
        et_phone = (EditText) v.findViewById(R.id.et_info_phone);
        progressBar = (ProgressBar) v.findViewById(R.id.progress_circular_fragment_infor);
        btn_reset = (Button) v.findViewById(R.id.btn_reset);
        btn_update = (Button) v.findViewById(R.id.btn_update);
    }

    @Override
    public void setWidget(){
        progressBar.setVisibility(View.VISIBLE);
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
                                et_firstName.setText(userDetail.getFirstName());
                                et_lastName.setText(userDetail.getLastName());
                                et_phone.setText(userDetail.getPhone());
                                progressBar.setVisibility(View.GONE);
                                isNotFirstValue = true;
                            }
                        });
                    }
                } catch (Exception e) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(),getString(R.string.error_message), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    @Override
    public void addListener(){
        et_firstName.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                changed();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });


        et_phone.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                changed();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        et_lastName.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                changed();
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              et_mail.setText(userDetail.getEmail());
              et_firstName.setText(userDetail.getFirstName());
              et_lastName.setText(userDetail.getLastName());
              et_phone.setText(userDetail.getPhone());
              setEnableButton(View.GONE);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_phone.getText().toString())) {
                    Toast.makeText(getContext(), "Phone is not be null!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(et_firstName.getText().toString())) {
                    Toast.makeText(getContext(), "FirstName is not be null!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(et_lastName.getText().toString())) {
                    Toast.makeText(getContext(), "LastName is not be null!", Toast.LENGTH_SHORT).show();
                    return;
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                builder.setTitle("Confirm");
                builder.setMessage("Do you want to update?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        progressBar.setVisibility(View.VISIBLE);
                        AsyncTask.execute(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    UserDetail userDetailUpdate = informationController.update(
                                            new UpdateUserDetailDto(et_firstName.getText().toString(),et_lastName.getText().toString(),et_phone.getText().toString()));

                                    if(userDetailUpdate.getEmail() != null){
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                et_mail.setText(userDetailUpdate.getEmail());
                                                et_firstName.setText(userDetailUpdate.getFirstName());
                                                et_lastName.setText(userDetailUpdate.getLastName());
                                                et_phone.setText(userDetailUpdate.getPhone());
                                                progressBar.setVisibility(View.GONE);
                                                Toast.makeText(getContext(),getString(R.string.success_message), Toast.LENGTH_LONG).show();
                                            }
                                        });
                                        userDetail = userDetailUpdate;
                                    }else {
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                progressBar.setVisibility(View.GONE);
                                                Toast.makeText(getContext(),getString(R.string.error_message), Toast.LENGTH_LONG).show();
                                            }
                                        });
                                    }
                                } catch (Exception e) {
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            progressBar.setVisibility(View.GONE);
                                            Toast.makeText(getContext(),getString(R.string.error_message), Toast.LENGTH_LONG).show();
                                        }
                                    });
                                }
                            }
                        });
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    private void setEnableButton(int isVisible){
        btn_reset.setVisibility(isVisible);
        btn_update.setVisibility(isVisible);
    }

    private void changed(){
        if(isNotFirstValue && !(et_phone.getText().toString().equals(userDetail.getPhone())
                && et_firstName.getText().toString().equals(userDetail.getFirstName())
                && et_lastName.getText().toString().equals(userDetail.getLastName()))){
            setEnableButton(View.VISIBLE);
        }else {
            setEnableButton(View.GONE);
        }
    }
}
