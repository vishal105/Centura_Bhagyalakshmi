package materialtest.example.centura.centura_bhagyalakshmi.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.changepassword.ChangePasswordActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        login = (Button) findViewById(R.id.bt_login);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        startActivity(new Intent(LoginActivity.this,ChangePasswordActivity.class));
    }
}
