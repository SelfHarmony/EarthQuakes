package harmony.self.earthquakes;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<EarthQuake>> {
    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "loader onStartLoading");

        forceLoad();
    }

    @Override
    public List<EarthQuake> loadInBackground() {
        Log.i(LOG_TAG, "loader loadInBackground");

        if (mUrl == null) {
            return null;
        }
        // Perform the HTTP request for earthquake data and process the response.
        List<EarthQuake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);

        return earthquakes;
    }
}