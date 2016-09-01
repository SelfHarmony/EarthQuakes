package harmony.self.earthquakes;

public class EarthQuake {

    private String city;

    private double magnitude;

    private long date;

    private String url;

    public EarthQuake(String city, double magnitude, Long date, String url) {
        this.city = city;
        this.magnitude = magnitude;
        this.date = date;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getCity() {
        return city;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public long getDate() {
        return date;
    }


}
