package materialtest.example.centura.centura_bhagyalakshmi.order.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.models.distributor;

/**
 * Created by VISHAL on 2/27/2017.
 */

public class Distributor_Adapter extends RecyclerView.Adapter<Distributor_Adapter.ViewHolder> {
    ArrayList<Order> data;

    public Distributor_Adapter(ArrayList<Order> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.distributor_adapter_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(data.get(position).getClient().getName().toString());
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }

        });
    }


    @Override
    public int getItemCount() { return data.size();  }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text1);
        }
    }
}
