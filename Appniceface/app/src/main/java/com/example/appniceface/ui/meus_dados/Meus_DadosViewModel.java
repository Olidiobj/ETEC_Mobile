package com.example.appniceface.ui.meus_dados;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Meus_DadosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Meus_DadosViewModel() {
        mText = new MutableLiveData<>();
  //      mText.setValue("This is gallery fragment");
       mText.setValue("MEUS DADOS");
    }

    public LiveData<String> getText() {
        return mText;
    }
}