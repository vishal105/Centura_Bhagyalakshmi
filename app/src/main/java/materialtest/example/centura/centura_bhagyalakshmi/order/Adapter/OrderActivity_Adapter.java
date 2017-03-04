package materialtest.example.centura.centura_bhagyalakshmi.order.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.models.Product;
import materialtest.example.centura.centura_bhagyalakshmi.order.controller.Select_order_activity;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_ModelDB;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Static;


public class OrderActivity_Adapter extends RecyclerView.Adapter<OrderActivity_Adapter.ViewHolder> {

    private static String LOG_TAG = "OrderActivity_Adapter";
    public static ArrayList<Order> mdataset;
    /* private static MyClickListener myClickListener;*/
    Context mcontext;
    ArrayList<Order> data;

    public OrderActivity_Adapter(Context context, ArrayList<Order> model) {
        this.mcontext = context;
        mdataset = model;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_order_id, tv_order_name, tv_order_status;
        TextView orderId, clientName, clientAddress, userName, userType;
        LinearLayout adminOrderPane;


        public ViewHolder(View itemView) {
            super(itemView);
            tv_order_id = (TextView) itemView.findViewById(R.id.tv_order_id);
            tv_order_name = (TextView) itemView.findViewById(R.id.tv_order_name);
            tv_order_status = (TextView) itemView.findViewById(R.id.tv_order_status);

            adminOrderPane = (LinearLayout) itemView.findViewById(R.id.admin_order_pane);


        }


    }


    @Override
    public OrderActivity_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tv_order_id.setText(mdataset.get(position).getOrderNumber());
        holder.tv_order_name.setText(mdataset.get(position).getClient().getName());
        holder.tv_order_status.setText(mdataset.get(position).getStatus());
        holder.adminOrderPane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class_Static.OrdredProducts = new Order();
                Class_Static.tempOrderingProduct = new ArrayList<>();
                Class_Static.OrdredProducts=mdataset.get(position);
                for(int i=0;i<Class_Static.OrdredProducts.getProducts().size();i++){
                    Product prod=new Product();
                    prod.setQuantity(new Double(Class_Static.OrdredProducts.getProducts().get(i).getQuantity()).intValue());
                    prod.setPrice(Class_Static.OrdredProducts.getProducts().get(i).getPrice());
                    prod.setAmount(prod.getQuantity()*prod.getPrice());
                    prod.setDescription(Class_Static.OrdredProducts.getProducts().get(i).getDescription());
                    prod.setUnits(Class_Static.OrdredProducts.getProducts().get(i).getUnit());
                    Class_Static.tempOrderingProduct.add(prod);
                }
                mcontext.startActivity(new Intent(mcontext, Select_order_activity.class));

            }
        });


    }

    @Override
    public int getItemCount() {
        return mdataset.size();
    }
}



