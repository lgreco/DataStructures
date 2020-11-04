/**
 * USE THIS JAVADOC SECTION TO TYPE YOUR ANSWERS FOR THE FIRST DELIVERABLE
 *
 */
public class Hangar {
    public void C172(Builder builder) {
        builder.setTailNumber("N969RR");
        builder.setWings(Wings.HIGH);
        builder.setFuel(Fuel.AVGAS);
        builder.setEngines(1);
    }
    public static void main(String[] args){
        Hangar ourHangar = new Hangar();
        AirplaneBuilder builder = new AirplaneBuilder();
        ourHangar.C172(builder);
        Airplane mySkyhawk = builder.fetch();
        String m = mySkyhawk.getManufacturer();
        System.out.println("Can you explain this value for the airplanes manufacturer? "+m);
    }
}