package materialtest.example.centura.centura_bhagyalakshmi.support;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import materialtest.example.centura.centura_bhagyalakshmi.changepassword.ChangePasswordActivity;
import materialtest.example.centura.centura_bhagyalakshmi.dashboard.DashBoardActivity;
import materialtest.example.centura.centura_bhagyalakshmi.login.LoginActivity;
import materialtest.example.centura.centura_bhagyalakshmi.models.CurrentUser;
import materialtest.example.centura.centura_bhagyalakshmi.models.KeyValuePair;
import materialtest.example.centura.centura_bhagyalakshmi.models.Order;
import materialtest.example.centura.centura_bhagyalakshmi.models.Product;
import materialtest.example.centura.centura_bhagyalakshmi.models.distributor;
import materialtest.example.centura.centura_bhagyalakshmi.order.controller.AddOrderActivity;
import materialtest.example.centura.centura_bhagyalakshmi.order.controller.DistrubutorSearchActivity;
import materialtest.example.centura.centura_bhagyalakshmi.order.controller.OrderActivity;

import static materialtest.example.centura.centura_bhagyalakshmi.login.LoginActivity.MyPref;
import static materialtest.example.centura.centura_bhagyalakshmi.login.LoginActivity.Sp_Status;
import static materialtest.example.centura.centura_bhagyalakshmi.login.LoginActivity.Sp_User;
import static materialtest.example.centura.centura_bhagyalakshmi.login.LoginActivity.Sp_Token;

/**
 * Created by VISHAL on 2/27/2017.
 */

public class Sync_api {
    static SharedPreferences sharedPreferences;
    static int mStatusCode = 0;
    static Gson gson;

    public static void loginapi(final Context context, final EditText username, final EditText password) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        ArrayList<KeyValuePair> params = new ArrayList<KeyValuePair>();
        params.add(new KeyValuePair("username", username.getText().toString().trim()));
        params.add(new KeyValuePair("password", password.getText().toString().trim()));
        //String LOGIN_URL = URL + "Login/" + "?UserName=" + username + "&&Password=" + password;
        Class_Genric.ShowDialog(context,"Loading...",true);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Class_Genric.generateUrl(Class_Urls.Login, params),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Class_Genric.ShowDialog(context,"Loading...",false);
                        sharedPreferences = context.getSharedPreferences(MyPref, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        switch (mStatusCode) {
                            case 200:
                                try {
                                    gson = new Gson();
                                    JSONObject jsonObject = new JSONObject(response);
                                    Class_ModelDB.setCurrentuserModel(gson.fromJson(response.toString(), CurrentUser.class));
                                    context.startActivity(new Intent(context, DashBoardActivity.class));
                                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show();
                                    editor.putString(Sp_Status, "LoggedIn");
                                    editor.putString(Sp_User, jsonObject.optString("Name").toString());
                                    editor.apply();
                                    editor.commit();

                                    ((Activity) context).finish();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                        }
                    }

                }

                , new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {
                Class_Genric.ShowDialog(context,"Loading...",false);
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    if (error != null && error.networkResponse != null) {
                        mStatusCode = error.networkResponse.statusCode;
                        switch (mStatusCode) {
                            case 400:
                                username.setError("Username or Password Invalid");
                                break;
                            case 401:
                                password.setError("Password Invalid");
                                break;
                        }
                    } else
                        Toast.makeText(context, "Server Down", Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                mStatusCode = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };
        stringRequest.setRetryPolicy(new

                DefaultRetryPolicy(3000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)

        );

        requestQueue.add(stringRequest);


    }


