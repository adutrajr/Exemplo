package br.com.adrianodutra.exemplo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by junior on 24/04/15.
 */
public class OutraJanela extends ActionBarActivity {

    public static final String LOG_LABEL = "exemplo";

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        TextView text = new TextView(this);
        text.setText("A mensagem nao chegou, verifique o LogCat");

        Intent it = getIntent();
        if(it != null) {
            if (it.getExtras() != null) {
                if (it.getExtras().getString("texto") != null)
                    text.setText(it.getExtras().getString("texto"));
                else Log.i(LOG_LABEL, "Parametro 'texto' nao existe");
            } else Log.i(LOG_LABEL, "Bundle nulo");
        } else Log.i(LOG_LABEL, "Intent nulo");

        setContentView(text);
    }
}
