package com.example.exemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText editTextValor;
    private TextView textViewValor;
    private TextView textViewPct;
    private TextView textViewGorjeta;
    private TextView textViewTotal;

    private SeekBar seekBar;
    private double valor;
    private double porcentagem;
    private double total;

    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private NumberFormat percentFormat = NumberFormat.getPercentInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        editTextValor = findViewById(R.id.editTextNumber4);
        textViewValor = findViewById(R.id.textViewValor);
        textViewPct = findViewById(R.id.textViewPct);
        textViewGorjeta = findViewById(R.id.textViewGorjeta);
        textViewTotal = findViewById(R.id.textViewTotal);
        seekBar = findViewById(R.id.seekBar);
        editTextValor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int valorInt;
                try{
                    valorInt = Integer.parseInt(editTextValor.getText().toString());
                }catch (NumberFormatException e ){
                    valorInt = 0;
                }
                valor = valorInt/100.0;
                atualizarValores();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    private void atualizarValores(){
        textViewValor.setText(currencyFormat.format(valor));

    }

}