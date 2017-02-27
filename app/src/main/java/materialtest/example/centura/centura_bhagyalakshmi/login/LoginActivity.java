package materialtest.example.centura.centura_bhagyalakshmi.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.dashboard.DashBoardActivity;
import materialtest.example.centura.centura_bhagyalakshmi.models.CurrentUser;
import materialtest.example.centura.centura_bhagyalakshmi.models.KeyValuePair;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Genric;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_ModelDB;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Urls;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_login;
    EditText et_username, et_password;

    Gson gson;
    static int mStatusCode = 0;
    public static String Token ;
    String URL = "http://192.168.0.144:81/api/BhagyaLakshmi/";
    public static final String Sp_Status = "Status";
    public static final String MyPref = "MyPref";


    public String username, password;
    CurrentUser currentusermodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        bt_login = (Button) findViewById(R.id.bt_Login);
        bt_login.setOnClickListener(LoginActivity.this);
        currentusermodel = new CurrentUser();
    }


    @Override
    public void onClick(View v) {
        username = et_username.getText().toString().trim();
        password = et_password.getText().toString().trim();
        if (username.length() >= 1) {
            if (password.length() >= 1) {
                loginapi();
            } else {
                et_password.setError("Please enter Password");
            }
        } else {
            et_username.setError("Please enter Username");
        }
    }

    private void loginapi() {

        ArrayList<KeyValuePair> params = new ArrayList<KeyValuePair>();
        params.add(new KeyValuePair("UserName", username));
        params.add(new KeyValuePair("Password", password));
        //String LOGIN_URL = URL + "Login/" + "?UserName=" + username + "&&Password=" + password;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Class_Genric.generateUrl(Class_Urls.Login, params),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        SharedPreferences sharedPreferences = getSharedPreferences(MyPref, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        SharedPreferences.Editor editor1 = sharedPreferences.edit();

                        switch (mStatusCode) {
                            case 200:
                                try {
                                    gson = new Gson();
                                    JSONObject jsonObject = new JSONObject(response);
                                    Class_ModelDB.setCurrentuserModel(gson.fromJson(response.toString(),CurrentUser.class));
                                    startActivity(new Intent(LoginActivity.this, DashBoardActivity.class));
                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    editor.putString(Sp_Status, "LoggedIn");
                                    //editor1.putString(Token, Class_ModelDB.getCurrentuserModel().getToken());
                                    editor.commit();

                                    finish();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                        }
                    }

                }

                , new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    if (error != null && error.networkResponse != null) {
                        mStatusCode = error.networkResponse.statusCode;
                        switch (mStatusCode) {
                            case 400:
                                et_username.setError("Username or Password Invalid");
                                break;
                            case 401:
                                et_password.setError("Password Invalid");
                                break;
                        }
                    } else
                        Toast.makeText(LoginActivity.this, "Server Down", Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                mStatusCode = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };
        stringRequest.setRetryPolicy(new

                DefaultRetryPolicy(3000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

        );
        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(stringRequest);


    }
}



