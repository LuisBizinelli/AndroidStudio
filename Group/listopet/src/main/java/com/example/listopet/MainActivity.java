package com.example.listopet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Disciplina> disciplinas;
    private ListView listDisciplinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listDisciplinas = findViewById(R.id.listDisciplinas);
    }
    @Override
    protected void onStart(){
        super.onStart();
        disciplinas = new ArrayList<>();
        disciplinas.add(new Disciplina("Algoritimo", 8.5));
        disciplinas.add(new Disciplina("Banco de dados", 6.5));
        disciplinas.add(new Disciplina("Redes", 3.0));

        ArrayAdapter adapter = new DisciplinaAdapter(getApplicationContext(), R.layout.lista_item, disciplinas);
        listDisciplinas.setAdapter(adapter);
    }

}
