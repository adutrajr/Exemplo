package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by adriano.dutra on 14/05/15.
 */
public class ExemploJanelasDeAlerta extends Activity {

    @Override
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);

        setContentView(R.layout.exemplo_janelas_de_alerta);

        Button alerta01 = (Button) findViewById(R.id.botaoAlerta01);
        alerta01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alerta =  new AlertDialog.Builder(ExemploJanelasDeAlerta.this);
                alerta.setIcon(R.drawable.up);
                alerta.setTitle("Titulo de Exemplo");
                alerta.setMessage("Escolha Sim o Nao, por favor.");

                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int wichButton) {
                        Toast.makeText(ExemploJanelasDeAlerta.this, "Escolheu 'Sim'", Toast.LENGTH_SHORT).show();
                    }
                });

                alerta.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int wichButton) {
                        Toast.makeText(ExemploJanelasDeAlerta.this, "Escolheu 'Nao'", Toast.LENGTH_SHORT).show();
                    }
                });

                alerta.show();
            }
        });

        Button alerta02 = (Button) findViewById(R.id.botaoAlerta02);
        alerta02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.texto_cores, null);
                Toast toast = new Toast(ExemploJanelasDeAlerta.this);
                toast.setView(view);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }
}
