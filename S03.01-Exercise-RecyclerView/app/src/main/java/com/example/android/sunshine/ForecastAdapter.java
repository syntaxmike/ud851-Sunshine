package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Syntax Mike on 6/23/2017.
 */

// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
// DONE (15) Add a class file called ForecastAdapter
// DONE (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>

// DONE (23) Create a private string array called mWeatherData

// DONE (47) Create the default constructor (we will pass in parameters in a later lesson)

// DONE (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
// DONE (17) Extend RecyclerView.ViewHolder

// DONE (24) Override onCreateViewHolder
// DONE (25) Within onCreateViewHolder, inflate the list item xml into a view
// DONE (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter

// DONE (27) Override onBindViewHolder
// DONE (28) Set the text of the TextView to the weather for this list item's position

// DONE (29) Override getItemCount
// DONE (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null

// DONE (31) Create a setWeatherData method that saves the weatherData to mWeatherData
// DONE (32) After you save mWeatherData, call notifyDataSetChanged
// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////

// Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
// DONE (18) Create a public final TextView variable called mWeatherTextView

// DONE (19) Create a constructor for this class that accepts a View as a parameter
// DONE (20) Call super(view) within the constructor for ForecastAdapterViewHolder
// DONE (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
// Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////


public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {

    private String[] mWeatherData;

    public ForecastAdapter() {

    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.forecast_list_item, parent, shouldAttachToParentImmediately);
        ForecastAdapterViewHolder holder = new ForecastAdapterViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText(mWeatherData[position]);
    }

    @Override
    public int getItemCount() {

        if(mWeatherData == null) {
            return 0;
        }else{
            return mWeatherData.length;
        }
    }

    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder (View view){
            super(view);
            mWeatherTextView = (TextView)view.findViewById(R.id.tv_weather_data);
        }

    }

    public void setWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }
}
