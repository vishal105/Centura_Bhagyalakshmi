package materialtest.example.centura.centura_bhagyalakshmi.order.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.models.distributor;
import materialtest.example.centura.centura_bhagyalakshmi.order.Adapter.Distributor_Adapter;

public class DistrubutorSearchActivity extends AppCompatActivity {
    public static RecyclerView distributor_list;
    Distributor_Adapter madapter;
    private RecyclerView.LayoutManager mlayoutmanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distrubutor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        distributor_list = (RecyclerView) findViewById(R.id.rv_distributor_list);
        distributor_list.setHasFixedSize(true);
        mlayoutmanager = new LinearLayoutManager(this);
        distributor_list.setLayoutManager(mlayoutmanager);
        madapter = new Distributor_Adapter(this);
        distributor_list.setAdapter(madapter);


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
