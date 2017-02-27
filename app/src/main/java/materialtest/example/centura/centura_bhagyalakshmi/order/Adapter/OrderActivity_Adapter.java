package materialtest.example.centura.centura_bhagyalakshmi.order.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.models.OrderObject;


public class OrderActivity_Adapter  extends RecyclerView.Adapter<OrderActivity_Adapter.ViewHolder> {
    private ArrayList<OrderObject>mdataset;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_order_id,tv_order_name,tv_order_status;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_order_id= (TextView) itemView.findViewById(R.id.tv_order_id);
            tv_order_name= (TextView) itemView.findViewById(R.id.tv_order_name);
            tv_order_status= (TextView) itemView.findViewById(R.id.tv_order_status);
        }
    }
   /* public void add(int position, String item){
        mdataset.add(position,item);
        notifyItemInserted(position);
    }
    public void remove(String item){

        int position = mdataset.indexOf(item);
        mdataset.remove(position);
        notifyItemRemoved(position);
    }
*/
    public OrderActivity_Adapter(ArrayList<OrderObject> mydataset){
        mdataset = mydataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       holder.tv_order_id.setText(mdataset.get(position).getId());
        holder.tv_order_name.setText(mdataset.get(position).getOrderNumber());
        holder.tv_order_status.setText(mdataset.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return mdataset.size();
    }
}


