package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by adriano.dutra on 07/05/15.
 */
public class ExemploScrollView extends Activity {

    @Override
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);

        setContentView(R.layout.exemplo_scroll_view);

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout1);

        for(int i = 0; i < 100; i++){
            TextView text = new TextView(this);
            text.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            text.setText("Texto: " + i);
            layout.addView(text);
        }
    }

}
