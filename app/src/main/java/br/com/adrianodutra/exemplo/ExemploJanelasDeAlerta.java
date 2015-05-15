package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by adriano.dutra on 14/05/15.
 */
public class ExemploJanelasDeAlerta extends Activity {

    private static final int VISITADO = 0;
    private static final int ESPERANDO = 1;
    private static final int NOVOS = 2;
    private static final int PESQUISAR = 3;
    private static final int SAIR = 4;
    private static final int OUTROS = 5;

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

    //Cria o menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        MenuItem item = menu.add(0, VISITADO , 0, "Visitados");
        item.setIcon(R.drawable.up);

        item = menu.add(0, ESPERANDO , 2, "Esperando");
        item.setIcon(R.drawable.down);

        item = menu.add(0, NOVOS , 1, "Novos Locais");
        item.setIcon(R.drawable.off);

        SubMenu subMenu = menu.addSubMenu(0, OUTROS, 0, "Outros");

        item = subMenu.add(0, PESQUISAR, 0, "Pesquisar");
        item.setIcon(R.drawable.server);

        item = subMenu.add(0, SAIR, 0, "Sair");
        item.setIcon(R.drawable.error);

        return true;
    }

    //Trata os clicks nas opçoes do menu
    @Override
    public boolean onMenuItemSelected(int id, MenuItem item){

        switch(item.getItemId()){
            case VISITADO: Toast.makeText(this, "Clicou em: Visitados", Toast.LENGTH_SHORT).show(); break;
            case NOVOS: Toast.makeText(this, "Clicou em: Novos Locais", Toast.LENGTH_SHORT).show(); break;
            case ESPERANDO: Toast.makeText(this, "Clicou em: Esperando", Toast.LENGTH_SHORT).show(); break;
            case SAIR: Toast.makeText(this, "Clicou em: Sair", Toast.LENGTH_SHORT).show(); break;
            case PESQUISAR: Toast.makeText(this, "Clicou em: Pesquisar", Toast.LENGTH_SHORT).show(); break;
        }

        return true;
    }
}

