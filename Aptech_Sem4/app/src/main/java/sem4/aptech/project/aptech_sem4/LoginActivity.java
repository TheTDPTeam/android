package sem4.aptech.project.aptech_sem4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import services.LoginService;


public class LoginActivity extends BaseActivity{
    private Button btn_login;
    private EditText edt_password;
    private EditText edt_username;
    private LoginService loginService;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void init() {
        loginService = LoginService.getInstance();
        getSharedPreferences();
    }

    @Override
    protected void getWidget() {
        edt_password = (EditText) findViewById(R.id.tv_login_password);
        edt_username = (EditText) findViewById(R.id.tv_login_name);
        btn_login = (Button) findViewById(R.id.btn_login);
    }

    @Override
    protected void setWidget() {

    }

    @Override
    protected void addListener() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(edt_username.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Enter your email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(edt_password.getText().toString()))
                {
                    Toast.makeText(LoginActivity.this,"Enter your password!!!",Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        if(loginService.login(edt_username.getText().toString(), edt_password.getText().toString())){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setVisibility(View.GONE);
                                    saveSharedPreferences();

                                    Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        }else{
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_LONG).show();
                                }
                            });
                        };
                    }
                });
            }
        });
    }

    private void saveSharedPreferences(){
        SharedPreferences pre = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor edit= pre.edit();
        edit.putString("user", edt_username.getText().toString());
        edit.putString("password", edt_password.getText().toString());
        edit.commit();
    }

    private void getSharedPreferences(){
        SharedPreferences pre=getSharedPreferences ("login",MODE_PRIVATE);
        String user = pre.getString("user", "");
        String password = pre.getString("password", "");

        if (! (TextUtils.isEmpty(user) || TextUtils.isEmpty(password))) {
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    if(loginService.login(user, password)){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }
                }
            });
        }
    }
}

