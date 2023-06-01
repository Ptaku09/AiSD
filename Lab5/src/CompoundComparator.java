import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator implements Comparator<Person> {
    private final List<Comparator<Person>> _comparators = new ArrayList<>();

    public void addComparator(Comparator<Person> comparator) {
        _comparators.add(comparator);
    }

    @Override
    public int compare(Person o1, Person o2) {
        int result = 0;

        for (Comparator<Person> comp : _comparators) {
            result = comp.compare(o1, o2);

            if (result != 0)
                break;
        }

        return result;
    }
}
