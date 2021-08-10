package com.example.appniceface.ui.minhas_sessoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.appniceface.ActivityTelaMenu;
import com.example.appniceface.R;


public class Minhas_SessoesFragment extends Fragment {
Button buttonVoltarSessoes;

    private Minhas_SessoesViewModel minhas_sessoesViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        minhas_sessoesViewModel =
                new ViewModelProvider(this).get(Minhas_SessoesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_minhas_sessoes, container, false);
        final TextView textView = root.findViewById(R.id.text_minhas_sessoes);
        buttonVoltarSessoes = root.findViewById(R.id.buttonVoltarSessoes);

        buttonVoltarSessoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityTelaMenu.class);
                startActivity(intent);
            }
        });
        minhas_sessoesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}