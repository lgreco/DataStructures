import java.util.ArrayList;

public class CTAImplementation {


    private static final String ALL_STATIONS_CSV =
            "https://raw.githubusercontent.com/lgreco/DataStructures/master/data/stations.csv";
    private static final String RED_LINE_SOUTHBOUND_TXT =
            "https://raw.githubusercontent.com/lgreco/DataStructures/master/data/RedLineSouthBound.txt";
    private static final String BROWN_LINE_SOUTHBOUND_TXT =
            "https://raw.githubusercontent.com/lgreco/DataStructures/master/data/BrownLineSouthBound.txt";


    public static void main(String[] args) {
        ArrayList<CTAStation> stations = CTAUtilities.pullCTAData("https://raw.githubusercontent.com/lgreco/DataStructures/master/data/stations.csv");
        System.out.println(stations.size());
        for (CTAStation s:stations
             ) {
            System.out.println(s.toString());
        }
    }
}  //class CTAImplementation