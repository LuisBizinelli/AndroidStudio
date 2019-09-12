package br.com.opet.tds.appteste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DisciplinaAdapter extends ArrayAdapter<Disciplina> {

    private int rId;

    public DisciplinaAdapter(Context context, int resource, List<Disciplina> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Disciplina disciplina = getItem(position);

        TextView textDisciplina = mView.findViewById(R.id.textDisciplina);
        TextView textNota = mView.findViewById(R.id.textNota);

        textDisciplina.setText(disciplina.getNome());
        textNota.setText(String.valueOf(disciplina.getNota()));

        return mView;
    }
}
