package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

/**
 * Created by adriano.dutra on 11/05/15.
 */
public class ExemploGallery extends Activity implements ViewSwitcher.ViewFactory {

    private int[] imagens = {R.drawable.awesome, R.drawable.logo, R.drawable.okicon, R.drawable.tunes, R.drawable.tux, R.drawable.mushroom};
    private ImageSwitcher imageSwitcher;

    public void onCreate(Bundle icicle){
        super.onCreate(icicle);
        setContentView(R.layout.exemplo_gallery);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        Gallery g = (Gallery) findViewById(R.id.gallery);
        g.setAdapter(new ImageAdapter(this, imagens, new Gallery.LayoutParams(Gallery.LayoutParams.WRAP_CONTENT, Gallery.LayoutParams.WRAP_CONTENT)));

        g.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                imageSwitcher.setImageResource(imagens[position]);
            }

            @Override
            public void onNothingSelected(AdapterView parent) {

            }
        });
    }

    @Override
    public View makeView(){
        ImageView img = new ImageView(this);
        img.setBackgroundColor(0xFF000000);
        img.setScaleType(ImageView.ScaleType.FIT_CENTER);
        img.setLayoutParams(new ImageSwitcher.LayoutParams(ImageSwitcher.LayoutParams.MATCH_PARENT, ImageSwitcher.LayoutParams.MATCH_PARENT));
        return img;
    }
}
