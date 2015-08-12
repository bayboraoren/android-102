package com.example.android.sunshine.app;

/**
 * Created by android on 11.08.2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailFragment extends Fragment {

    private String forecastStr;

    public static final String FORECAST_SHARE_HASHTAG = "#SunshineApp";

    public static final String LOG_TAG = DetailFragment.class.getSimpleName();

    public DetailFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        Intent intent = getActivity().getIntent();

        if(intent!=null && intent.hasExtra(Intent.EXTRA_TEXT)){

            forecastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView detailText = (TextView)rootView.findViewById(R.id.detail_text);
            detailText.setText(forecastStr);


        }


        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.detail, menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        if(shareActionProvider!=null){
            shareActionProvider.setShareIntent(createShareForecastIntent());
        }else{
            Log.d(LOG_TAG,"Share Action Provider is null?");
        }

    }

    private Intent createShareForecastIntent(){

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,forecastStr + FORECAST_SHARE_HASHTAG);

        return shareIntent;
    }


}