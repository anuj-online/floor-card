import java.util.stream.IntStream;

public class MyClass {

    public static void main(String[] args) throws Exception {

        int noOfDecks = 6;
        int noOfCards = 52 * noOfDecks;
        IntStream intStream = IntStream.rangeClosed(0, noOfCards);

        intStream.forEach(value -> {
            try {
                doIt(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void doIt(int noOfCards) throws Exception {

//        System.out.println("no of cards available : " + noOfCards);

        int noOfPossibleFloors = getNoOfPossibleFloors(noOfCards);

        System.out.println("with " + noOfCards + " cards. I can make " + noOfPossibleFloors + " floors");
    }

    private static int getNoOfPossibleFloors(int noOfCards) throws Exception {
        return noOfCards > 2 ? noOfFloors(noOfCards) : 0;
    }


    public static int noOfFloors(int noOfCards) throws Exception {
        int i = 2;

        while (true) {

//            System.out.print("iterating value  : " + i);

            int closest = ((3 * (i * i)) + i) / 2;

//            System.out.println(" :: found closest : " + closest);

//            Thread.sleep(100L);

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
