package br.com.adrianodutra.exemplo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by adriano.dutra on 22/04/15.
 */
public class ExemploCicloVida extends ActionBarActivity {

    private static final String CATEGORIA = "exemplo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_exemplo_ciclo_vida);
        Log.i(CATEGORIA, getClassName() + " onCreate() chamado.");
    }

    protected void onStart(){
        super.onStart();
        Log.i(CATEGORIA, getClassName() + " onStart() chamado.");
    }

    protected void onRestart(){
        super.onRestart();
        Log.i(CATEGORIA, getClassName() + " onRestart() chamado.");
    }

    protected void onResume(){
        super.onResume();
        Log.i(CATEGORIA, getClassName() + " onResume() chamado.");
    }

    protected void onPause(){
        super.onPause();
        Log.i(CATEGORIA, getClassName() + " onPause() chamado.");
    }

    protected void onStop(){
        super.onStop();
        Log.i(CATEGORIA, getClassName() + " onStop() chamado.");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i(CATEGORIA, getClassName() + " onDestroy() chamado.");
    }

    private String getClassName(){
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exemplo_ciclo_vida, menu);
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
