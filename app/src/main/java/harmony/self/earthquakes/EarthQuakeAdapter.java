package harmony.self.earthquakes;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
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
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location);
        TextView cityTextView = (TextView) listItemView.findViewById(R.id.city);

        String location = currentEarthQuake.getCity();
        String[] parts = new String[2];
        if (location.contains("of ")){
            parts = location.split("of ");
            parts[0] += "of";
        } else {
        parts[0] = "Near the";
        parts[1] = location;
        }

        // Get the city name from the current earthquake object and
        // set this text on the name TextView
        locationTextView.setText(parts[0]);
        cityTextView.setText(parts[1]);

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
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magnitude = formatter.format(currentEarthQuake.getMagnitude());
        // Get the TextView resource ID from the current Earthquake object and
        // set this text on the magnitudeTextView

        magnitudeTextView.setText(magnitude);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthQuake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

            //    ПРИМЕР ДЛЯ КАРТИНОК
                    // set the image to iconView
//        magnitudeTextView.setImageResource(currentAndroidFlavor.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId = 0;
        ContextCompat cc = new ContextCompat();
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;

        }
        return getContext().getResources().getColor(magnitudeColorResourceId);
    }




}
