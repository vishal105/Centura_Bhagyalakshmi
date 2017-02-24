package materialtest.example.centura.centura_bhagyalakshmi.order.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.order.Adapter.OrderActivity_Adapter;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_ModelDB;

public class OrderActivity extends AppCompatActivity {
    RecyclerView orderRecyclerView;
    LinearLayout orderedLayout,emptyOrders;
    private static ArrayList<Order> orderList = new ArrayList<Order>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        orderRecyclerView = (RecyclerView) findViewById(R.id.rv_order);
        orderRecyclerView.setLayoutManager(new LinearLayoutManager(OrderActivity.this));
        recyclerAdapter(OrderActivity.this);
        emptyOrders = (LinearLayout) findViewById(R.id.empty_active_orders);
        orderedLayout=(LinearLayout)findViewById(R.id.active_ordered_layout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void recyclerAdapter(Context context) {

        if(orderList.size()!=0){
            emptyOrders.setVisibility(View.GONE);
            orderedLayout.setVisibility(View.VISIBLE);
            orderRecyclerView.setVisibility(View.VISIBLE);
            orderRecyclerView.setAdapter(new OrderActivity_Adapter(context, orderList));
        }else {
            orderRecyclerView.setVisibility(View.GONE);
            orderedLayout.setVisibility(View.GONE);
            emptyOrders.setVisibility(View.VISIBLE);
        }
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
