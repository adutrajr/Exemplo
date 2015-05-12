package br.com.adrianodutra.exemplo;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

/**
 * Created by adriano.dutra on 11/05/15.
 */
public class ExemploTabHost extends Activity implements ActionBar.TabListener {

    private TabFragment tab1 = null;
    private TabFragment tab2 = null;

    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);

        setContentView(R.layout.activity_menu);
    }

    @SuppressLint("NewApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_activities, menu);
        getActionBar().setTitle("ActionBar");
        getActionBar().setIcon(R.drawable.okicon);
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab lista = getActionBar().newTab();
        lista.setIcon(R.drawable.off);
        lista.setText("Lista");
        lista.setTabListener(this);
        getActionBar().addTab(lista);

        ActionBar.Tab detalhes = getActionBar().newTab();
        detalhes.setIcon(R.drawable.up);
        detalhes.setText("Detalhes");
        detalhes.setTabListener(this);
        getActionBar().addTab(detalhes);

        Log.i("exemplo","ACESSOU: 'onCreateOptionsMenu'");

        return true;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        if(tab.getPosition() == 0) {
            if (tab1 == null) {
                tab1 = new TabFragment();
                Bundle data = new Bundle();
                data.putString("indice","01");
                tab1.setArguments(data);
            }
            ft.replace(android.R.id.content, tab1);
        } else if (tab.getPosition() == 1) {
            if (tab2 == null) {
                tab2 = new TabFragment();
                Bundle data = new Bundle();
                data.putString("indice","02");
                tab2.setArguments(data);
            }
            ft.replace(android.R.id.content, tab2);
        }

        Toast.makeText(this, "Tab selecionada: " + tab.getPosition(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
