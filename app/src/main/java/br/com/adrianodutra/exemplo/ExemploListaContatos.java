package br.com.adrianodutra.exemplo;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by adriano.dutra on 22/04/15.
 */
public class ExemploListaContatos extends ListActivity {

    private ListAdapter adaptador;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.layout_list_view_contatos);

        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        Cursor c = getContentResolver().query(uri, null, null, null, null);

        String[] colunas = new String[]{ContactsContract.Contacts.DISPLAY_NAME};
        int[] campos = new int[]{R.id.nome};

        adaptador = new SimpleCursorAdapter(this, R.layout.layout_contatos, c, colunas, campos, 0b0);
        setListAdapter(adaptador);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position, id);

        Cursor c = (Cursor) adaptador.getItem(position);

        String nomeColuna = ContactsContract.Contacts.DISPLAY_NAME;
        String nome = c.getString(c.getColumnIndexOrThrow(nomeColuna));

        Toast.makeText(this, "Contato Selecionado: " + nome, Toast.LENGTH_SHORT).show();
    }

}
