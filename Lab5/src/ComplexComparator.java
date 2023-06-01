import java.util.Comparator;

public class ComplexComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int surnameComp = o1.getSurname().compareTo(o2.getSurname());

        if (surnameComp == 0) {
            int nameComp = o1.getName().compareTo(o2.getName());

            if (nameComp == 0)
                return Integer.compare(o1.getYearOfBirth(), o2.getYearOfBirth());

            return nameComp;
        }

        return surnameComp;
    }
}
