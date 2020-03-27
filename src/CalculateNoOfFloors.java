public class CalculateNoOfFloors {

    public static final String INPUT_IS_NOT_A_POSITIVE_INTEGER = "input is not a positive integer";
    public static final String POSITIVE_INTEGER_REGEX = "^[0-9]\\d*$";
    public static final int NO_OF_CARDS_IN_DECK = 52;

    public static void main(String[] args) {

        try {
            if (args != null && args.length == 1 && args[0].matches(POSITIVE_INTEGER_REGEX)) { // if program arguments contain a positive integer

                int noOfDecks = Integer.parseInt(args[0]);
                int noOfCards = NO_OF_CARDS_IN_DECK * noOfDecks;

                calculate(noOfCards);

            } else {
                System.out.println(INPUT_IS_NOT_A_POSITIVE_INTEGER);
            }
        } catch (NumberFormatException e) {
            System.out.println(INPUT_IS_NOT_A_POSITIVE_INTEGER);
        }

    }

    private static void calculate(int noOfCards) {

        int noOfPossibleFloors = noOfFloors(noOfCards);

        System.out.println("with " + noOfCards + " cards. I can make " + noOfPossibleFloors + (noOfPossibleFloors > 0 ? " floors" : " floor"));
    }


    public static int noOfFloors(int noOfCards) {
        int noOfFloors = 0;

        while (true) {

            int closest = ((3 * (noOfFloors * noOfFloors)) + noOfFloors) / 2;

            if (noOfCards == closest) {

                return noOfFloors;

            } else if (noOfCards < closest) {

                return noOfFloors - 1;

            } else {

                noOfFloors++;
            }

        }

    }
}
