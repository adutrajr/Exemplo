package br.com.adrianodutra.exemplo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by adriano.dutra on 22/04/15.
 */
public class RoteadorAdapter extends BaseAdapter {

    private Context context;
    private List<Roteador> lista;

    public RoteadorAdapter(Context context, List<Roteador> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {
        Roteador roteador = lista.get(posicao);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.roteador_detalhes, null);

        TextView textNome = (TextView) v.findViewById(R.id.nome);
        textNome.setText(roteador.nome);

        ImageView img = (ImageView) v.findViewById(R.id.status);
        img.setImageResource(roteador.getStatus());

        return v;
    }
}
