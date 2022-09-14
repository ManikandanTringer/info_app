package com.example.informationapp;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private ArrayList<InfoViewModel> imageList;
//    private ArrayList<String> imagesLink=new ArrayList<>();
    Context context;

    public ImageAdapter(ArrayList imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

        View photoView
                = inflater
                .inflate(R.layout.image_item,
                        parent, false);

        ImageViewHolder viewHolder
                = new ImageViewHolder(photoView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

InfoViewModel infoViewModel=imageList.get(position);


                Glide.with(holder.imageView.getContext())
                        .load(imgURL(infoViewModel.getFarmId(),
                                infoViewModel.getServerId(),
                               infoViewModel.getId(),
                                infoViewModel.getSecret()))
                        .into(holder.imageView);


//                strArr[i]
//                    Log.d("bbb",strArr[i]);
//                    JSONObject jsonObject=new JSONObject(jsonArray.toString());
//                    Log.d("que", "onCreate: ");


        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ImageAdapter.this.context,DisplayActivity.class);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("link",imgURL(infoViewModel.getFarmId(),
                        infoViewModel.getServerId(),
                        infoViewModel.getId(),
                        infoViewModel.getSecret()));
                intent.putExtra("secret",infoViewModel.getSecret());
                intent.putExtra("id",infoViewModel.getId());
                ImageAdapter.this.context.startActivity(intent);
            }
        });

    }

        @Override
    public int getItemCount() {
        return imageList.size() ;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.imgView);


        }
    }

    public String imgURL(String farmId,String serverId,String id,String secret){
        String temp="https://farm"+farmId+".staticflickr.com/"+serverId+"/"+id+"_"+secret+".jpg";
        return temp;
    }
}
