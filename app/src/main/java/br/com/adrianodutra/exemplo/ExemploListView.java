package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adriano.dutra on 14/05/15.
 */
public class ExemploListView extends Activity implements AdapterView.OnItemClickListener {

    private static final String LOG_LABEL = "exemplo";
    private ListView listView;

    @Override
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);

        setContentView(R.layout.exemplo_list_view);

        ArrayList<Roteador> lista = new ArrayList<Roteador>();
        lista.add(new Roteador("Online",Roteador.UP));
        lista.add(new Roteador("Offline",Roteador.OFF));
        lista.add(new Roteador("Desligado",Roteador.DOWN));

        RoteadorAdapter adapter = new RoteadorAdapter(this, lista);

        listView = (ListView) findViewById(R.id.customListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(LOG_LABEL, "Posicao clicada: " + position);

        Roteador r = (Roteador) listView.getAdapter().getItem(position);

        Toast.makeText(this, "Roteador selecionado:" + r.nome, Toast.LENGTH_SHORT).show();
    }
}
