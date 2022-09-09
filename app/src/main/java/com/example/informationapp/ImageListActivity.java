package com.example.informationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ImageListActivity extends AppCompatActivity {

    ImageAdapter imageAdapter;
    RecyclerView imageRV;
    String imgArray;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

//        ArrayList<InfoViewModel> imageLink = (ArrayList<InfoViewModel>) intent.getSerializableExtra("imageLink");
        imageRV=(RecyclerView) findViewById(R.id.imageRV);
        intent=getIntent();
        imgArray = intent.getStringExtra("imageLink");

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(imgArray);
            String[] strArr = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {
                strArr[i] = jsonArray.getString(i);
//                strArr[i]
//                Log.d("bbb",strArr[i]);
//                JSONObject jsonObject=new JSONObject(jsonArray);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        Log.d("aaa",intent.getStringExtra("imageLink"));



        imageAdapter = new ImageAdapter(imageLink, getApplication());
        imageRV.setAdapter(imageAdapter);
        imageRV.setLayoutManager(
                new LinearLayoutManager(ImageListActivity.this));
    }
}