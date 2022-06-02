public class Fast {
    /*
    Can you print this? for SIZE = 6

    #
    ####
    #########
    ################
    #########################
    ####################################
     */

    public static final int SIZE = 10;

    public static void main(String[] args) {
        for (int i=1; i <= SIZE; i++) {
            for (int j = 1; j <= i*i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
