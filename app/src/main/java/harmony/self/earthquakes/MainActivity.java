package harmony.self.earthquakes;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    //CONSTANTS
    private static String amountOfDataToShow = "50";
    private static String minmag = "3";

    private static final String USGS_REQUEST_URL =
            "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=" +minmag+ "&limit=" + amountOfDataToShow;

    public static final String LOG_TAG = MainActivity.class.getName();

    /* Create an {@link EarthQuakeAdapter}, whose data source is a list of
     {@link earthquakes}s. The adapter knows how to create list item views for each item
     in the list.*/
    EarthQuakeAdapter earthQuakeAdapter;

    //////////////////////////////////////////////////////////////////////////////////////////////




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        new BackgroundNetworking().execute(USGS_REQUEST_URL);

        ListView listView = (ListView) findViewById(R.id.list);

        earthQuakeAdapter = new EarthQuakeAdapter(this, new ArrayList<EarthQuake>());
        listView.setAdapter(earthQuakeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                EarthQuake currentEarthquake = (EarthQuake) earthQuakeAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
         /*earthquakeListView.setAdapter(adapter);*/
    }

    private void updateUI(ArrayList<EarthQuake> earthquakes) {

    }

    private class BackgroundNetworking extends AsyncTask<String, Void, ArrayList<EarthQuake>>{
        @Override
        protected ArrayList<EarthQuake> doInBackground(String... urls) {

            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            // Perform the HTTP request for earthquake data and process the response.
            ArrayList<EarthQuake> earthquakes = QueryUtils.fetchEarthquakeData(urls[0]);

            return earthquakes;
        }

        @Override
        protected void onPostExecute(ArrayList<EarthQuake> result) {
            earthQuakeAdapter.clear();

                if (result != null && !result.isEmpty()) {
                    earthQuakeAdapter.addAll(result);
                }

        }
    }
}
