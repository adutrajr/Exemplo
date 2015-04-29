package br.com.adrianodutra.exemplo;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by junior on 28/04/15.
 */
public class ExemploLoader extends ActionBarActivity implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener, LoaderManager.LoaderCallbacks<Cursor> {

    private SimpleCursorAdapter adapter;
    public static final int LOADER_ID = 1;
    private String cursorFilter;
    private ListView listView;

    public void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.layout_list_view_contatos);
        getLoaderManager().initLoader(LOADER_ID, null, this);

        adapter = new SimpleCursorAdapter(this, R.layout.layout_list_view_contatos, null, new String[]{ContactsContract.Contacts.DISPLAY_NAME}, new int[]{android.R.id.text1}, 0);

        listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    /** ESTA PARTE CUIDA DA BUSCA NO MENU */

    //Cria o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuItem item = menu.add("Busca");
        item.setIcon(android.R.drawable.ic_menu_search);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);// Mutcho loco!!! Não entendir!!
        SearchView searchView = new SearchView(ExemploLoader.this);
        searchView.setOnQueryTextListener(this);
        item.setActionView(searchView);
        getMenuInflater().inflate(R.menu.menu_exemplo_ciclo_vida, menu);
        return true;
    }

    // Quando a pessoa pressiona enter no campo de busca
    @Override
    public boolean onQueryTextSubmit(String query){
        return false;
    }

    // Quando muda o texto do campo de busca
    @Override
    public boolean onQueryTextChange(String query){
        cursorFilter = (!TextUtils.isEmpty(query)) ? query : null;
        getLoaderManager().restartLoader(LOADER_ID, null, this);
        return true;
    }

    /* ESTA PARTE TRATA DO LOADER */

    // Chamado depois da criacao do loader
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri uri;

        if (cursorFilter == null) {
            uri = ContactsContract.Contacts.CONTENT_URI;
        } else {
            uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(cursorFilter));
        }

        CursorLoader loader = new CursorLoader(this, uri, null, null, null, null);

        return loader;
    }

    // Quando os dados terminam de ser carregados
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0) {
           adapter.swapCursor(cursor);
        }
    }

    // Quando os dados perdem a validade
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }

    /* ESTA PARTE TRATA O CLIQUE SOBRE UM ITEM DO MENU */
    @Override
    public void onItemClick(AdapterView parent, View v, int position, long id){
        Cursor cursor = (Cursor) parent.getItemAtPosition(position);
        String nome = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)); //Samba do macaco louco isso aqui!!
        Toast.makeText(getApplicationContext(), "Clicou no contato '" + nome + "'", Toast.LENGTH_LONG).show();
    }

}
