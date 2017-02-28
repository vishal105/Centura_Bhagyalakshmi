package materialtest.example.centura.centura_bhagyalakshmi.order.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.models.OrderObject;
import materialtest.example.centura.centura_bhagyalakshmi.order.Adapter.OrderActivity_Adapter;

public class OrderActivity extends AppCompatActivity {
    private RecyclerView orderRecyclerView;
    LinearLayout orderedLayout, emptyOrders;
    Button Test_Button;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static ArrayList<OrderObject> orderList = new ArrayList<OrderObject>();
    private static String LOG_TAG = "OrderActivity_Adapter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*Test_Button = (Button) findViewById(R.id.test_Button);
        Test_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderActivity.this, Select_order_activity.class));
                finish();
            }
        });*/

        orderRecyclerView = (RecyclerView) findViewById(R.id.rv_order);
       // orderRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        orderRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new OrderActivity_Adapter(orderList);
        orderRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL);
        orderRecyclerView.addItemDecoration(itemDecoration);
//        recyclerviewdata();
        orderList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((OrderActivity_Adapter) mAdapter).setOnItemClickListener(new OrderActivity_Adapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                startActivity(new Intent(OrderActivity.this, Select_order_activity.class));
                finish();
                Log.i(LOG_TAG, " Clicked on Item " + position);
            }
        });
    }

    /*private void recyclerviewdata() {
        OrderObject orderObject;
        orderObject = new OrderObject("SO-0217-0725", "R.K.DISTRIBUTERS", "Authorized");
        orderList.add(orderObject);

    }*/

    private ArrayList<OrderObject> orderList() {
        ArrayList results = new ArrayList<OrderObject>();

        OrderObject orderObject = new OrderObject("SO-0217-0725", "R.K.DISTRIBUTERS", "Authorized");
        orderList.add(orderObject);
        return results;
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

