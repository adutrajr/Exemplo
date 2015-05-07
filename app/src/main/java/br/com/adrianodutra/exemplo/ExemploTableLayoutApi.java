package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by adriano.dutra on 07/05/15.
 */
public class ExemploTableLayoutApi extends Activity {

    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);

        TableLayout tabela = new TableLayout(this);
        tabela.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
        tabela.setColumnStretchable(1, true); //expande a coluna 01

        TableRow linha1 = new TableRow(this);
        TextView nome = new TextView(this);
        nome.setText("Nome: ");
        linha1.addView(nome);
        EditText tnome = new EditText(this);
        tnome.requestFocus();
        linha1.addView(tnome);

        TableRow linha2 = new TableRow(this);
        TextView senha = new TextView(this);
        senha.setText("Senha: ");
        linha2.addView(senha);
        EditText tsenha = new EditText(this);
        tsenha.setTransformationMethod(new PasswordTransformationMethod());
        linha2.addView(tsenha);

        TableRow linha3 = new TableRow(this);
        linha3.setGravity(Gravity.RIGHT);
        Button ok = new Button(this);
        ok.setText("Login");
        linha3.addView(ok);

        tabela.addView(linha1);
        tabela.addView(linha2);
        tabela.addView(linha3);

        setContentView(tabela);
    }
}
