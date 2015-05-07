package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by junior on 07/05/15.
 */
public class ExemploLinearLayoutApi extends Activity {

    @Override
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setPadding(10, 10, 10, 10);

        TextView nome = new TextView(this);
        nome.setText("Nome: ");
        nome.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(nome);

        EditText tnome = new EditText(this);
        tnome.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(tnome);
        tnome.requestFocus();//Define o foco nesse campo

        TextView senha = new TextView(this);
        senha.setText("Senha: ");
        senha.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(senha);

        EditText tsenha = new EditText(this);
        tsenha.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.addView(tsenha);

        Button ok = new Button(this);
        ok.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ok.setGravity(Gravity.RIGHT);
        ok.setText("OK");
        layout.addView(ok);

        setContentView(layout);
    }
}
