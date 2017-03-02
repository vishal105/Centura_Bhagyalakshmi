package materialtest.example.centura.centura_bhagyalakshmi.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.CurrentUser;
import materialtest.example.centura.centura_bhagyalakshmi.support.Sync_api;

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
                Sync_api.loginapi(LoginActivity.this,et_username,et_password);
            } else {
                et_password.setError("Please enter Password");
            }
        } else {
            et_username.setError("Please enter Username");
        }
    }


}



