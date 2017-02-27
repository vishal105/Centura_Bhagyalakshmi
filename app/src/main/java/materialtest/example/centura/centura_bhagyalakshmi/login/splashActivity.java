package materialtest.example.centura.centura_bhagyalakshmi.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.dashboard.DashBoardActivity;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Genric;

import static materialtest.example.centura.centura_bhagyalakshmi.support.Class_Urls.Login;

public class splashActivity extends AppCompatActivity {

    public static final int SPLASH_DISPLAY_LENGTH = 1000;
    public static SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        sharedPreferences = this.getSharedPreferences(LoginActivity.MyPref, MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sharedPreferences.getString(LoginActivity.Sp_Status, "").matches("LoggedIn")) {

                        startActivity(new Intent(splashActivity.this, DashBoardActivity.class));
                    }
                 else {
                    Intent intent = new Intent(splashActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
    }

