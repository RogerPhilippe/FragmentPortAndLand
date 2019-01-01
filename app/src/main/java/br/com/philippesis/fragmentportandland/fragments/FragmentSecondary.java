package br.com.philippesis.fragmentportandland.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.philippesis.fragmentportandland.R;

public class FragmentSecondary extends Fragment {

    private TextView tvDefaultText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_secondary_layout, null);

        tvDefaultText = (TextView) view.findViewById(R.id.idtvDefaultText);

        return view;

    }

    public void setTvDefaultText(String text) {
        tvDefaultText.setText(text);
    }
}
