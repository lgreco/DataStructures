public class CTA_GreenLine {

    public static void main(String[] args) {

        TrainLine greenLineSB = new TrainLine();

        greenLineSB.delete("Ridgeland");

        System.out.println(greenLineSB.toString());
    }

}
