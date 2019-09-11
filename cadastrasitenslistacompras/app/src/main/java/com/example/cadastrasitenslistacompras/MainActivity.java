package br.com.opet.tds.appteste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editDisciplina, editNota;
    private ListView listDisciplinas;
    private List<Disciplina> disciplinas;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editDisciplina = findViewById(R.id.editDisciplina);
        editNota = findViewById(R.id.editNota);
        listDisciplinas = findViewById(R.id.listDisciplinas);
    }

    @Override
    protected void onStart(){
        super.onStart();

        disciplinas = new ArrayList<>();
        adapter = new DisciplinaAdapter(getApplicationContext(),R.layout.list_item,disciplinas);
        listDisciplinas.setAdapter(adapter);
    }

    public void adicionarDisciplina(View view) {
        String nome = editDisciplina.getText().toString();
        String nota = editNota.getText().toString();
        Disciplina disciplina = new Disciplina(nome,Double.parseDouble(nota));

        disciplinas.add(disciplina);

        adapter.notifyDataSetChanged();
    }
}
