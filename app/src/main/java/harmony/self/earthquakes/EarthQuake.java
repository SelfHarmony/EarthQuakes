package harmony.self.earthquakes;

public class EarthQuake {

    private String city;

    private String magnitude;

    private String date;

    public EarthQuake(String city, String magnitude, String date) {
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

    public String getDate() {
        return date;
    }

}
