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

        // Create a fake list of earthquake locations.
        ArrayList<EarthQuake> earthquakes = new ArrayList<EarthQuake>();

            earthquakes.add(new EarthQuake("San Francisco", "12", "21.12.2012"));
        earthquakes.add(new EarthQuake("Moscow", "3", "21.12.2012"));
        earthquakes.add(new EarthQuake("San Francisco", "4", "21.12.2012"));
        earthquakes.add(new EarthQuake("San Francisco", "3", "21.12.2012"));
        earthquakes.add(new EarthQuake("San Francisco", "6", "21.12.2012"));
        earthquakes.add(new EarthQuake("San Francisco", "7", "21.12.2012"));
        earthquakes.add(new EarthQuake("San Francisco", "8", "21.12.2012"));
        earthquakes.add(new EarthQuake("San Francisco", "1", "21.12.2012"));



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
