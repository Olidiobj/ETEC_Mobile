package com.example.appniceface.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("Bem Vindo");
        mText.setValue("APP - desenvolvido por G6 SystemDevelopment - 2020");
    }

    public LiveData<String> getText() {
        return mText;
    }
}