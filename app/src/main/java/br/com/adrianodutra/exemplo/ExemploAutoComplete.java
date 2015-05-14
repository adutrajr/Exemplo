package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by adriano.dutra on 14/05/15.
 */
public class ExemploAutoComplete extends Activity {

    public static final String[] ESTADOS = new String[]{"Acre", "Alagoas", "Amapa", "Amazonas", "Bahia",
            "Ceara", "Distrito Federal", "Goias",
            "Espirito Santo", "Maranhao", "Mato Grosso",
            "Mato Grosso do Sul", "Minas Gerais",
            "Para", "Paraiba", "Parana", "Pernambuco",
            "Piaui", "Rio de Janeiro",
            "Rio Grande do Norte", "Rio Grande do Sul",
            "Rondonia", "Roraima", "Sao Paulo",
            "Santa Catarina", "Sergipe", "Tocantins"};

    public static final int[] IMAGENS = new int[]{ R.drawable.mushroom, R.drawable.logo, R.drawable.tunes, R.drawable.awesome };
    public static final String[] imagens = new String[]{ "Toad", "CouchDB", "iTunes", "Awesome" };

    @Override
    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        setContentView(R.layout.auto_complete);

        ImageButton b1 = (ImageButton) findViewById(R.id.imageButton1);
        b1.setImageResource(R.drawable.server);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExemploAutoComplete.this, " Clicou no botao 1 ", Toast.LENGTH_LONG).show();
            }
        });

        ImageButton b2 = (ImageButton) findViewById(R.id.imageButton2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExemploAutoComplete.this, " Clicou no botao 2 ", Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox cb = (CheckBox) findViewById(R.id.receberEmail);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) Toast.makeText(ExemploAutoComplete.this, "Checkbox Marcado", Toast.LENGTH_SHORT).show();
                else Toast.makeText(ExemploAutoComplete.this, "Checkbox Desmarcado", Toast.LENGTH_SHORT).show();
            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioNao :
                        Toast.makeText(ExemploAutoComplete.this, "Escolheu Nao", Toast.LENGTH_SHORT).show(); break;
                    case R.id.radioSim :
                        Toast.makeText(ExemploAutoComplete.this, "Escolheu Sim", Toast.LENGTH_SHORT).show(); break;
                }
            }
        });

        final ImageView img = (ImageView) findViewById(R.id.imgSelected);
        //Imageview img declardaa como final pra ser visivel no AdapterView anonimo, isso ai ta horrivel..

        Spinner select = (Spinner) findViewById(R.id.selectImagens);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, imagens );
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        select.setAdapter(adaptador);
        select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                img.setImageResource(IMAGENS[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        initEstados();
    }

    private void initEstados(){
        ArrayAdapter<String> adaptador =  new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, ESTADOS);

        AutoCompleteTextView estados = (AutoCompleteTextView) findViewById(R.id.estados);
        estados.setAdapter(adaptador);
    }
}