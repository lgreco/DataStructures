/**
 * Implementation class for FixedWing aircraft.
 */

public class COMP271_Flyers {

    public static void main(String[] args) {

        /*
        Let's consider a small flight school with 4 training FixedWing aircraft.
        Three airplanes are piston-powered, one is a small jet. Can we manage
        the airplane information in a single array of "dissimilar" objects? Yes
        we can!

        The array below is typed as FixedWing. But then it's populated with
        objects PistonAirplane and TurbineAirplane. It's fine, because these
        objects are extensions of the FixedWing class.
         */

        FixedWing leoFligfhtSchool[] = new FixedWing[4];

        leoFligfhtSchool[0] = new PistonAirplane(1, "N4335K", "Archer");
        leoFligfhtSchool[1] = new PistonAirplane(1, "N866US", "Diamond Star");
        leoFligfhtSchool[2] = new TurbineAirplane(1, "N9LI", "Vision Jet");
        leoFligfhtSchool[3] = new PistonAirplane(1, "N5399K", "Skyhawk");

        System.out.printf("\nFleet of aircraft as instantiated with basic constructors.\n\n");
        for (FixedWing aircraft:leoFligfhtSchool) {
            System.out.printf("%s\n\n", aircraft.toString());
        }

        // Let do some mutations of existing objects to complete missing data

        leoFligfhtSchool[0].setModelCode("P28A");
        leoFligfhtSchool[0].setManufacturer("Piper");
        leoFligfhtSchool[0].setYearManufactured(1990);

        leoFligfhtSchool[1].setModelCode("DA40");
        leoFligfhtSchool[1].setManufacturer("Diamond Aircraft");
        leoFligfhtSchool[1].setYearManufactured(2008);

        leoFligfhtSchool[2].setModelCode("SF50");
        leoFligfhtSchool[2].setManufacturer("Cirrus");
        leoFligfhtSchool[2].setYearManufactured(2018);
        TurbineAirplane temporary = (TurbineAirplane) leoFligfhtSchool[2];
        temporary.setTurbineType("turbofan");
        leoFligfhtSchool[2] = temporary;


        leoFligfhtSchool[3].setModelCode("C172S");
        leoFligfhtSchool[3].setManufacturer("Cessna Aviation");
        leoFligfhtSchool[3].setYearManufactured(1986);
        
        System.out.printf("\n\nFleet of aircraft after mutations.\n\n");
        for (FixedWing aircraft:leoFligfhtSchool) {
            System.out.printf("%s\n\n", aircraft.toString());
        }

        /*
        HERES' THE SECOND FLIGHT SCHOOL, FOR THE 6/24/21 ASSIGNMENT
         */

        FixedWing twoSevenOneFlightSchool[] = new FixedWing[2]; // we only need two aircraft

        /*
        First aircraft: 1992 Skyhawk 172SP, single-engine airplane with fixed landing gear,
        tail number N87JA, manufactured by Cessna
         */
        twoSevenOneFlightSchool[0] = new PistonAirplane(1,"N87JA","Skyhawk");
        twoSevenOneFlightSchool[0].setYearManufactured(1992);
        twoSevenOneFlightSchool[0].setManufacturer("Cessna");
        twoSevenOneFlightSchool[0].setModelCode("C172SP");

        /*
        Second aircraft: 2019 Citation M2 jet, code C25A, twin turbofan, with tail number N2RF,
        manufactured by Textron Aviation.
         */
        twoSevenOneFlightSchool[1] = new TurbineAirplane(2,"N2RF", "Citation M2");
        twoSevenOneFlightSchool[1].setYearManufactured(2019);
        twoSevenOneFlightSchool[1].setManufacturer("Textron Aviation");
        twoSevenOneFlightSchool[1].setModelCode("C25A");
        temporary = (TurbineAirplane) twoSevenOneFlightSchool[1];
        temporary.setTurbineType("turbofan");
        leoFligfhtSchool[1] = temporary;

        /*
        Loop to print aircraft for second school
         */
        System.out.printf("\n\nThe fleet for the second flight school is as follows:\n\n");
        for (FixedWing f:twoSevenOneFlightSchool) {
            System.out.printf("%s\n\n",f.toString());
        }
    }

}
