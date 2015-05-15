package br.com.adrianodutra.exemplo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by adriano.dutra on 15/05/15.
 */
public class Quadrado extends View {

    private Paint pincelVermelho;
    private Paint pincelPreto;
    private Paint pincelAzul;
    private int y = 10;

    public Quadrado(Context context){
        super(context, null);

    }

    public Quadrado(Context context, AttributeSet attrs){
        super(context, attrs);
        setBackgroundColor(Color.LTGRAY);

        pincelVermelho = new Paint();
        pincelVermelho.setARGB(255, 255, 0, 0);

        pincelPreto = new Paint();
        pincelPreto.setARGB(255, 0, 0, 0);

        pincelAzul = new Paint();
        pincelAzul.setARGB(255, 0, 0, 255);

        setFocusable(true);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawRect(10, y, 10 + 50, y + 50, pincelAzul);
        canvas.drawLine(50, 50, 100, 100, pincelPreto);
        canvas.drawCircle(100, 100, 20, pincelVermelho);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        Log.i("exemplo", "Foi pressionada a tecla:" + keyCode);

        if(keyCode == KeyEvent.KEYCODE_A){
            y -= 10;
            invalidate();
            return true;
        } else if(keyCode == KeyEvent.KEYCODE_Z){
            y += 10;
            invalidate();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
