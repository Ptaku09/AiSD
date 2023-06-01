import java.util.Comparator;

public class BubbleSort implements PeopleSorter {
    private final Comparator<Person> _comparator;

    public BubbleSort(Comparator<Person> comparator) {
        _comparator = comparator;
    }

    @Override
    public Person[] sort(Person[] tab) {
        int lastSwap = tab.length - 1;

        while (lastSwap > 0) {
            int end = lastSwap;
            lastSwap = 0;

            for (int i = 0; i < end; i++) {
                if (_comparator.compare(tab[i], tab[i + 1]) > 0) {
                    Person temp = tab[i];

                    while (i < end && _comparator.compare(temp, tab[i + 1]) > 0) {
                        tab[i] = tab[i + 1];
                        i++;
                    }

                    lastSwap = i;
                    tab[i] = temp;
                }
            }
        }

        return tab;
    }
}
