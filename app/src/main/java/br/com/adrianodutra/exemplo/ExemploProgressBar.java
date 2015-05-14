package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by adriano.dutra on 14/05/15.
 */
public class ExemploProgressBar extends Activity {

    private Handler handler = new Handler();

    public static ProgressDialog dialog;
    public static String url = "http://developer.android.com/assets/images/dac_logo.png";
    public static final String LOG_LABEL = "exemplo";

    private ProgressBar bar;
    private int progresso = 0;

    @Override
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);

        setContentView(R.layout.exemplo_progress_dialog);

        dialog = new ProgressDialog(this);

        bar = (ProgressBar) findViewById(R.id.bar);
        EditText texto = (EditText) findViewById(R.id.urlImagem);
        texto.setText(url);

        Button botao = (Button) findViewById(R.id.botaoBarraDeProgresso);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText texto = (EditText) findViewById(R.id.urlImagem);

                downloadImagem(texto.getText().toString());

                dialog.setTitle("Exemplo");
                dialog.setMessage("Buscando imagem, por favor aguarde...");
                dialog.setIndeterminate(true);
                dialog.setCancelable(true);
                dialog.show();
            }
        });

        Button botaoExemplo = (Button) findViewById(R.id.botaoExemploProgresso);
        botaoExemplo.setOnClickListener(new View.OnClickListener() {
            @Override //Essa parte do codigo aqui embaixo eh horrivel, eu sei, chega a lembrar aquele filme, Inception.
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progresso < 100){
                            progresso = simulaTarefa();

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Log.i(LOG_LABEL,">> Progresso: " + progresso);
                                    bar.setProgress(progresso);
                                }
                            });
                        }
                    }
                }).start();
            }
        });
    }

    private void downloadImagem(final String urlImagem){
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlImagem);
                    InputStream is = url.openStream();
                    final Bitmap imagem = BitmapFactory.decodeStream(is);
                    is.close();
                    atualizaImagem(imagem);
                } catch (Exception ex) {
                    Log.e(LOG_LABEL,"URL invalida: " + ex.getMessage());
                    return;
                }
            }
        }.start();
    }

    private void atualizaImagem(final Bitmap imagem){

        handler.post(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                ImageView img = (ImageView) findViewById(R.id.wallPaper);
                img.setImageBitmap(imagem);
            }
        });

    }

    private int simulaTarefa(){
        progresso++;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Log.e(LOG_LABEL,"Interrupçao da Thread");
            e.printStackTrace();
        }
        return progresso;
    }
}
