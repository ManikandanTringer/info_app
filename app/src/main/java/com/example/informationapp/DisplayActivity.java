package com.example.informationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DisplayActivity extends AppCompatActivity {
    private static final String TAG = "DisplayActivity";
    ImageView display_img;
    TextView usernameTV,locationTV,viewsTV,titleTV,descTV;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        display_img=(ImageView) findViewById(R.id.display_img);
        usernameTV=(TextView) findViewById(R.id.usernameTV);
        locationTV=(TextView) findViewById(R.id.locationTV);
        viewsTV=(TextView) findViewById(R.id.viewsTV);
        titleTV=(TextView) findViewById(R.id.titleTV);
        descTV=(TextView) findViewById(R.id.descTV);

        Intent intent=getIntent();
        String imagelink =intent.getStringExtra("link");
//        Log.d(TAG, "onCreate: "+imagelink);
        String secret=intent.getStringExtra("secret");
        String id=intent.getStringExtra("id");

        String imgDes="https://www.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=6875a6037041f0fe5c4e5781f5c08b7e&photo_id="+id+"&secret="+secret+"&format=json";

        Log.d(TAG, "onCreate: "+id+"  "+secret);

        Glide.with(display_img.getContext())
                .load(imagelink)
                .into(display_img);

        getViewModel(id,secret);
    }
    public void getViewModel(String id,String secret){
        ImageViewModel imageViewModel=new ViewModelProvider(this).get(ImageViewModel.class);
        imageViewModel.setKey(id,secret,DisplayActivity.this);
        imageViewModel.getLiveData().observe(this, new Observer<ImageModel>() {
            @Override
            public void onChanged(ImageModel imageModel) {
                Log.d("some",imageModel.toString());
//                text.setText(imageModel.getUsername());
                usernameTV.setText(imageModel.getUsername());
                locationTV.setText(imageModel.getLocation());
                viewsTV.setText(imageModel.getViews());
                descTV.setText(imageModel.getDesc());
                titleTV.setText(imageModel.getTitle());
            }
        });
    }
}