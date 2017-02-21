package materialtest.example.centura.centura_bhagyalakshmi.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.changepassword.ChangePasswordActivity;
import materialtest.example.centura.centura_bhagyalakshmi.dashboard.DashBoardActivity;
import materialtest.example.centura.centura_bhagyalakshmi.model.login;

import static materialtest.example.centura.centura_bhagyalakshmi.R.id.et_password;
import static materialtest.example.centura.centura_bhagyalakshmi.R.id.et_username;
import static materialtest.example.centura.centura_bhagyalakshmi.R.layout.activity_dash_board;
import static materialtest.example.centura.centura_bhagyalakshmi.R.string.login;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_login;
    EditText et_username, et_password;
    login loginmodel;
    String URL ="http://192.168.0.144:81/api/BhagyaLakshmi/";


    public String username, password;

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


    }


    @Override
    public void onClick(View v) {
        loginmodel = new login(username,password);
        username=et_username.getText().toString().trim();
        password=et_password.getText().toString().trim();
        if(username.length()>=1) {
            if (password.length()>=1){
                loginapi();



        }else {
                Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_SHORT).show();

            }
        }else {
            Toast.makeText(getApplicationContext(), "Please Enter Username", Toast.LENGTH_SHORT).show();

        }
    }

    private void loginapi() {
        String LOGIN_URL=URL+"Login/"+"?UserName=" + username + "&&Password=" + password;
        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.GET, LOGIN_URL
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,DashBoardActivity.class));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_SHORT).show();

            }

    });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(3000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
        requestQueue.add(jsonObjectRequest);

    }
}


