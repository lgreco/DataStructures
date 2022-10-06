public class CTA_RedLine_SB {

    public static void main(String[] args) {

        TrainLine redLine = new TrainLine();
        redLine.addStation("Howard");
        redLine.addStation("Jarvis");
        redLine.addStation("Morse");
        redLine.addStation("Loyola");
        redLine.addStation("Granville");
        redLine.addStation("Thorndale");
        redLine.addStation("Bryn Mawr");
        redLine.addStation("Berwyn");
        redLine.addStation("Argyle");
        redLine.addStation("Lawrence");
        redLine.addStation("Wilson");
        redLine.addStation("Sheridan");
        redLine.addStation("Addison");
        redLine.addStation("Belmont");
        redLine.addStation("Fullerton");
        redLine.addStation("North/Clybourn");
        redLine.addStation("Clark/Division");
        redLine.addStation("Chicago");
        redLine.addStation("Grand");
        redLine.addStation("Lake");
        redLine.addStation("Monroe");
        redLine.addStation("Jackson");
        redLine.addStation("Harrison");
        redLine.addStation("Roosevelt");
        redLine.addStation("Cermak-Chinatown");
        redLine.addStation("Sox-35th");
        redLine.addStation("47th");
        redLine.addStation("Garfield");
        redLine.addStation("63rd");
        redLine.addStation("69th");
        redLine.addStation("79th");
        redLine.addStation("87th");
        redLine.addStation("95th/Dan Ryan");

        redLine.insertBefore("Irakliotis", "Davis");
    }

}
