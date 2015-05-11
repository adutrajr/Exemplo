package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by adriano.dutra on 11/05/15.
 */
public class ExemploTabHost extends Activity {

    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);

        getActionBar().setTitle("ActionBar");
        getActionBar().setIcon(R.drawable.okicon);
    }
}
