package harmony.self.earthquakes;

public class EarthQuake {

    private String city;

    private String magnitude;

    private long date;

    public EarthQuake(String city, String magnitude, Long date) {
        this.city = city;
        this.magnitude = magnitude;
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public long getDate() {
        return date;
    }

}
