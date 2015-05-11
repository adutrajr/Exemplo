package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.view.View.OnClickListener;

/**
 * Created by adriano.dutra on 11/05/15.
 */
public class ExemploGridView extends Activity {

    private int[] imagens = { R.drawable.down, R.drawable.error, R.drawable.off, R.drawable.server, R.drawable.up };

    public void onCreate(Bundle icicle){
        super.onCreate(icicle);

        setContentView(R.layout.exemplo_grid);
        GridView grid = (GridView) findViewById(R.id.grid1);
        grid.setAdapter(new ImageAdapter(this, imagens, new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, GridView.LayoutParams.MATCH_PARENT)));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Toast.makeText(ExemploGridView.this, "Imagem Selecionada:" + position, Toast.LENGTH_LONG).show();
            }
        });

    }
}
