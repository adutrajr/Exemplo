package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by junior on 02/05/15.
 */
public class InvocaExemploSimNao extends Activity implements View.OnClickListener {

    private static final int ACTIVITY_SIM_NAO = 1;
    @Override
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);

        Button button = new Button(this);
        button.setText("Vc gosta de programar?");
        button.setOnClickListener(this);

        setContentView(button);
    }

    protected void onActivityResult(int codigo, int resultado, Intent it){
        if(codigo == ACTIVITY_SIM_NAO){

            Bundle params = (it != null) ? it.getExtras() : null;

            if(params != null){
                String msg = (String) params.getString("msg");

                if(resultado == 1) Toast.makeText(this, "Escolheu Sim:" + msg, Toast.LENGTH_SHORT).show();
                else if(resultado == 2) Toast.makeText(this, "Escolheu Não:" + msg, Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "Não definido: " + msg, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        startActivityForResult(new Intent(this, ExemploTelaSimNao.class), ACTIVITY_SIM_NAO);
    }

}
