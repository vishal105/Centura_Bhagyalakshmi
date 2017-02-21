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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

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
        username=et_username.getText().toString();
        password=et_password.getText().toString();
        if(username.length()>=1) {
            if (password.length()>=1){
                startActivity(new Intent(LoginActivity.this,DashBoardActivity.class));


        }else {
                Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_SHORT).show();

            }
        }else {
            Toast.makeText(getApplicationContext(), "Please Enter Username", Toast.LENGTH_SHORT).show();

        }
    }
}

