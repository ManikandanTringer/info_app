package com.example.informationapp;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.LiveData;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ImageViewModel extends ViewModel {

    MutableLiveData<ImageModel> liveData;
    public ImageViewModel(){
    liveData=new MutableLiveData<>();
    }
    public void setKey(String id,String secret,Context context){
        ApiRepository apiRepository=new ApiRepository(context);
      liveData= apiRepository.callDetailApi(id,secret);
        Log.d("live",liveData.toString());
    }
    public LiveData<ImageModel> getLiveData(){
        return liveData;
    }

}
