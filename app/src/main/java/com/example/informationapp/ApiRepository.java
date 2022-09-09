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
import java.util.List;

public class ApiRepository {
    String apiKey, keyword;
    String baseURL = "https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=6875a6037041f0fe5c4e5781f5c08b7e&text=cat&format=json&nojsoncallback=1";

    Context contexto;
    RequestQueue queue;
    ArrayList<InfoViewModel> photoInfo=new ArrayList<>();
    InfoViewModel infoViewModel;


    public ApiRepository(Context context){
            contexto=context;
        queue= Volley.newRequestQueue(contexto);

    }

    private static final String TAG = "ApiRepository";


    public List<InfoViewModel> callApi(String baseUrl) {
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, baseURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display respons

                        try{
                            JSONObject jsonObject=response.getJSONObject("photos");
                            JSONArray jsonArray=jsonObject.getJSONArray("photo");
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject object=jsonArray.getJSONObject(i);
//                                Log.d("res",object.toString());
                                infoViewModel=new InfoViewModel(object.getString("farm"),object.getString("server"),object.getString("id"),object.getString("secret"));
                                photoInfo.add(infoViewModel);
                            }

                        }catch (Exception e){

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

        return photoInfo;
    }

}
