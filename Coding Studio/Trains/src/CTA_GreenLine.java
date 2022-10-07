public class CTA_GreenLine {

    public static void main(String[] args) {
        // TrainLine object for the south-bound direction of the CTA Green Line
        TrainLine greenLineSB = new TrainLine();
        // Delete the Ridgeland station from Green Line
        greenLineSB.delete("Ridgeland");
        // Print the Green Line after the deletion
        System.out.println(greenLineSB.toString());
    }

}
