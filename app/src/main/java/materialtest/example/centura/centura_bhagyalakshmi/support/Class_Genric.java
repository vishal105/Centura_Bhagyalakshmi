package materialtest.example.centura.centura_bhagyalakshmi.support;

import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

import materialtest.example.centura.centura_bhagyalakshmi.models.KeyValuePair;

/**
 * Created by Basavaraju on 2/22/2017.
 */

public class Class_Genric {

    public static String generateUrl(String Url, ArrayList<KeyValuePair> params) {
        if (params.size() > 0) {
            Url += "?";
            for (KeyValuePair data : params) {
                if (data.getKey().trim().length() > 0)
                    Url += data.getKey() + "=" + data.getValue() + "&&";
            }
            Url = Url.substring(0, Url.length() - 2);
        }
        return Url;
    }


}
