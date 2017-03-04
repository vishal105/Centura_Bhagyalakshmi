package materialtest.example.centura.centura_bhagyalakshmi.order.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.R;
import materialtest.example.centura.centura_bhagyalakshmi.models.OrderProduct;
import materialtest.example.centura.centura_bhagyalakshmi.models.Product;
import materialtest.example.centura.centura_bhagyalakshmi.order.controller.Select_order_activity;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Genric;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_ModelDB;
import materialtest.example.centura.centura_bhagyalakshmi.support.Class_Static;

/**
 * Created by VISHAL on 3/3/2017.
 */

public class Select_Order_Adapter extends RecyclerView.Adapter<Select_Order_Adapter.ViewHolder> {
    Context mContext;
    ArrayList<OrderProduct> data;
    Double amount = 0.0;

    public Select_Order_Adapter(Context context) {
        this.mContext = context;
        data = Class_Static.OrdredProducts.getProducts();
       /* for (Product prod : data) {
            amount += prod.getAmount();
        }*/
        //Select_order_activity.total.setText("Total : " + String.format("%.2f", Class_Static.OrdredProducts.getTotalAmount()) + "");

    }

    @Override
    public Select_Order_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_order_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(Select_Order_Adapter.ViewHolder holder, int position) {
        /*holder.category.setText(data.get(position).getCatagoryName());
        holder.category.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        holder.category.setSelected(true);
        holder.category.setSingleLine(true);*/
        holder.description.setText(data.get(position).getDescription());
        holder.quantity.setText(data.get(position).getQuantity() + "");
        holder.unit.setText(data.get(position).getUnits());
        holder.price.setText(data.get(position).getPrice().toString());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView category, description, quantity, unit, price;
        public ViewHolder(View itemView) {
            super(itemView);
            //category = (TextView) itemView.findViewById(R.id.admin_category);
            description = (TextView) itemView.findViewById(R.id.admin_description);
            quantity = (TextView) itemView.findViewById(R.id.admin_quantity);
            unit = (TextView) itemView.findViewById(R.id.admin_unit);
            price = (TextView) itemView.findViewById(R.id.admin_price);
        }
    }
}
