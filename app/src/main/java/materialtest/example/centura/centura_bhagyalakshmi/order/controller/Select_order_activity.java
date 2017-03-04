package materialtest.example.centura.centura_bhagyalakshmi.order.controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.order.Adapter.Select_Order_Adapter;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Genric;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Static;

public class Select_order_activity extends AppCompatActivity {
    RecyclerView recyclerView;
    public static TextView total;
    static TextView customername, orderdate, ordernumber, placedby;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_order_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=(RecyclerView)findViewById(R.id.select_orders);
        total=(TextView)findViewById(R.id.tv_amount);
        recyclerView.setLayoutManager(new LinearLayoutManager(Select_order_activity.this));
        customername = (TextView) findViewById(R.id.tv_distributor);
        orderdate = (TextView) findViewById(R.id.et_date);
        ordernumber = (TextView) findViewById(R.id.et_num);
        placedby = (TextView) findViewById(R.id.tv_placed_by);
        InitializeAdapter();
    }

    private void InitializeAdapter() {
        customername.setText(Class_Static.OrdredProducts.getClient().getName());
        placedby.setText(Class_Static.OrdredProducts.getUser().getName());
        orderdate.setText(Class_Genric.getDateTime(Class_Static.OrdredProducts));
        ordernumber.setText(Class_Static.OrdredProducts.getOrderNumber());
        total.setText(Class_Static.OrdredProducts.getTotalAmount().toString());
        recyclerView.setAdapter(new Select_Order_Adapter(Select_order_activity.this));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
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
