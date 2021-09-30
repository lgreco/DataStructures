public class EnumDemo {

    Season season;

    public EnumDemo(Season season) {
        this.season = season;
    }

    public void seasonFeelings() {
        switch (season) {
            case WINTER:
                System.out.println("Winter is lovely.");
                break;
            case SPRING:
                System.out.println("Spring is nice");
                break;
            case SUMMER:
                System.out.println("Summer is meh");
                break;
            case AUTUMN:
                System.out.println("Autumn is the best season");
                break;
        }
    }

    public static void main(String[] args) {
        EnumDemo season1 = new EnumDemo(Season.SUMMER);
        season1.seasonFeelings();
    }
}