public class CTA_RedLine {

    public static void main(String[] args) {

        // Southbound (SB) stations
        TrainLine redLineSB = new TrainLine();
        redLineSB.addStation("Howard");
        redLineSB.addStation("Jarvis");
        redLineSB.addStation("Morse");
        redLineSB.addStation("Loyola");
        redLineSB.addStation("Granville");
        redLineSB.addStation("Thorndale");
        redLineSB.addStation("Bryn Mawr");
        redLineSB.addStation("Berwyn");
        redLineSB.addStation("Argyle");
        redLineSB.addStation("Lawrence");
        redLineSB.addStation("Wilson");
        redLineSB.addStation("Sheridan");
        redLineSB.addStation("Addison");
        redLineSB.addStation("Belmont");
        redLineSB.addStation("Fullerton");
        redLineSB.addStation("North/Clybourn");
        redLineSB.addStation("Clark/Division");
        redLineSB.addStation("Chicago");
        redLineSB.addStation("Grand");
        redLineSB.addStation("Lake");
        redLineSB.addStation("Monroe");
        redLineSB.addStation("Jackson");
        redLineSB.addStation("Harrison");
        redLineSB.addStation("Roosevelt");
        redLineSB.addStation("Cermak-Chinatown");
        redLineSB.addStation("Sox-35th");
        redLineSB.addStation("47th");
        redLineSB.addStation("Garfield");
        redLineSB.addStation("63rd");
        redLineSB.addStation("69th");
        redLineSB.addStation("79th");
        redLineSB.addStation("87th");
        redLineSB.addStation("95th/Dan Ryan");

        redLineSB.insertBefore("Irakliotis", "Davis");
    }

}
