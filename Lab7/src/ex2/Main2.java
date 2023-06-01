package ex2;

import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = createArray(5000);
        int searches = 1000;
        double comparisonsLinear = 0;
        double comparisonsBinary = 0;
        double comparisonsFoundedLinearAverage = 0;
        double comparisonsFoundedBinaryAverage = 0;
        double comparisonsMissedLinearAverage = 0;
        double comparisonsMissedBinaryAverage = 0;
        int missedLinear = 0;
        int missedBinary = 0;
        int foundedLinear = 0;
        int foundedBinary = 0;

        Searching searching = new Searching(array);

        for (int i = 0; i < searches; i++) {
            int value = random.nextInt(1, 10000);
            int linear = searching.linearSearch(value);
            int binary = searching.binarySearch(value);

            if (linear != -1) {
                foundedLinear++;
                comparisonsLinear += linear;
                comparisonsFoundedLinearAverage += linear;
            } else {
                missedLinear++;
                comparisonsLinear += array.length;
                comparisonsMissedLinearAverage += array.length;
            }

            if (searching.isFoundedBinary()) {
                foundedBinary++;
                comparisonsBinary += binary;
                comparisonsFoundedBinaryAverage += binary;
            } else {
                missedBinary++;
                comparisonsBinary += binary;
                comparisonsMissedBinaryAverage += binary;
            }
        }

        System.out.println("Linear search:");
        showResults(foundedLinear, comparisonsFoundedLinearAverage, missedLinear, comparisonsMissedLinearAverage, comparisonsLinear, searches);

        System.out.println("Binary search:");
        showResults(foundedBinary, comparisonsFoundedBinaryAverage, missedBinary, comparisonsMissedBinaryAverage, comparisonsBinary, searches);
    }

    private static int[] createArray(int n) {
        Random random = new Random();
        int[] result = new int[n];

        for (int i = 0; i < n; i++)
            result[i] = random.nextInt(1, 10000);

        return result;
    }

    private static void showResults(int founded, double comparisonsFoundedAverage, int missed, double comparisonsMissedAverage, double comparisons, int searches) {
        System.out.println("Founded: " + founded);
        System.out.println("Average comparisons - founded: " + Math.round(comparisonsFoundedAverage / founded * 100) / 100.0);
        System.out.println("Missed: " + missed);
        System.out.println("Average comparisons - missed: " + Math.round(comparisonsMissedAverage / missed * 100) / 100.0);
        System.out.println("Total average comparisons: " + Math.round(comparisons / searches * 100) / 100.0);
        System.out.println();
    }
}
