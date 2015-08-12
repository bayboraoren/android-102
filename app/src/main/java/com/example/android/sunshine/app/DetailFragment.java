package com.example.android.sunshine.app;

/**
 * Created by android on 11.08.2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        Intent intent = getActivity().getIntent();

        if(intent!=null && intent.hasExtra(Intent.EXTRA_TEXT)){

            String forecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView detailText = (TextView)rootView.findViewById(R.id.detail_text);
            detailText.setText(forecastStr);


        }


        return rootView;
    }
}