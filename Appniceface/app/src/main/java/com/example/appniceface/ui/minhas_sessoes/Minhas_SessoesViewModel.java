package com.example.appniceface.ui.minhas_sessoes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Minhas_SessoesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Minhas_SessoesViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("Bem Vindo");
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}