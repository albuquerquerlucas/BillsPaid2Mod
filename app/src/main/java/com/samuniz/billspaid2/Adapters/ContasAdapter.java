package com.samuniz.billspaid2.Adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.samuniz.billspaid2.Entitys.Conta;
import com.samuniz.billspaid2.R;

import java.util.List;

/**
 * Created by Lucas on 14/11/2017.
 */

public class ContasAdapter extends ArrayAdapter {

    private Activity context;
    private int resource;
    private List<Conta> contas;

    public ContasAdapter(@NonNull Activity context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.contas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View linha = inflater.inflate(resource, null);

        TextView txtItemDescricaoC = linha.findViewById(R.id.txtItemDescricaoC);
        TextView txtItemValorC = linha.findViewById(R.id.txtItemValorC);

        txtItemDescricaoC.setText(contas.get(position).getDescicao());
        txtItemValorC.setText(contas.get(position).getValor());

        return linha;
    }
}
