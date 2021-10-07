import java.util.ArrayList;

public class CTAImplementation {
    public static void main(String[] args) {
        ArrayList<CTAStation> stations = CTAUtilities.pullCTAData("https://raw.githubusercontent.com/lgreco/DataStructures/master/data/stations.csv");
        System.out.println(stations.size());
        for (CTAStation s:stations
             ) {
            System.out.println(s.toString());
        }
    }
}  //class CTAImplementation