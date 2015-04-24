package br.com.adrianodutra.exemplo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by junior on 24/04/15.
 */
public class OutraJanela extends ActionBarActivity {

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        TextView text = new TextView(this);
        if(savedInstance != null)
            text.setText(savedInstance.getString("texto"));

        setContentView(text);
    }
}
