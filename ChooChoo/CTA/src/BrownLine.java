
/**
 * An implementation class for Brown Line
 */
public class BrownLine {

    public static void main(String[]args){

        // Define a few stations
        CTAStation kimball=new CTAStation("Kimball");
        CTAStation kedzie=new CTAStation("Kedzie");
        CTAStation francisco=new CTAStation("Francisco");
        CTAStation merchandise=new CTAStation("Merchandise Mart");
        CTAStation wells=new CTAStation("Wells");
        CTAStation quincy=new CTAStation("Quincy");
        CTAStation clarkLake=new CTAStation("Clark and Lake");

        // Setup a CTA Line object with Kimball as its head station
        CTALine brownLine=new CTALine(kimball);

        // Add the stations to the Brown Line
        brownLine.addStation(kedzie,kimball,true);
        brownLine.addStation(francisco,kedzie,true);
        brownLine.addStation(merchandise,francisco,true);
        brownLine.addStation(wells,merchandise,false);
        brownLine.addStation(quincy,wells,false);
        brownLine.addStation(clarkLake,quincy,false);
        brownLine.addStation(quincy,clarkLake,false);

        // Connect the Clark/Lake station to the Merc station
        brownLine.connect(clarkLake,merchandise);

        // Traverse the line and report
        brownLine.displayCTALine();
    }

}
