package materialtest.example.centura.centura_bhagyalakshmi.order.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.models.OrderObject;
import materialtest.example.centura.centura_bhagyalakshmi.order.controller.OrderActivity;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_ModelDB;


public class OrderActivity_Adapter  extends RecyclerView.Adapter<OrderActivity_Adapter.ViewHolder> {

    private static String LOG_TAG ="OrderActivity_Adapter";
    public static ArrayList<Order> mdataset;
   /* private static MyClickListener myClickListener;*/
    Context mcontext;
    ArrayList<Order> data;

    public OrderActivity_Adapter(Context context) {
        this.mcontext = context;
        mdataset  = Class_ModelDB.getOrderList();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_order_id,tv_order_name,tv_order_status;



        public ViewHolder(View itemView) {
            super(itemView);
            tv_order_id= (TextView) itemView.findViewById(R.id.tv_order_id);
            tv_order_name= (TextView) itemView.findViewById(R.id.tv_order_name);
            tv_order_status= (TextView) itemView.findViewById(R.id.tv_order_status);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
          /*OrderActivity.click();
            Toast.makeText(view.getContext(), "on Click Successful", Toast.LENGTH_SHORT).show();
*/


        }
    }

    @Override
    public OrderActivity_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_order_id.setText(mdataset.get(position).getOrderNumber());
        holder.tv_order_name.setText(mdataset.get(position).getClient().getName());
        holder.tv_order_status.setText(mdataset.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return mdataset.size();
    }
    }


