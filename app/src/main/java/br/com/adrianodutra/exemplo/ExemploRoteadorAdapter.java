package br.com.adrianodutra.exemplo;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ExemploRoteadorAdapter extends ListActivity {

    public static final String LOG_LABEL = "exemplo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Roteador> list = new ArrayList<Roteador>();
        list.add(new Roteador("Up", Roteador.UP));
        list.add(new Roteador("Down", Roteador.DOWN));
        list.add(new Roteador("Off", Roteador.OFF));
        setListAdapter(new RoteadorAdapter(this, list));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l,v,position,id);

        Roteador roteador = (Roteador) this.getListAdapter().getItem(position);
        Log.i(LOG_LABEL,"Voce clicou em um item: " + roteador.nome);
        Toast.makeText(this, "Voce selecionou o Roteador: " + roteador.nome, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exemplo_smile_adapter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
