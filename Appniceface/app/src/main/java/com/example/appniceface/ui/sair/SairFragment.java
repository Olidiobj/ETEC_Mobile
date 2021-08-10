package com.example.appniceface.ui.sair;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.appniceface.ActivityTelaLogin;
import com.example.appniceface.R;

public class SairFragment extends Fragment {

    private SairViewModel sairViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sairViewModel =
                new ViewModelProvider(this).get(SairViewModel.class);
        View root = inflater.inflate(R.layout.activity_login, container, false);
        final TextView textView = root.findViewById(R.id.text_Sair);
        sairViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Intent intent = new Intent(getActivity(), ActivityTelaLogin.class);
                startActivity(intent);
            }
        });
        return root;

    }
}

