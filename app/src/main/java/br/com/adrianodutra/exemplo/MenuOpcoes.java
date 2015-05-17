package br.com.adrianodutra.exemplo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MenuOpcoes extends ListActivity {

    private static final String[] nomes = new String[] {"Ciclo de Vida",
                                                        "Invocar Janela",
                                                        "Consulta Contatos",
                                                        "Adapter com HashMap",
                                                        "Cursor Customizado - Roteador",
                                                        "Google Maps",
                                                        "Utilizando Loader",
                                                        "Consultando uma URI",
                                                        "Invocando Parametros",
                                                        "Montando layouts Linear com API",
                                                        "Montando layouts Table com API",
                                                        "Exemplo com ScrollView",
                                                        "Exemplo com GridView",
                                                        "Exemplo com Gallery",
                                                        "Exemplo com WebView",
                                                        "Exemplo com ActionBar (deprecated)",
                                                        "Exemplo Texto, Cores e Estilo",
                                                        "Exemplo Componentes de Formulario",
                                                        "Exemplo Progress Bar",
                                                        "Exemplo Janelas de Alerta",
                                                        "Exemplo Custom ListView",
                                                        "Exemplo com Canvas",
                                                        "Controlar imagem no Canvas",
                                                        "Eventos de toque na tela",
                                                        "Sair"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        switch (position) {
            case 0: startActivity(new Intent(this, ExemploCicloVida.class)); break;
            case 1: startActivity(new Intent(this, JanelaComBotao.class)); break;
            case 2: startActivity(new Intent(this, ExemploListaContatos.class)); break;
            case 3: startActivity(new Intent(this, ExemploSimpleAdapter.class)); break;
            case 4: startActivity(new Intent(this, ExemploRoteadorAdapter.class)); break;
            case 5: startActivity(new Intent(this, ExemploMapa.class)); break;
            case 6: startActivity(new Intent(this, ExemploLoader.class)); break;
            case 7: startActivity(new Intent(this, VisualizarTodosContatos.class)); break;
            case 8: startActivity(new Intent(this, InvocaExemploSimNao.class)); break;
            case 9: startActivity(new Intent(this, ExemploLinearLayoutApi.class)); break;
            case 10: startActivity(new Intent(this, ExemploTableLayoutApi.class)); break;
            case 11: startActivity(new Intent(this, ExemploScrollView.class)); break;
            case 12: startActivity(new Intent(this, ExemploGridView.class)); break;
            case 13: startActivity(new Intent(this, ExemploGallery.class)); break;
            case 14: startActivity(new Intent(this, ExemploWebView.class)); break;
            case 15: startActivity(new Intent(this, ExemploTabHost.class)); break;
            case 16: startActivity(new Intent(this, ExemploTextoCores.class)); break;
            case 17: startActivity(new Intent(this, ExemploAutoComplete.class)); break;
            case 18: startActivity(new Intent(this, ExemploProgressBar.class)); break;
            case 19: startActivity(new Intent(this, ExemploJanelasDeAlerta.class)); break;
            case 20: startActivity(new Intent(this, ExemploListView.class)); break;
            case 21: startActivity(new Intent(this, ExemploCanvas.class)); break;
            case 22: startActivity(new Intent(this, ExemploCanvasControle.class)); break;
            case 23: startActivity(new Intent(this, ExemploTouchScreen.class)); break;
            default: finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activities, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
