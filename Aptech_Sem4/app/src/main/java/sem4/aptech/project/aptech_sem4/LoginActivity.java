package sem4.aptech.project.aptech_sem4;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import model.inputs.LoginDto;


public class LoginActivity extends AppCompatActivity{

    // UI references.
    private Button btn_login;
    private EditText edt_password;
    private EditText edt_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

        edt_password = (EditText) findViewById(R.id.tv_login_password);
        edt_username = (EditText) findViewById(R.id.tv_login_name);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask.execute(new Runnable() {
                    @Override
                    public void run() {
                        // Create URL
                        try {
                            URL githubEndpoint = new URL("https://student-management-api.herokuapp.com/auth/login");

                            // Create connection
                            HttpsURLConnection myConnection = (HttpsURLConnection) githubEndpoint.openConnection();
                            myConnection.setDoOutput(true);
                            myConnection.setDoInput(true);

                            myConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                            myConnection.setRequestProperty("Accept", "application/json");
                            myConnection.setRequestMethod("POST");

                            //LoginDto myData = new LoginDto(edt_username.getText().toString(), edt_password.getText().toString());
                            LoginDto myData = new LoginDto("Minhtritruong0209@gmail.com", "4eJAyOW8");
                            Gson gson = new Gson();
                            String json = gson.toJson(myData);
                            // Write the data
                            myConnection.getOutputStream().write(json.getBytes());

                            myConnection.connect();

                            if (myConnection.getResponseCode() == 200) {
                                InputStream responseBody = myConnection.getInputStream();

                                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                                JsonReader jsonReader = new JsonReader(responseBodyReader);

                                jsonReader.beginObject(); // Start processing the JSON object
                                while (jsonReader.hasNext()) { // Loop through all keys
                                    String key = jsonReader.nextName(); // Fetch the next key
                                    if (key.equals("organization_url")) { // Check if desired key
                                        // Fetch the value as a String
                                        String value = jsonReader.nextString();

                                        // Do something with the value
                                        // ...

                                        break; // Break out of the loop
                                    } else {
                                        jsonReader.skipValue(); // Skip values of other keys
                                    }
                                }

                                jsonReader.close();
                            } else {
                                // Error handling code goes here
                            }

                            myConnection.disconnect();

                        }catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }

    public String Login() throws MalformedURLException, IOException {

        /*

         * Open an HTTP Connection to the Logon.ashx page

         */

        HttpURLConnection httpcon = (HttpURLConnection) ((new URL("https://student-management-api.herokuapp.com/auth/login").openConnection()));

        httpcon.setDoOutput(true);

        httpcon.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        httpcon.setRequestProperty("Accept", "application/json");

        httpcon.setRequestMethod("POST");

        httpcon.connect();

        /*

         * Output user credentials over HTTP Output Stream

         */

        byte[] outputBytes = "{'username': 'Minhtritruong0209@gmail.com', 'password':'4eJAyOW8'}".getBytes("UTF-8");

        OutputStream os = httpcon.getOutputStream();

        os.write(outputBytes);

        os.close();

        /*

         * Call Function setCookie and pass the HttpUrlConnection. Set Function

         * will return a Cookie String used to authenticate user.

         */

        return setCookie(httpcon);

    }



    public String setCookie(HttpURLConnection httpcon) {



        /*

         * Process the HTTP Response Cookies from successful credentials

         */

        String headerName;

        ArrayList<String> cookies = new ArrayList<String>();



        for (int i=1; (headerName = httpcon.getHeaderFieldKey(i))!=null; i++) {



            if (headerName.equals("Set-Cookie")&& httpcon.getHeaderField(i) != "null") {

                cookies.add(httpcon.getHeaderField(i));

            }

        }

        httpcon.disconnect();

        /*

         * Filter cookies, create Session_ID Cookie

         */

        String cookieName = cookies.get(0);

        String cookie2 = cookies.get(1);

        String cookie1 = cookieName.substring(cookieName.indexOf("="), cookieName.indexOf(";")+2);

        cookie2 = cookie2.substring(0, cookie2.indexOf(";"));

        cookieName = cookieName.substring(0 , cookieName.indexOf("="));

        String cookie = cookieName+cookie1+cookie2;

        return cookie;

    }

}

