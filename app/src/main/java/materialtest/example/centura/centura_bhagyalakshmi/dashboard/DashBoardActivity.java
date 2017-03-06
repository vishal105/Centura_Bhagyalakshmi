package materialtest.example.centura.centura_bhagyalakshmi.dashboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.changepassword.ChangePasswordActivity;
import materialtest.example.centura.centura_bhagyalakshmi.login.LoginActivity;
import materialtest.example.centura.centura_bhagyalakshmi.support.Sync_api;

public class DashBoardActivity extends AppCompatActivity {
    public static NavigationView navigationView;
    private static final String MENU_ITEM = "menu_item";
    public boolean mstatus;

    private int menuItemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                navigationView.getMenu().getItem(0).setChecked(true);

               /* if (menuItemId == item.getItemId()) {
                    drawer.closeDrawer(navigationView);
                    return true;
                }*/
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        //startActivity(new Intent(DashBoardActivity.this, DashBoardActivity.class));
                        // navigationView.getMenu().getItem(0).setChecked(true);
                        mstatus = true;
                        break;

                    case R.id.nav_changepassword:
                        startActivity(new Intent(DashBoardActivity.this, ChangePasswordActivity.class));
                        // navigationView.getMenu().getItem(0).setChecked(true);
                        mstatus = true;
                        break;

                    case R.id.nav_orders:
                        Sync_api.Orderapi(DashBoardActivity.this);
                        navigationView.getMenu().getItem(0).setChecked(true);
                        mstatus = true;
                        break;

                    case R.id.nav_logout:

                        SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.MyPref, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.commit();
                        Intent i = new Intent(DashBoardActivity.this, LoginActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        finish();
                        navigationView.getMenu().getItem(0).setChecked(true);
                        break;
                }
                drawer.closeDrawer(navigationView);
                menuItemId = item.getItemId();
                mstatus = false;
                navigationView.getMenu().getItem(0).setChecked(true);
                return mstatus;

            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MENU_ITEM, menuItemId);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.menuItemId = savedInstanceState.getInt(MENU_ITEM);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            navigationView.getMenu().getItem(0).setChecked(true);
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        /*getMenuInflater().inflate(R.menu.dash_board, menu);*/
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       *//* if (id == R.id.action_settings) {
            return true;
        }
*//*
        return super.onOptionsItemSelected(item);
    }
*/
    //@SuppressWarnings("StatementWithEmptyBody")
    /*@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            startActivity(new Intent(DashBoardActivity.this, DashBoardActivity.class));

            // Handle the camera action
        } else if (id == R.id.nav_myprofile) {

        } else if (id == R.id.nav_changepassword) {
            startActivity(new Intent(DashBoardActivity.this, ChangePasswordActivity.class));
        } else if (id == R.id.nav_orders) {
            Sync_api.Orderapi(DashBoardActivity.this);
        } else if (id == R.id.nav_logout) {
            SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.MyPref, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();

            Intent i = new Intent(DashBoardActivity.this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        } *//*else if (id == R.id.nav_send) {

        }*//*

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        item.setChecked(true);
        return true;
    }*/


}
