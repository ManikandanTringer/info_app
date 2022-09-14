package com.example.informationapp;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

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

    String baseURL = "https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=6875a6037041f0fe5c4e5781f5c08b7e&text=cat&format=json&nojsoncallback=1";
    JSONArray jsonArray;
    ImageModel imageModel;
    Context contexto;
    RequestQueue queue;
    ArrayList<InfoViewModel> photoInfo=new ArrayList<>();
    InfoViewModel infoViewModel;
    private static final String TAG = "api";

    public ApiRepository(Context context){
            contexto=context;
        queue= Volley.newRequestQueue(contexto);

    }

    public List<InfoViewModel> callApi(String baseUrl) {



            JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, baseURL, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // display respons
//                        JSONArray jsonArray ;
                            try {
                                JSONObject jsonObject = response.getJSONObject("photos");
                                jsonArray = jsonObject.getJSONArray("photo");
                                Log.d(TAG, "onResponse: " + jsonArray.toString());
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject object=jsonArray.getJSONObject(i);
                                Log.d("res",object.getString("farm"));
                                infoViewModel=new InfoViewModel(object.getString("farm"),object.getString("server"),object.getString("id"),object.getString("secret"));
                                photoInfo.add(infoViewModel);
                                Log.d(TAG, "onResponse: "+photoInfo.getClass().getSimpleName());
                            }

                            } catch (Exception e) {

                            }

                        }

                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error.Response", error.toString());
                        }
                    }
            );

            queue.add(getRequest);


        return photoInfo;

    }
    public MutableLiveData<ImageModel> callDetailApi(String id, String secret){
Log.d("id",id);
MutableLiveData<ImageModel> data=new MutableLiveData<>();
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET,
                "https://www.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=6875a6037041f0fe5c4e5781f5c08b7e&photo_id="+id+"&secret="+secret+"&format=json&nojsoncallback=1", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("res",response.toString());
                        try {
                            JSONObject jsonObject = response.getJSONObject("photo");
                            JSONObject object=jsonObject.getJSONObject("owner");
                            String username=object.getString("username");
                            String location=object.getString("location");
                            String views=jsonObject.getString("views");
                            JSONObject object1=jsonObject.getJSONObject("title");
                            String title=object1.getString("_content");
                            JSONObject object2=jsonObject.getJSONObject("description");
                            String desc=object2.getString("_content");
                            Log.d("user",jsonObject.toString());
                            imageModel=new ImageModel(username,location,title,views,desc);
                            data.postValue(imageModel);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("err",error.toString());
                    }
                });
        queue.add(request);
        return data;
    }

}
