package com.example.listopet;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DisciplinaAdapter extends ArrayAdapter<Disciplina> {
    private int rId;
    public DisciplinaAdapter(Context context, int resource, List<Disciplina> lista){
        super(context,resource,lista);
        rId = resource;

    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View mView = currentView;
        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId, null);
        }

        TextView textDisciplina = mView.findViewById(R.id.textDisciplina);
        TextView textNota = mView.findViewById(R.id.textNota);
        Disciplina disciplina = getItem(position);

        if (disciplina.getNota() >=7.0)
            textNota.setTextColor(Color.BLUE);
        else if (disciplina.getNota() >= 4.0 && disciplina.getNota()<7.0)
            textNota.setTextColor(Color.MAGENTA);
        else
            textNota.setTextColor(Color.RED);
        textDisciplina.setText(disciplina.getNome());
        textNota.setText(String.valueOf(disciplina.getNota()));
        return mView;
    }

}
