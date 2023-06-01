import java.util.Comparator;

public class InsertSort implements PeopleSorter {
    private final Comparator<Person> _comparator;

    public InsertSort(Comparator<Person> comparator) {
        _comparator = comparator;
    }

    @Override
    public Person[] sort(Person[] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = i; j > 0 && _comparator.compare(tab[j], tab[j - 1]) < 0; j--) {
                Person temp = tab[j];
                tab[j] = tab[j - 1];
                tab[j - 1] = temp;
            }
        }

        return tab;
    }
}
