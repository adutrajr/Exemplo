package br.com.adrianodutra.exemplo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

/**
 * Created by adriano.dutra on 15/05/15.
 */
public class Scene extends View {

    private Drawable img;
    int x;
    int y;
    int pulo = 10;
    int largura;
    int altura;

    public Scene(Context ctx, AttributeSet attrs){
        super(ctx, attrs);

        setBackgroundResource(R.drawable.logo);

        img = ctx.getResources().getDrawable(R.drawable.smile);

        largura = img.getIntrinsicWidth();
        altura = img.getIntrinsicHeight();

        setFocusable(true);
    }

    /*public Scene(Context ctx){
        super(ctx, null);

        setBackgroundResource(R.drawable.background);

        img = ctx.getResources().getDrawable(R.drawable.smile);

        largura = img.getIntrinsicWidth();
        altura = img.getIntrinsicHeight();

        setFocusable(true);
    }*/

    // Se mudar o tamanho da tela reposiciona a imagem no meio da View
    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight){
        super.onSizeChanged(width, height, oldWidth, oldHeight);

        // Desenha a imagem no exato meio da tela, metade da altura e largura com um recuo no
        // ponto de incio do desenho de metade da altura e largura da imagem
        x = width / 2 - (largura / 2);
        y = height / 2 - (altura / 2);
    }

    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        // define os limiter dentro da View onde a imagem pode ser desenhada
        img.setBounds(x, y, x + largura, y + altura);
        // desenha a imagem
        img.draw(canvas);
    }

    // Chamado quando o usuario pressiona alguma tecla,se forem teclas de controle movimenta a img
    // As teclas sao: A W S D
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){

        boolean redraw = true;

        switch (keyCode){
            case KeyEvent.KEYCODE_W: y -= pulo; break;
            case KeyEvent.KEYCODE_A: x -= pulo; break;
            case KeyEvent.KEYCODE_D: x += pulo; break;
            case KeyEvent.KEYCODE_S: y += pulo; break;
            default: redraw = false;
        }

        if (redraw) {
            invalidate();
            return true;
        }

        // se sua classe nao tratou esse evento repasse ela pra frente
        return super.onKeyDown(keyCode, event);
    }

    // Nao sei o que faz...
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    // Sei menos ainda...
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom){
        super.onLayout(changed, left, top, right, bottom);
    }

}
