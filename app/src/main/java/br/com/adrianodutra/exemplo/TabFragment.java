package br.com.adrianodutra.exemplo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by adriano.dutra on 12/05/15.
 */
public class TabFragment extends Fragment {

    private String indice = "";

    public void onCreate(Bundle icicle){
        super.onCreate(icicle);
        Bundle data = getArguments();
        indice = data.getString("indice");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle icicle){
        View v = inflater.inflate(R.layout.exemplo_tab_fragment, null);
        TextView t = (TextView) v.findViewById(R.id.msgFragment);
        t.setText("Tab: " + indice);

        return v;
    }
}
