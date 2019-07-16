import core.data.*;

public class QuakeTest {


     public static void main(String[] args) {

            DataSource ds = DataSource.connect("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");
            ds.load();

            Quake[] quakes = ds.fetchArray("Quake", "features/properties/time",
                    "features/properties/mag", "features/properties/magType",
                    "features/properties/tsunami", "features/properties/place");

            int numQuakes = quakes.length;
            System.out.println(numQuakes + " quakes in the data set");

            int cntTs = 0;
            Quake biggestMag = quakes[0];

            for (int i = 0; i < numQuakes; i++) {
                if (quakes[i].getMag() > 4) {
                    System.out.println(quakes[i]);
                }
                if (quakes[i].getTsunami() == 1) {
                    cntTs++;
                }
                if (quakes[i].getMag() > biggestMag.getMag()) {
                    biggestMag = quakes[i];
                }
            }


            long [] magCount = new long[4];
            final String [] magLabel = {"Magnitudes less than 2", "Magnitudes between 2 and 4",
                    "Magnitudes between 4 and 6", "Magnitudes greater than 6"};

            for (int i = 0; i < numQuakes; i++){
                if (quakes[i].getMag() < 2){
                    magCount[0]++;
                }
                if ((quakes[i].getMag() >= 2) && (quakes[i].getMag() < 4)){
                    magCount[1]++;
                }
                if ((quakes[i].getMag() >= 4) && (quakes[i].getMag() < 6)){
                    magCount[2]++;
                }
                if (quakes[i].getMag() >= 6){
                    magCount[3]++;
                }
            }

            System.out.println(cntTs + " quakes with potential tsunami");
            System.out.println("Biggest magnitude = " + biggestMag + "\n");

            System.out.println("Number of:");
            for (int i = 0; i < 4; i++){
                System.out.println(magLabel[i] + " = " + magCount[i]);
            }
        }
    }

