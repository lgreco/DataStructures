public class TrainPlatform {

    String presentStation;
    String nextStation;

    public TrainPlatform(String presentStation) {
        this.presentStation = presentStation;
        this.nextStation = null;
    }

    public void setNextStation(String nextStation) {
        this.nextStation = nextStation;
    }

}
