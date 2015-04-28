package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by junior on 28/04/15.
 */
public class ExemploLoader extends Activity implements LoaderManager.LoaderCallbacks<Cursor> {

    //private ListAdapter adapter;
    public static final int LOADER_ID = 1;

    public void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);

        getLoaderManager().initLoader(LOADER_ID, null, this);

        setContentView(R.layout.layout_contatos);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        CursorLoader loader = new CursorLoader(this, ContactsContract.Contacts.CONTENT_URI, null,null,null, null);

        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0) {
            int indiceNome = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            String nome = cursor.getString(indiceNome);
            TextView view = (TextView) findViewById(R.id.nome);
            view.setText(nome);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
