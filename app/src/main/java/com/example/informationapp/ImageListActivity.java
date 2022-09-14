package com.example.informationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class ImageListActivity extends AppCompatActivity {

    int isGrid=0;
    ImageAdapter imageAdapter;
    RecyclerView imageRV;
    String imgArray;
    Intent intent;
    ImageButton gridBtn;
    ArrayList<InfoViewModel> listdata = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

//        ArrayList<InfoViewModel> imageLink = (ArrayList<InfoViewModel>) intent.getSerializableExtra("imageLink");
        imageRV=(RecyclerView) findViewById(R.id.imageRV);
        intent=getIntent();
        listdata = (ArrayList<InfoViewModel>) intent.getSerializableExtra("imageLink");

        gridBtn=(ImageButton) findViewById(R.id.gridBtn);

//        (ArrayList<InfoViewModel>)getIntent().getSerializableExtra("lists");
        Log.d("img", String.valueOf(listdata));


//        JSONArray jsonArray = null;
//        try {
//            jsonArray = new JSONArray(imgArray);
//            String[] strArr = new String[jsonArray.length()];
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                strArr[i] = jsonArray.getString(i);
////                strArr[i]
//                Log.d("bbb",strArr[i]);
//                JSONObject jsonObject=new JSONObject(jsonArray.toString());
//                listdata.add(jsonArray.getString(i));
//                Log.d("que", "onCreate: ");
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


//        listdata = imgArray.replace("\"", "");
//
        imageAdapter = new ImageAdapter(listdata, getApplication());
        imageRV.setAdapter(imageAdapter);
        imageRV.setLayoutManager(
                new LinearLayoutManager(ImageListActivity.this));

        gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isGrid==0) {
                    isGrid = 1;
                    imageRV.setLayoutManager(new GridLayoutManager(ImageListActivity.this, 2));
                }
                else{
                    imageRV.setLayoutManager(new LinearLayoutManager(ImageListActivity.this));
                    isGrid=0;
                }
                }
        });
    }
}