package com.example.appniceface.ui.contato;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
import com.example.appniceface.ui.contato.ContatoViewModel;

public class ContatoFragment extends Fragment {

    Button buttonEnviarContato;

    private ContatoViewModel contatoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contatoViewModel =
                new ViewModelProvider(this).get(ContatoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contato, container, false);
        final TextView textView = root.findViewById(R.id.text_contato);
        buttonEnviarContato = root.findViewById(R.id.buttonEnviarContato);

        buttonEnviarContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityTelaMenu.class);
                startActivity(intent);
            }
        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        contatoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

//        public boolean onOptionsItemSelected(MenuItem menuItem){
//
//            switch (menuItem.getItemId()){
//                case android.R.id.home:
//                    finish();
//                    return true;
//            }
//            return super.onOptionsItemSelected(menuItem);
//        }
//
//        public boolean onCreateOptionsMenu(Menu menu){
//            return true;
//        }

        return root;
    }
}