    public static void changepasswordApi(final Context context, EditText oldPassword, EditText newPassword) {

        RequestQueue queue = Volley.newRequestQueue(context);
        ArrayList<KeyValuePair> params = new ArrayList<KeyValuePair>();
        params.add(new KeyValuePair("OldPassword", oldPassword.getText().toString().trim()));
        params.add(new KeyValuePair("NewPassword", newPassword.getText().toString().trim()));

        sharedPreferences = context.getSharedPreferences(MyPref, Context.MODE_PRIVATE);
        Class_Genric.ShowDialog(context,"Loading...",true);
        StringRequest postrequest = new StringRequest(Request.Method.GET, Class_Genric.generateUrl(Class_Urls.ChangePassword, params),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Class_Genric.ShowDialog(context,"Loading...",false);


                        switch (mStatusCode) {
                            case 200:
                                Toast.makeText(context, "Password Updated", Toast.LENGTH_SHORT).show();
                                context.startActivity(new Intent(context, LoginActivity.class));
                                break;
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Class_Genric.ShowDialog(context,"Loading...",false);
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    Toast.makeText(context, "Connection Error, Please check your internet connection", Toast.LENGTH_SHORT).show();

                } else {
                    if (error != null && error.networkResponse != null) {
                        mStatusCode = error.networkResponse.statusCode;
                        switch (mStatusCode) {
                            case 400:
                                Toast.makeText(context, "Invalid Token", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    } else Toast.makeText(context, "Server Down", Toast.LENGTH_SHORT).show();
                }
            }
        }) {
            /*@Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Token",sharedPreferences.getString(LoginActivity.Sp_Token,""));
                return params;
            }*/


            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                mStatusCode = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };

        queue.add(postrequest);


    }


    public static void Orderapi(final Context context) {
        sharedPreferences = context.getSharedPreferences(MyPref, Context.MODE_PRIVATE);
        RequestQueue queue = Volley.newRequestQueue(context);
        ArrayList<KeyValuePair> params = new ArrayList<KeyValuePair>();
        params.add(new KeyValuePair("name", sharedPreferences.getString(LoginActivity.Sp_User,"")));
        Class_Genric.ShowDialog(context, "Loading Orders.", true);
        StringRequest postRequest = new StringRequest(Request.Method.GET, Class_Genric.generateUrl(Class_Urls.Order, params), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    Class_Genric.ShowDialog(context, "Loading...", false);
                    switch (mStatusCode) {
                        case 200:
                            try {
                                gson = new Gson();
                                JSONArray jsonObject = new JSONArray(response);
                                gson = new Gson();
                                ArrayList<Order> orders = new ArrayList<Order>();
                                Type listType = new TypeToken<ArrayList<Order>>() {
                                }.getType();
                                orders = gson.fromJson(jsonObject.toString(), listType);
                                Class_ModelDB.setOrderList(orders);
                                context.startActivity(new Intent(context, OrderActivity.class));
                                //Order.LoadOrders = false;
                                break;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                    }
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Class_Genric.ShowDialog(context,"Loading...",false);
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    Toast.makeText(context, "Connection Error, Please check your internet connection", Toast.LENGTH_SHORT).show();

                } else {
                    if (error != null && error.networkResponse != null) {
                        mStatusCode = error.networkResponse.statusCode;
                        switch (mStatusCode) {
                            case 400:
                                Toast.makeText(context, "Invalid Token", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    } else Toast.makeText(context, "Server Down", Toast.LENGTH_SHORT).show();
                }
            }
        }) {
          /*  @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Token", sharedPreferences.getString(LoginActivity.Sp_Token,""));
                return params;
            }*/

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                mStatusCode = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };
        queue.add(postRequest);
    }

