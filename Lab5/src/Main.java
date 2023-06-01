import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person[] tab = new Person[10];
        Person p1 = new Person("Jan", "Kowalski", 1986);
        Person p2 = new Person("Adam", "Kowalski", 1963);
        Person p3 = new Person("Piotr", "Smith", 2000);
        Person p4 = new Person("Anna", "Nowak", 1999);
        Person p5 = new Person("Anna", "Wisniewska", 2003);
        Person p6 = new Person("Adam", "Borek", 1950);
        Person p7 = new Person("Robert", "Lewandowski", 1963);
        Person p8 = new Person("Jakub", "Cash", 1995);
        Person p9 = new Person("Anna", "Nowak", 2005);
        Person p10 = new Person("Patrycja", "Zielinska", 1970);

        tab[0] = p1;
        tab[1] = p2;
        tab[2] = p3;
        tab[3] = p4;
        tab[4] = p5;
        tab[5] = p6;
        tab[6] = p7;
        tab[7] = p8;
        tab[8] = p9;
        tab[9] = p10;

        System.out.println("Default array:");
        display(tab);

        Comparator<Person> compName = new CompName();
        Comparator<Person> compSurname = new CompSurname();
        Comparator<Person> compYear = new CompYear();
        Comparator<Person> complexComparator = new ComplexComparator();
        CompoundComparator compoundComparator = new CompoundComparator();
        compoundComparator.addComparator(compName);
        compoundComparator.addComparator(compSurname);
        compoundComparator.addComparator(compYear);

        System.out.println("Sorted by insert sort and year comparator");
        InsertSort insertSort = new InsertSort(compYear);
        insertSort.sort(tab);
        display(tab);

        System.out.println("Sorted by select sort and surname comparator");
        SelectSort selectSort = new SelectSort(compSurname);
        selectSort.sort(tab);
        display(tab);

        System.out.println("Sorted by bubble sort and name comparator");
        BubbleSort bubbleSort = new BubbleSort(compName);
        bubbleSort.sort(tab);
        display(tab);

        System.out.println("Sorted by insert sort and compound comparator (name -> surname -> year)");
        InsertSort insertSort2 = new InsertSort(compoundComparator);
        insertSort2.sort(tab);
        display(tab);

        System.out.println("Sorted by select sort and complex comparator (surname -> name -> year)");
        SelectSort selectSort2 = new SelectSort(complexComparator);
        selectSort2.sort(tab);
        display(tab);
    }

    public static void display(Person[] tab) {
        for (Person p : tab)
            System.out.println(p);

        System.out.println();
    }
}
