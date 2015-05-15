package br.com.adrianodutra.exemplo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by adriano.dutra on 15/05/15.
 */
public class NumericEdit extends EditText {

    public NumericEdit(Context context){
        super(context);
    }

    public NumericEdit(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public Integer getNumber(){
        String s = getText().toString();

        if(s != null){
            Integer valor;

            try {
                valor = Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                return 0;
            }

            return valor;
        }

        return null;
    }

}
