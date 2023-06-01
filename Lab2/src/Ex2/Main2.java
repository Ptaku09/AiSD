package Ex2;

public class Main2 {
    private final static Predicate2<Integer> predicate = arg -> {
        if (arg < 2)
            return false;

        if (arg == 2)
            return true;

        for (int i = 2; i <= Math.sqrt(arg); i++)
            if (arg % i == 0)
                return false;

        return true;
    };

    public static void generateAndDisplayPrimeNumbers(int first, int last) {
        NumberIterator iterator = new NumberIterator(first, last);
        FilteredNumberIterator<Integer> filteredIterator = new FilteredNumberIterator<>(iterator, predicate);

        System.out.println("Range: " + first + " - " + last);

        while (!filteredIterator.isDone()) {
            System.out.println(filteredIterator.current());
            filteredIterator.next();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        generateAndDisplayPrimeNumbers(1, 2);
        generateAndDisplayPrimeNumbers(12, 56);
        generateAndDisplayPrimeNumbers(1, 200);
    }
}
