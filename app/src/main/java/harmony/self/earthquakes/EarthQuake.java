package harmony.self.earthquakes;

public class EarthQuake {

    private String city;

    private double magnitude;

    private long date;

    public EarthQuake(String city, double magnitude, Long date) {
        this.city = city;
        this.magnitude = magnitude;
        this.date = date;
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
