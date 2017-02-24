package materialtest.example.centura.centura_bhagyalakshmi.order.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.models.OrderObject;

/**
 * Created by Basavaraju on 2/23/2017.
 */

public class OrderActivity_Adapter extends RecyclerView.Adapter<OrderActivity_Adapter.ViewHolder>{
    Context mcontext;
    ArrayList<Order> data;
    

    public OrderActivity_Adapter(Context context, ArrayList<Order> orderList) {

        this.data = orderList;
    }

    public OrderActivity_Adapter(ArrayList<OrderObject> dataSet) {
    }


    @Override
    public OrderActivity_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(OrderActivity_Adapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
