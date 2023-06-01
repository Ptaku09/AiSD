import java.util.Comparator;

public class CompYear implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getYearOfBirth() > o2.getYearOfBirth())
            return 1;
        else if (o1.getYearOfBirth() == o2.getYearOfBirth())
            return 0;

        return -1;
    }
}
