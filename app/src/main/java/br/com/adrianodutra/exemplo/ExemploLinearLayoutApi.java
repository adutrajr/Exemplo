package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
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
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setPadding(10, 10, 10, 10);
        TextView nome = new TextView(this);
        nome.setText("Nome: ");
       // nome.setLayoutParams(new TextView.LayoutParams());
    }
}
