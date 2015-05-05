package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by junior on 02/05/15.
 */
public class VisualizarTodosContatos extends Activity implements View.OnClickListener {

    private static final int SELECIONAR_CONTATO = 1;
    private static final String CATEGORIA = "livro";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizar_contatos);
        Button button = (Button) findViewById(R.id.botaoOk);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse("content://com.android.contacts/contacts/");

        Intent it = new Intent(Intent.ACTION_PICK, uri);

        startActivityForResult(it, SELECIONAR_CONTATO);
    }

    @Override
    protected void onActivityResult(int codigo, int resultado, Intent it){
        if(it == null){
            Toast.makeText(this, "Nenhum contato", Toast.LENGTH_SHORT).show();
        } else {
            Uri uri = it.getData();
            Cursor c = managedQuery(uri, null, null, null, null);
            c.moveToNext();
            int nameColumn = c.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME);
            String nome = c.getString(nameColumn);
            Toast.makeText(this, "Nome: " + nome, Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }
}
