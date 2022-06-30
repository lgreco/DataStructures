public class SouthBoundLincoln {


    public static void main(String[] args) {

        TrainPlatform chi = new TrainPlatform("Chicago");
        TrainPlatform sum = new TrainPlatform("Summit");
        TrainPlatform jol = new TrainPlatform("Joliet");
        TrainPlatform pon = new TrainPlatform("Pontiac");
        TrainPlatform dwi = new TrainPlatform("Dwight");
        TrainPlatform blo = new TrainPlatform("Bloomington/Normal");
        TrainPlatform lcn = new TrainPlatform("Lincoln");
        TrainPlatform spi = new TrainPlatform("Springfield");
        TrainPlatform crl = new TrainPlatform("Carlinville");
        TrainPlatform alt = new TrainPlatform("Alton");
        TrainPlatform atn = new TrainPlatform("St. Louis");

        chi.setNextStation("Summit");
        sum.setNextStation("Joliet");
        jol.setNextStation("Pontia");
    }


}
