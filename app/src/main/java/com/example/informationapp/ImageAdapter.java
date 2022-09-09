package com.example.informationapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private ArrayList<InfoViewModel> imageList;
    private ArrayList<String> imagesLink=new ArrayList<>();
    Context context;

    public ImageAdapter(ArrayList<InfoViewModel> imageList, Context context) {
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
                .load(imgURL(infoViewModel))
                .into(holder.imageView);
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

    public String imgURL(InfoViewModel infoViewModel){
        String temp="https://farm"+infoViewModel.getFarmId()+".staticflickr.com/"+infoViewModel.serverId+"/"+infoViewModel.id+"_"+infoViewModel.secret+".jpg";
        imagesLink.add(temp);
        return temp;
    }
}
