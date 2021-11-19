
/**
 * Defines recursive operations to be performed with money.
 *
 * @author Mason Rein
 * @version 11.0.12
 */
public class Money {
    /**
     * Determines the amount of money in an array list of different cent values.
     *
     * @param cents ArrayList of cent values to be used
     * @return The total amount of money in dollars found in the array
     */
    public static double countTotal(int[] cents) {
        if (cents.length <= 0) {
            return 0;
        } else {
            int[] newArray = new int[cents.length - 1];
            for (int i = 1; i < cents.length; ++i) {
                newArray[i - 1] = cents[i];
            }
            return cents[0] * 0.01 + countTotal(newArray);
        }
    }

    /**
     * Finds the difference in dollars between the cost of an item and the cents contained in an ArrayList.
     *
     * @param cost  Double for the cost of an item in dollars
     * @param cents ArrayList of cent values of a customer
     * @return The difference in dollars between the cost of an item and money held by customer
     */
    public static double findDifference(double cost, int[] cents) {
        if (cents.length <= 0) {
            return cost;
        } else {
            int[] newArray = new int[cents.length - 1];
            for (int i = 1; i < cents.length; ++i) {
                newArray[i - 1] = cents[i];
            }
            return findDifference(cost, newArray) - cents[0] * 0.01;
        }
    }

    /**
     * Determines the minimum amount of coins to make a certain amount of cents.
     *
     * @param centAmount The amount of cents as an int
     * @return The amount of coins required to create that certain amount of cents
     */
    public static int makeChange(int centAmount) {
        int coinAmount = 0;
        if (centAmount >= 25) {
            coinAmount = centAmount / 25;
            return coinAmount + makeChange(centAmount - coinAmount * 25);
        } else if (centAmount >= 10) {
            coinAmount = centAmount / 10;
            return coinAmount + makeChange(centAmount - coinAmount * 10);
        } else if (centAmount >= 5) {
            coinAmount = centAmount / 5;
            return coinAmount + makeChange(centAmount - coinAmount * 5);
        } else {
            return centAmount;
        }
    }

    /**
     * Determines the minimum amount of coins to make a certain amount of cents for a given array of coints.
     *
     * @param centAmount Amount of cents that must be broken down
     * @param coinTypes  The types of coins that can be used to be added together to make the total amount of cents
     * @return The least amount of coins using greedy method to get to the total
     */
    public static int makeChange(int centAmount, int[] coinTypes) {
        if (coinTypes.length <= 0) {
            return 0;
        } else {
            int coinAmount = centAmount / coinTypes[0];
            int[] newArray = new int[coinTypes.length - 1];
            for (int i = 1; i < coinTypes.length; ++i) {
                newArray[i - 1] = coinTypes[i];
            }
            return coinAmount + makeChange(centAmount - coinAmount * coinTypes[0], newArray);
        }
    }
}
