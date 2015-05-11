package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by adriano.dutra on 11/05/15.
 */
public class ExemploWebView extends Activity {

    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);

        WebView web = new WebView(this);
        WebSettings settings = web.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        web.loadUrl("http://www.google.com.br");
        setContentView(web);
    }
}
