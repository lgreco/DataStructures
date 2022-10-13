public class CTA_BrownLine {

    public static void main(String[] args) {

        TrainLine brownLine = new TrainLine();
        brownLine.addStation("Kimball");
        brownLine.addStation("Francisco");
        brownLine.addStation("Rockwell");
        brownLine.addStation("Western");
        brownLine.addStation("Damen");
        brownLine.insertBefore("Francisco", "Kedzie");

        System.out.println(brownLine);

        brownLine.delete("Francisco");

        System.out.println(brownLine.toString());

    }

}