    public static void Distributorapi(final Context context) {

        sharedPreferences = context.getSharedPreferences(MyPref, Context.MODE_PRIVATE);
        RequestQueue queue = Volley.newRequestQueue(context);
        ArrayList<KeyValuePair> params = new ArrayList<KeyValuePair>();
        params.add(new KeyValuePair("name", sharedPreferences.getString(LoginActivity.Sp_User,"")));
        Class_Genric.ShowDialog(context,"Loading",true);
        StringRequest postRequest = new StringRequest(Request.Method.GET, Class_Genric.generateUrl(Class_Urls.distributor, params), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Class_Genric.ShowDialog(context,"Loading...",false);
                if (response != null) {
                    switch (mStatusCode) {
                        case 200:
                            try {
                                gson = new Gson();
                                ArrayList<distributor> distributors = new ArrayList<distributor>();
                                Type listType = new TypeToken<ArrayList<distributor>>() {
                                }.getType();
                                JSONArray jsonObject = new JSONArray(response);
                                distributors = gson.fromJson(jsonObject.toString(), listType);
                                Class_ModelDB.setDistributormodel(distributors);
                                context.startActivity(new Intent(context, DistrubutorSearchActivity.class));
                                //Order.LoadOrders = false;
                                break;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                    }
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Class_Genric.ShowDialog(context,"Loading...",false);
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                    Toast.makeText(context, "Connection Error, Please check your internet connection", Toast.LENGTH_SHORT).show();

                } else {
                    if (error != null && error.networkResponse != null) {
                        mStatusCode = error.networkResponse.statusCode;
                        switch (mStatusCode) {
                            case 400:
                                Toast.makeText(context, "Invalid Token", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    } else Toast.makeText(context, "Server Down", Toast.LENGTH_SHORT).show();
                }
            }
        }) {
           /* @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Token", sharedPreferences.getString(LoginActivity.Sp_Token,""));
                return params;
            }*/

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                mStatusCode = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(500000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);
    }


    public static void ProductApi(final Context context, String id, String name) {
        //GroupsApi(context);
        //CatagoryApi(context);

        /*String s = "2016-12-06T11:29:26";
        if (s.contains("T")) {
            s = s.replace("T", "");
        }*/
        RequestQueue queue = Volley.newRequestQueue(context);
        ArrayList<KeyValuePair> params = new ArrayList<KeyValuePair>();
        params.add(new KeyValuePair("Distributorid", id));
        params.add(new KeyValuePair("Category", name));


        Class_Genric.ShowDialog(context,"Loading...",true);
        StringRequest postRequest = new StringRequest(Request.Method.GET, Class_Genric.generateUrl(Class_Urls.Product1, params), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Class_Genric.ShowDialog(context,"Loading...",false);


                switch (mStatusCode) {
                    case 200:
                        try {
                            gson = new Gson();
                            ArrayList<Product> model = new ArrayList<Product>();
                            Type listType = new TypeToken<ArrayList<Product>>() {
                            }.getType();
                            JSONArray jsonArray = new JSONArray(response);
                            model = gson.fromJson(jsonArray.toString(), listType);
                           /* dbHelper.loadProduct();


                            ArrayList<Product> NewProductsList = new ArrayList<Product>();

                            for (Product newprod : model) {
                                boolean matched = false;
                                for (int i = 0; i < Class_ModelDB.getProductList().size(); i++) {
                                    if (newprod.getId().matches(Class_ModelDB.getProductList().get(i).getId())) {
                                        matched = true;
                                        Class_ModelDB.getProductList().remove(Class_ModelDB.getProductList().get(i));
                                        Class_ModelDB.getProductList().add(i, newprod);
                                        break;
                                    }
                                }
                                if (!matched)
                                    NewProductsList.add(newprod);
                            }
                            ArrayList<Product> FinalProductList = new ArrayList<Product>();
                            FinalProductList = (ArrayList<Product>) Class_ModelDB.getProductList().clone();
                            for (Product newproduct : NewProductsList) {
                                FinalProductList.add(newproduct);
                            }*/
                            //Class_ModelDB.setProductList(model);

                           /* String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                            sharedPreferences = context.getSharedPreferences(MyPref, context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(Class_Genric.Sp_SyncDate, date);
                            editor.commit();*/


                            /*Class_Static.timestamplist = new ArrayList<BigInteger>();
                            for (int j = 0; j < Class_ModelDB.getProductList().size(); j++)
                                Class_Static.timestamplist.add(Class_ModelDB.getProductList().get(j).getTimeStamp());
                            if(Class_Static.timestamplist.size()>0)
                            Class_Genric.setTimeStamp(Class_Genric.Sp_ProductsTS, Collections.max(Class_Static.timestamplist), context);*/

                            ((Activity) context).finish();


                            break;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Class_Genric.ShowDialog(context,"Loading...",false);

                    if (error != null && error.networkResponse != null) {
                        mStatusCode = error.networkResponse.statusCode;
                        switch (mStatusCode) {
                            case 400:
                                Toast.makeText(context, "Invalid Token", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    } else Toast.makeText(context, "Server Down", Toast.LENGTH_SHORT).show();
                }

        }) {
           /* @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Token", Class_ModelDB.getCurrentuserModel().getToken().toString());
                return params;
            }*/

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                mStatusCode = response.statusCode;
                return super.parseNetworkResponse(response);
            }
        };

        queue.add(postRequest);
    }
}




