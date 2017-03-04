package materialtest.example.centura.centura_bhagyalakshmi.order.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.order.Adapter.OrderActivity_Adapter;
import materialtest.example.centura.centura_bhagyalakshmi.support.Sync_api;

public class OrderActivity extends AppCompatActivity {
    private RecyclerView orderRecyclerView;
    LinearLayout orderedLayout, emptyOrders;
    Button Test_Button;
    OrderActivity_Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static ArrayList<Order> orderList = new ArrayList<Order>();
    FloatingActionButton fb_addorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fb_addorder = (FloatingActionButton) findViewById(R.id.fb_addorder);
        fb_addorder.setVisibility(View.VISIBLE);
        fb_addorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Sync_api.Distributorapi(OrderActivity.this);
            }
        });

        orderRecyclerView = (RecyclerView) findViewById(R.id.rv_order);
      /*  orderRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, orderRecyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        startActivity(new Intent(OrderActivity.this, Select_order_activity.class));
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Toast.makeText(OrderActivity.this, "Click once that is more than enough", Toast.LENGTH_SHORT).show();
                    }
                })
        );*/

        orderRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        orderRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new OrderActivity_Adapter(this);
        InitializeAdapter(OrderActivity.this);

    }

    private void InitializeAdapter(Context context) {
        orderRecyclerView.setAdapter(new OrderActivity_Adapter(context));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL);
        orderRecyclerView.addItemDecoration(itemDecoration);
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




   /* public void click() {

        startActivity(new Intent(OrderActivity.this, Select_order_activity.class));
    }*/
}

