package br.com.adrianodutra.exemplo;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by adriano.dutra on 22/04/15.
 */
public class ExemploSimpleAdapter extends ListActivity {

    public void onCreate(Bundle icicle){
        super.onCreate(icicle);

        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 20; i++){
            HashMap<String,String> item = new HashMap<String,String>();
            item.put("nome", "Nome " + i);
            item.put("fone", "Fone " + i);
            list.add(item);
        }

        String[] from = new String[]{"nome","fone"};
        int[] to = new int[]{ android.R.id.text1, android.R.id.text2 };

        setListAdapter(new SimpleAdapter(this, list, android.R.layout.two_line_list_item, from, to));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        Object o = this.getListAdapter().getItem(position);
        String item = o.toString();

        Toast.makeText(this, "Voce selecionou: " + item, Toast.LENGTH_SHORT);
    }
}
