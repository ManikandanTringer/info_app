package com.example.informationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.informationapp.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String baseUrl;//="https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=6875a6037041f0fe5c4e5781f5c08b7e&text=dogs&format=json";
    ApiRepository apiRepository;
    List<InfoViewModel> imageLink;
    InfoViewModel infoViewModel;
    ArrayList<InfoViewModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiRepository=new ApiRepository(MainActivity.this);
//        infoViewModel=new InfoViewModel();
        baseUrl="https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key="+"6875a6037041f0fe5c4e5781f5c08b7e"+"&text="+binding.keywordET.getText().toString()+"&format=json";
        binding.getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               imageLink= apiRepository.callApi(baseUrl);
//                Log.d("cc",String.valueOf(imageLink));
//                for(int i=0;i<imageLink.length();i++){
//                    try {
//                        JSONObject object=imageLink.getJSONObject(i);
//                        infoViewModel=new InfoViewModel(object.getString("farm"),object.getString("server"),
//                                object.getString("id"),object.getString("secret"));
//                        arrayList.add(infoViewModel);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//                for(int i=0;i<imageLink.size();i++){
//                    Log.d("qwe", "onClick: "+ imageLink.get(i).getFarmId());
//
//                }

//                Log.d(TAG, "onClick: ");
                Intent intent=new Intent(MainActivity.this,ImageListActivity.class);
                intent.putExtra("imageLink", (Serializable) imageLink);


                startActivity(intent);
            }
        });



    }
}