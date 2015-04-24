package br.com.adrianodutra.exemplo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by junior on 22/04/15.
 */
public class JanelaComBotao extends ActionBarActivity implements View.OnClickListener {

    public static final String LOG_LABEL = "exemplo";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_janela_com_botao);

        Button botao = (Button) findViewById(R.id.botao);
        botao.setOnClickListener(this);

    }

    public void onClick(View view){
        Bundle extras = new Bundle();

        EditText edit = (EditText) findViewById(R.id.campoTexto);

        if (edit != null) {
            extras.putString("texto", edit.getText().toString());
        } else {
            Log.i(LOG_LABEL, "Nao encontrou o 'editText'");
        }

        Intent intent = new Intent(this, OutraJanela.class);
        intent.putExtras(extras);

        startActivity(intent);
    }
}
