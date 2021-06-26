package com.example.flickerapp.Repositry;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.flickerapp.Utilities.LoggerHelper;

public class APICall {

    AppCompatActivity context;
    String movieToSearch;

    public APICall(AppCompatActivity context,String movieToSearch) {
        this.context = context;
        sendAndRequestResponse();
        this.movieToSearch=movieToSearch;
    }

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ddda26fe9ae99aaa7278a1d50253f479&format=json&nojsoncallback=1&text=" +
            movieToSearch +"&page=1&per_page=10";



    private void sendAndRequestResponse() {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(context);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                LoggerHelper.loggerHelper.printLog(this.getClass(), "Response= " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                LoggerHelper.loggerHelper.printLog(this.getClass(), "Error= " + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }




}
