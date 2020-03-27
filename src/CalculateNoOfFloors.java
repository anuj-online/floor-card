public class CalculateNoOfFloors {

    public static final String INPUT_IS_NOT_A_POSITIVE_INTEGER = "input is not a positive integer";
    public static final String POSITIVE_INTEGER_REGEX = "^[0-9]\\d*$";

    public static void main(String[] args) {

        try{
            if (args != null && args.length == 1 && args[0].matches(POSITIVE_INTEGER_REGEX)) { // if program arguments contain a positive integer

                int noOfDecks = Integer.parseInt(args[0]);
                int noOfCards = 52 * noOfDecks;

                calculate(noOfCards);

            } else {
                System.out.println(INPUT_IS_NOT_A_POSITIVE_INTEGER);
            }
        }
        catch (NumberFormatException e){
            System.out.println(INPUT_IS_NOT_A_POSITIVE_INTEGER);
        }

    }

    private static void calculate(int noOfCards) {

        int noOfPossibleFloors = getNoOfPossibleFloors(noOfCards);

        System.out.println("with " + noOfCards + " cards. I can make " + noOfPossibleFloors + (noOfPossibleFloors > 0 ? " floors" : " floor"));
    }

    // this method can be used in case the problem is for any given number of cards ( positive integer) then for 0,1,2 cards, special handling is required
    private static int getNoOfPossibleFloors(int noOfCards) {
        if (noOfCards < 2) return 0;
        else if (noOfCards == 2) return 1;
        return noOfFloors(noOfCards);
    }


    public static int noOfFloors(int noOfCards) {
        int i = 2;

        while (true) {

            int closest = ((3 * (i * i)) + i) / 2;

            if (noOfCards == closest) {

                return i;

            } else if (noOfCards < closest) {

                return i - 1;

            } else {

                i++;
            }

        }

    }
}
