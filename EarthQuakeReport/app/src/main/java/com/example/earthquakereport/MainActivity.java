package com.example.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add("7.2", "San Francisco", "Feb 2, 2016");
        earthquakes.add("6.1", "London", "July 20, 2015");
        earthquakes.add("3.9", "Tokyo", "Nov 10, 2014");
        earthquakes.add("5.4", "Mexico City", "May 3, 2014");
        earthquakes.add("2.8", "Moscow", "Jan 31, 2013");
        earthquakes.add("4.9", "Rio de Janeiro", "Aug 19, 2012");
        earthquakes.add("1.6", "Paris", "Oct 30, 2011");

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
    }
}