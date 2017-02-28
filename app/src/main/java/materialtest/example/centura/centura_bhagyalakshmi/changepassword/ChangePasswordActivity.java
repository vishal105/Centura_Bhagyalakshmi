package materialtest.example.centura.centura_bhagyalakshmi.changepassword;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.login.LoginActivity;
import materialtest.example.centura.centura_bhagyalakshmi.models.CurrentUser;
import materialtest.example.centura.centura_bhagyalakshmi.models.KeyValuePair;
import materialtest.example.centura.centura_bhagyalakshmi.support.All_api;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Genric;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_ModelDB;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Urls;

public class ChangePasswordActivity extends AppCompatActivity {

    EditText old_password_et, new_password_et, confirm_password_et;
    Button cancel_button, save_button;
    public static SharedPreferences sharedPreferences;

    static int mStatusCode = 0;

    public String oldpassword, newpassword, confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        old_password_et = (EditText) findViewById(R.id.old_password_et);
        new_password_et = (EditText) findViewById(R.id.new_password_et);
        confirm_password_et = (EditText) findViewById(R.id.confirm_password_et);
        cancel_button = (Button) findViewById(R.id.cancel_button);
        save_button = (Button) findViewById(R.id.save_button);
        onClicks();
        sharedPreferences = this.getSharedPreferences(LoginActivity.MyPref, MODE_PRIVATE);


    }

    public void onClicks() {


        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (old_password_et.getText().toString().trim().length() >= 1) {
                    if (new_password_et.getText().toString().trim().length() >= 1) {
                        if (confirm_password_et.getText().toString().trim().length() >= 1) {
                            if (new_password_et.getText().toString().trim().matches(confirm_password_et.getText().toString().trim())) {
                                All_api.changepasswordApi(ChangePasswordActivity.this, old_password_et, new_password_et);
                            } else {
                                Toast.makeText(ChangePasswordActivity.this, "Password Didn't Match", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            confirm_password_et.setError("This field required");
                        }

                    } else {
                        new_password_et.setError("This field required");
                    }
                } else {
                    old_password_et.setError("This field required");
                }
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}
