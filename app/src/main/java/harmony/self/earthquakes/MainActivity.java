package harmony.self.earthquakes;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquakes.
        ArrayList<EarthQuake> earthquakes = QueryUtils.extractEarthquakes();




        // Find a reference to the {@link ListView} in the layout
        /*  ListView earthquakeListView = (ListView) findViewById(R.id.list);*/


        // Create an {@link EarthQuakeAdapter}, whose data source is a list of
        // {@link earthquakes}s. The adapter knows how to create list item views for each item
        // in the list.
        EarthQuakeAdapter earthQuakeAdapter = new EarthQuakeAdapter(this, earthquakes);


        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(earthQuakeAdapter);


        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
         /*earthquakeListView.setAdapter(adapter);*/
    }
}
