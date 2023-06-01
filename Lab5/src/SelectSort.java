import java.util.Comparator;

public class SelectSort implements PeopleSorter {
    private final Comparator<Person> _comparator;

    public SelectSort(Comparator<Person> comparator) {
        _comparator = comparator;
    }

    @Override
    public Person[] sort(Person[] tab) {
        for (int i = 0; i < tab.length - 1; i++) {
            int smallest = i;

            for (int j = i + 1; j < tab.length; j++) {
                if (_comparator.compare(tab[j], tab[smallest]) < 0)
                    smallest = j;
            }

            Person temp = tab[smallest];
            tab[smallest] = tab[i];
            tab[i] = temp;
        }

        return tab;
    }
}
