package com.example.exemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseActivity extends AppCompatActivity {

    private EditText editTextRe;
    private EditText editTextNome;
    private EditText editTextDataAdmissao;
    private EditText editTextSalario;
    private EditText editTextCargo;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        editTextRe = findViewById(R.id.editTextRe);
        editTextNome = findViewById(R.id.editTextNome);
        editTextDataAdmissao = findViewById(R.id.editTextDataAdmissao);
        editTextSalario = findViewById(R.id.editTextSalario);
        editTextCargo = findViewById(R.id.editTextCargo);

    }
    public void cadastrar (View view) {
        int re = Integer.parseInt(editTextRe.getText().toString());
        String nome = editTextNome.getText().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAdmissao;
        try {
            dataAdmissao = dateFormat.parse(editTextDataAdmissao.getText().toString());
        } catch (ParseException e) {
            dataAdmissao = new Date();
        }
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDAO dao = db.funcionarioDao();
        Funcionario f = new Funcionario(1, "teste", new Date(), 1000, "Estagiario");
        dao.insert(f);
    }
}