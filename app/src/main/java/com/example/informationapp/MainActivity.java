package com.example.informationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.informationapp.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String baseUrl;//="https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=6875a6037041f0fe5c4e5781f5c08b7e&text=dogs&format=json";
    ApiRepository apiRepository;
    List<InfoViewModel> imageLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiRepository=new ApiRepository(MainActivity.this);
        baseUrl="https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key="+binding.apiKeyET.getText().toString()+"&text="+binding.keywordET.getText().toString()+"&format=json";
        binding.getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    imageLink=new ArrayList<>();
               imageLink= apiRepository.callApi(baseUrl);
                Log.d("aa", "onClick: "+imageLink.toString());
                Intent intent=new Intent(MainActivity.this,ImageListActivity.class);
                intent.putExtra("imageLink", imageLink.toString());
                startActivity(intent);
            }
        });



    }
}