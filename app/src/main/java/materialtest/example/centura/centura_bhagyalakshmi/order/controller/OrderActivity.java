package materialtest.example.centura.centura_bhagyalakshmi.order.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.dashboard.DashBoardActivity;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.order.Adapter.OrderActivity_Adapter;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_ModelDB;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Static;
import materialtest.example.centura.centura_bhagyalakshmi.support.Sync_api;

public class OrderActivity extends AppCompatActivity {
    private RecyclerView orderRecyclerView;
    OrderActivity_Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    LinearLayout orderedLayout,emptyOrders;
    EditText orderSearch;
    FloatingActionButton fb_addorder;
    static ArrayList<Order> LocalOrder=new ArrayList<Order>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        emptyOrders = (LinearLayout) findViewById(R.id.empty_active_orders);
        orderedLayout = (LinearLayout) findViewById(R.id.active_ordered_layout);
        orderSearch=(EditText)findViewById(R.id.order_search);
        fb_addorder = (FloatingActionButton) findViewById(R.id.fb_addorder);
        fb_addorder.setVisibility(View.VISIBLE);
        fb_addorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Sync_api.Distributorapi(OrderActivity.this);
            }
        });

        orderRecyclerView = (RecyclerView) findViewById(R.id.rv_order);
        orderRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        orderRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new OrderActivity_Adapter(this, Class_ModelDB.getOrderList());
        Functionality(OrderActivity.this);
        InitializeAdapter(OrderActivity.this);

    }

    private void Functionality(final Context context) {
        orderSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().matches("")){
                    orderRecyclerView.setAdapter(new OrderActivity_Adapter(context, Class_ModelDB.getOrderList()));
                }
                else {
                    fb_addorder.setVisibility(View.GONE);

                    Class_Static.tempOrder=new ArrayList<Order>();
                    for (Order temporder:LocalOrder) {
                        Boolean matched=false;
                        if(temporder.getOrderNumber().toLowerCase().contains(s.toString().toLowerCase()))
                            matched=true;
                        if(temporder.getClient().getName().toLowerCase().contains(s.toString().toLowerCase()))
                            matched=true;
                        if(temporder.getUser().getName().toLowerCase().contains(s.toString().toLowerCase()))
                            matched=true;
                        if (temporder.getStatus().toLowerCase().contains(s.toString().toLowerCase()))
                            matched=true;
                        if(matched)
                            Class_Static.tempOrder.add(temporder);
                    }
                    orderRecyclerView.setAdapter(new OrderActivity_Adapter(context,Class_Static.tempOrder));

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void InitializeAdapter(Context context) {
        LocalOrder= (ArrayList<Order>) Class_ModelDB.getOrderList().clone();
        if(Class_ModelDB.getOrderList().size()!=0){
            orderRecyclerView.setAdapter(new OrderActivity_Adapter(context, Class_ModelDB.getOrderList()));
        }else {


        }


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (item.getItemId() == android.R.id.home) {
           // DashBoardActivity.navigationView.getMenu().getItem(0).setChecked(true);
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

