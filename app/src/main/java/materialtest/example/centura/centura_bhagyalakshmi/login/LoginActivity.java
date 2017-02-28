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
import materialtest.example.centura.centura_bhagyalakshmi.support.All_api;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Genric;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_ModelDB;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Urls;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_login;
    EditText et_username, et_password;

    Gson gson;
    static int mStatusCode = 0;
    public static final String Sp_Token="Token" ;
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
        if (et_username.getText().toString().trim().length() >= 1) {
            if (et_password.getText().toString().trim().length() >= 1) {
                All_api.loginapi(LoginActivity.this,et_username,et_password);
            } else {
                et_password.setError("Please enter Password");
            }
        } else {
            et_username.setError("Please enter Username");
        }
    }


}



