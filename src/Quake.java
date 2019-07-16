import java.util.*;

public class Quake {

    long time;
    double mag;
    String magType;
    int tsunami;
    String place;

    public Quake(long time, double mag, String magType, int tsunami, String place) {
        this.time = time;
        this.mag = mag;
        this.magType = magType;
        this.tsunami = tsunami;
        this.place = place;
    }

    public double getMag() {

        return mag;
    }

    public int getTsunami() {

        return tsunami;
    }

    public String getPlace(){
        return place;
    }

    public String toString() {

        Date dt = new Date(time);

        return "Magnitude " + mag + " quake at " + dt.toString() + " in " + place;

    }

    public long minutesAgo() {
        long now = System.currentTimeMillis();
        long diff = now - time;
        long minAgo = diff/(1000*60);
        return minAgo;
    }

}
