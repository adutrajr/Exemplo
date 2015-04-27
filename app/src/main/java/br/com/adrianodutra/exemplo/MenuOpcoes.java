package br.com.adrianodutra.exemplo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MenuOpcoes extends ListActivity {

    private static final String[] nomes = new String[] {"Ciclo de Vida","Invocar Janela","Consulta Contatos","Adapter com HashMap","Cursor Customizado - Roteador","Google Maps", "Sair"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        switch (position) {
            case 0: startActivity(new Intent(this, ExemploCicloVida.class)); break;
            case 1: startActivity(new Intent(this, JanelaComBotao.class)); break;
            case 2: startActivity(new Intent(this, ExemploListaContatos.class)); break;
            case 3: startActivity(new Intent(this, ExemploSimpleAdapter.class)); break;
            case 4: startActivity(new Intent(this, ExemploRoteadorAdapter.class)); break;
            case 5: startActivity(new Intent(this, ExemploMapa.class)); break;
            default: finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activities, menu);
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
