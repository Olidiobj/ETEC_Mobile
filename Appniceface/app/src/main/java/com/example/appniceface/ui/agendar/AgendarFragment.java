package com.example.appniceface.ui.agendar;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.appniceface.ActivityTelaMenu;
import com.example.appniceface.R;
import com.example.appniceface.ui.agendar.AgendarViewModel;
import com.example.appniceface.ui.minhas_sessoes.Minhas_SessoesFragment;
import com.example.appniceface.ui.minhas_sessoes.Minhas_SessoesViewModel;

import java.util.Calendar;

public class AgendarFragment extends Fragment {

Spinner spinnerProcedimento;
Button buttonAgendar;
TextView textViewHoras;

    private AgendarViewModel agendarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        agendarViewModel =
                new ViewModelProvider(this).get(AgendarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_agendar, container, false);
        final TextView textView = root.findViewById(R.id.text_agendar);
        textViewHoras = root.findViewById(R.id.textViewHoras);
        buttonAgendar = root.findViewById(R.id.buttonAgendar);

        agendarViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

//            Spinner spinnerProcedimento = root.findViewById(R.id.spinnerProcedimento);


//            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.procedimentos, android.R.layout.simple_spinner_item);
//
//            public void setAdapter(ArrayAdapter<CharSequence> adapter) {
//                this.adapter = adapter;
//            }
        });



        buttonAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ActivityTelaMenu.class);
                startActivity(intent);
            }
        });
        return root;
    }

    public void abrirHora(View view){
        Calendar c = Calendar.getInstance();
        int horas = c.get(Calendar.HOUR_OF_DAY);
        int minutos = c.get(Calendar.MINUTE);


        TimePickerDialog tmd = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            textViewHoras.setText(hourOfDay + ":" + minute);

            }
        }, horas, minutos, false);
        tmd.show();
    }
}