package materialtest.example.centura.centura_bhagyalakshmi.changepassword;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.login.LoginActivity;
import materialtest.example.centura.centura_bhagyalakshmi.support.Sync_api;

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
                                Sync_api.changepasswordApi(ChangePasswordActivity.this, old_password_et, new_password_et);
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
