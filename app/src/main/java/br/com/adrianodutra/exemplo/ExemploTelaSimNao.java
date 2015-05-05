package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by junior on 02/05/15.
 */
public class ExemploTelaSimNao extends Activity {

    @Override
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);

        setContentView(R.layout.tela_sim_nao);

        Button sim = (Button) findViewById(R.id.btSim);
        sim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent();
                it.putExtra("msg", "Clicou em sim");
                setResult(1, it);
                finish();
            }
        });

        Button nao = (Button) findViewById(R.id.btNao);
        nao.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent();
                it.putExtra("msg","Clicou em não");
                setResult(2,it);
                finish();
            }
        });
    }
}
