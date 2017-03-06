package materialtest.example.centura.centura_bhagyalakshmi.order.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.models.distributor;
import materialtest.example.centura.centura_bhagyalakshmi.order.Adapter.Distributor_Adapter;
import materialtest.example.centura.centura_bhagyalakshmi.order.Adapter.OrderActivity_Adapter;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_ModelDB;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Static;

import static materialtest.example.centura.centura_bhagyalakshmi.order.controller.OrderActivity.LocalOrder;

public class DistrubutorSearchActivity extends AppCompatActivity {
    public static RecyclerView distributor_list;
    Distributor_Adapter madapter;
    private RecyclerView.LayoutManager mlayoutmanager;
    public EditText ordersearch1;
    public static ArrayList<distributor> Localdistributor = new ArrayList<distributor>();


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
        madapter = new Distributor_Adapter(this, Class_ModelDB.getDistributormodel());
        distributor_list.setAdapter(madapter);
        ordersearch1 = (EditText) findViewById(R.id.order_search1);
        InitializeAdapter(DistrubutorSearchActivity.this);

        distributor_list.addOnItemTouchListener(new RecyclerItemClickListener(this, distributor_list, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(DistrubutorSearchActivity.this,AddOrderActivity.class));
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        Functionality(DistrubutorSearchActivity.this);


    }

    private void InitializeAdapter(Context context) {
        Localdistributor = (ArrayList<distributor>) Class_ModelDB.getDistributormodel().clone();
        if(Class_ModelDB.getDistributormodel().size()!=0){
            distributor_list.setAdapter(new Distributor_Adapter(context, Class_ModelDB.getDistributormodel()));
        }else {


        }
    }

    private void Functionality(final Context context) {
        ordersearch1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().matches("")){
                    distributor_list.setAdapter(new Distributor_Adapter(context, Class_ModelDB.getDistributormodel()));
                }
                else {

                    Class_Static.tempdistributor=new ArrayList<distributor>();
                    for (distributor tempdistributor:Localdistributor) {
                        Boolean matched=false;
                        if(tempdistributor.getName().toLowerCase().contains(s.toString().toLowerCase()))
                            matched=true;
                       /* if(temporder.getClient().getName().toLowerCase().contains(s.toString().toLowerCase()))
                            matched=true;
                       *//* if(temporder.getUser().getName().toLowerCase().contains(s.toString().toLowerCase()))
                            matched=true;*//*
                        if (temporder.getStatus().toLowerCase().contains(s.toString().toLowerCase()))
                            matched=true;*/
                        if(matched)
                            Class_Static.tempdistributor.add(tempdistributor);
                    }
                    distributor_list.setAdapter(new Distributor_Adapter(context,Class_Static.tempdistributor));

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

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
