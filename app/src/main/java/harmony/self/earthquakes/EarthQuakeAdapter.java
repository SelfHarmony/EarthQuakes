package harmony.self.earthquakes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthQuakeAdapter extends ArrayAdapter {

    private static final String LOG_TAG = EarthQuakeAdapter.class.getSimpleName();

    public EarthQuakeAdapter(Activity context, ArrayList<EarthQuake> earthQuakes) {
        super(context, 0, earthQuakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Get the {@link Earthquake} object located at this position in the list
        EarthQuake currentEarthQuake = (EarthQuake) getItem(position);

        // Find the TextView in the list_item.xml layout with the ID city
        TextView cityTextView = (TextView) listItemView.findViewById(R.id.city);

        // Get the city name from the current earthquake object and
        // set this text on the name TextView
        cityTextView.setText(currentEarthQuake.getCity());

        // Find the TextView in the list_item.xml layout with the ID timeDate
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);

        // Get the timeDate from the current Earthquake object and
        // set this text on the timeDate TextView


        Date currentEarthquakeDate = new Date(currentEarthQuake.getDate());

        dateTextView.setText(new SimpleDateFormat("LLL dd, yyyy").format(currentEarthquakeDate));
        timeTextView.setText(new SimpleDateFormat("h:mm a").format(currentEarthquakeDate));

        // Find the TextView in the list_item.xml layout with the ID magnitude
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude);

        // Get the TextView resource ID from the current Earthquake object and
        // set this text on the magnitudeTextView

        magnitudeTextView.setText(currentEarthQuake.getMagnitude());

            //    ПРИМЕР ДЛЯ КАРТИНОК
                    // set the image to iconView
//        magnitudeTextView.setImageResource(currentAndroidFlavor.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
