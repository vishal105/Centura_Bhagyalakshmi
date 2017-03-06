package materialtest.example.centura.centura_bhagyalakshmi.order.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.models.distributor;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_ModelDB;

/**
 * Created by VISHAL on 2/27/2017.
 */

public class Distributor_Adapter extends RecyclerView.Adapter<Distributor_Adapter.ViewHolder> {
    public static ArrayList <distributor> data;
    Context mcontext;

    public Distributor_Adapter(Context context, ArrayList<distributor> distributormodel) {
        this.mcontext = context;
        this.data = distributormodel;
    }

    @Override
    public Distributor_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.distributor_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Distributor_Adapter.ViewHolder holder, int position) {
        holder.tv_distributor_list.setText(data.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_distributor_list;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_distributor_list = (TextView) itemView.findViewById(R.id.tv_distributor_item);

        }
    }
}
