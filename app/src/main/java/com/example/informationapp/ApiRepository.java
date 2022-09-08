package com.example.informationapp;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ApiRepository {
    String baseURL = "https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=6875a6037041f0fe5c4e5781f5c08b7e&text=cat&format=json&nojsoncallback=1";
    String apiKey, keyword;
    Context contexto;
    RequestQueue queue;
    ArrayList<InfoViewModel> photoInfo=new ArrayList<>();


    public ApiRepository(Context context){
            contexto=context;
        queue= Volley.newRequestQueue(contexto);

    }

    private static final String TAG = "ApiRepository";


    public void callApi(String baseUrl) {
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, baseURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        try {
                            Log.d(TAG, response.getString("photos"));
                            Log.d(TAG, response.optJSONArray("photo").getJSONArray(0).toString());;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {

                            JSONArray jsonArray = response.getJSONArray("photos");
//                            JSONArray photos=jsonArray.getJSONArray(0);
                            Log.d(TAG, String.valueOf(jsonArray));
                            for(int i=0;i<jsonArray.length();i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                                Log.d(TAG, "onResponse: "+jsonObject.getString("photo"));
                            }
//                                Log.d(TAG, "onResponse: array" + jsonArray);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        Log.d("Error.Response", error.toString());
                    }
                }
        );

        queue.add(getRequest);
    }
}
