package com.example.appniceface.ui.meus_dados;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.appniceface.ActivityTelaMenu;
import com.example.appniceface.ClienteDAO;
import com.example.appniceface.ClienteDTO;
import com.example.appniceface.R;

import java.util.ArrayList;

public class Meus_DadosFragment extends Fragment {
Button butttonVoltarMeusDados;
ListView listViewMeusDados;
ArrayList<ClienteDTO> arryListCliente;
ClienteDTO cliente;


    private Meus_DadosViewModel meus_dadosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        meus_dadosViewModel =
                new ViewModelProvider(this).get(Meus_DadosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_meus_dados, container, false);
        final TextView textView = root.findViewById(R.id.text_meus_dados);
        butttonVoltarMeusDados = root.findViewById(R.id.buttonVoltarMeusDados);
        listViewMeusDados = root.findViewById(R.id.listViewMeusDados);

        butttonVoltarMeusDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityTelaMenu.class);
                startActivity(intent);
            }
        });


        ClienteDAO clienteDAO = new ClienteDAO(getActivity().getApplicationContext());
        arryListCliente = clienteDAO.meusDados();
        //cliente = clienteDAO.dadosCliente();

        ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(),
        android.R.layout.simple_list_item_1,arryListCliente);
                //android.R.layout.simple_list_item_1,cliente);
        listViewMeusDados.setAdapter(adapter);

        meus_dadosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}