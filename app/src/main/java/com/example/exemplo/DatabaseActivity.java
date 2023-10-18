package com.example.exemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Date;

public class DatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        AppDatabase db = AppDatabase.getInstance(this);
        FuncionarioDAO dao = db.funcionarioDao();
        Funcionario f = new Funcionario(1, "teste", new Date(), 1000, "Estagiario");
        dao.insert(f);
    }
}