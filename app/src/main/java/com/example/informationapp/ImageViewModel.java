package com.example.informationapp;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ImageViewModel extends ViewModel {

    MutableLiveData<List<String>> imageUrl;
}
