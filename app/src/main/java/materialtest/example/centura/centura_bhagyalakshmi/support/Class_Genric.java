package materialtest.example.centura.centura_bhagyalakshmi.support;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.toolbox.StringRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.models.KeyValuePair;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;

/**
 * Created by Basavaraju on 2/22/2017.
 */

public class Class_Genric {
    public static boolean progressAlive = false;
    static ProgressDialog pDialog;

    public static String generateUrl(String Url, ArrayList<KeyValuePair> params) {
        if (params.size() > 0) {
            Url += "&";
            for (KeyValuePair data : params) {
                if (data.getKey().trim().length() > 0)
                    Url += data.getKey() + "=" + data.getValue() + "&&";
            }
            Url = Url.substring(0, Url.length() - 2);
        }
        return Url;
    }


    public static String getDateTime(Order order) {
        order.getOrderDate();
        if (order.getOrderNumber().toLowerCase().contains(("Offline").toLowerCase())) {
            return order.getOrderDate();
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            return sdf.format(new java.util.Date(Long.parseLong((order.getOrderDate())) * 1000));
        }


    }


    public static void ShowDialog(Context context, String message, Boolean flag) {
        if (flag) {
            if (progressAlive) {
                try {
                    pDialog.cancel();
                } catch (Exception e) {
                }
                progressAlive = false;
            }
            {
               /* pDialog=new Dialog(context);
                pDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                pDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                pDialog.setContentView(R.layout.customload);*/

                pDialog = new ProgressDialog(context);
                pDialog.setMessage(message);
                if (message.contains("Loading"))
                    pDialog.setCanceledOnTouchOutside(false);
                progressAlive = true;
                pDialog.show();
            }
        } else {
            if (progressAlive) {
                pDialog.dismiss();
                pDialog.cancel();
                progressAlive = false;
            }
        }
    }
}
