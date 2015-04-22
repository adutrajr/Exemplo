package br.com.adrianodutra.exemplo;

/**
 * Created by adriano.dutra on 22/04/15.
 */
public class Roteador {

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int OFF = 2;

    public String nome;
    private final int tipo;

    public Roteador(String nome, int tipo){
        this.nome = nome;
        this.tipo = tipo;

    }

    public int getStatus(){

        switch (tipo) {
            case UP: return R.drawable.up;
            case DOWN: return R.drawable.down;
            case OFF: return R.drawable.off;
        }

        return R.drawable.error;
    }
}
