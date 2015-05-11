package br.com.adrianodutra.exemplo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by adriano.dutra on 08/05/15.
 */
public class ImageAdapter extends BaseAdapter {

    private Context ctx;
    private int[] imagens;
    private final ViewGroup.LayoutParams params;

    public ImageAdapter(Context c, int[] imagens, ViewGroup.LayoutParams params){
        this.ctx = c;
        this.imagens = imagens;
        this.params = params;
    }

    @Override
    public int getCount() {
        return this.imagens.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView img = new ImageView(ctx);
        img.setImageResource(imagens[position]);
        img.setAdjustViewBounds(true);
        img.setLayoutParams(params);

        return img;
    }
}
