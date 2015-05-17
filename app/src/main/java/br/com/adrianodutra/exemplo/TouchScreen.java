package br.com.adrianodutra.exemplo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.net.ContentHandler;

/**
 * Created by junior on 16/05/15.
 */
public class TouchScreen extends View {

    private static final String LOG_LABEL = "exemplo";

    private Drawable img;
    int x;
    int y;
    private boolean selecionou;
    private int larguraTela;
    private int alturaTela;
    private int larguraImg;
    private int alturaImg;

    public TouchScreen(Context ctx){
        super(ctx, null);

        img = ctx.getResources().getDrawable(R.drawable.smile);
        larguraImg = img.getIntrinsicWidth();
        alturaImg = img.getIntrinsicHeight();

        setFocusable(true);

    }

    public TouchScreen(Context ctx, AttributeSet attrs){
        super(ctx, attrs);

        img = ctx.getResources().getDrawable(R.drawable.smile);
        larguraImg = img.getIntrinsicWidth();
        alturaImg = img.getIntrinsicHeight();

        setFocusable(true);

    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight){
        super.onSizeChanged(width, height, oldWidth, oldHeight);

        this.larguraTela = width;
        this.alturaTela = height;

        x = width / 2 - (larguraImg / 2);
        y = height / 2 - (alturaImg / 2);

        Log.i(LOG_LABEL, "onSizeChanged x/y : " + x + "/" + y);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Paint pincel = new Paint();
        pincel.setColor(Color.WHITE);

        canvas.drawRect(0, 0, larguraTela, alturaTela, pincel);

        img.setBounds(x, y, x + larguraImg, y + alturaImg);
        img.draw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        Log.i(LOG_LABEL, "onTouchEvent x/y : " + x + "/" + y);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: selecionou = img.copyBounds().contains((int) x, (int) y); break;
            case MotionEvent.ACTION_MOVE:
                if(selecionou) {
                    this.x = (int) x - (larguraImg / 2);
                    this.y = (int) y - (alturaImg / 2);
                }
                break;
            case MotionEvent.ACTION_UP: selecionou = false; break;
        }

        invalidate();

        return true;
    }
}
