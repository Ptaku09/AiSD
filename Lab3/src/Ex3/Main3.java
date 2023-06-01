package Ex3;

public class Main3 {
    public static void main(String[] args) {
        OneWayList<Integer> list = new OneWayList<>();

        System.out.print("Size of empty list: ");
        System.out.println(list.size());
        System.out.println();

        list.add(5);
        list.add(14);
        list.add(3);
        list.add(20);
        list.add(1);
        list.add(0);
        list.add(17);
        list.add(18);

        System.out.println("Display list:");
        list.display();
        System.out.printf("%n%n");

        System.out.println("Display list in reversed order:");
        list.displayReverse();
        System.out.printf("%n%n");

        //Copy list and add new element
        OneWayList<Integer> newList = list.copy();
        newList.add(2);
        newList.add(12);
        newList.add(34);
        newList.add(28);

        System.out.println("Display copy of list after adding new elements:");
        newList.display();
        System.out.printf("%n%n");

        System.out.println("Display copy of list after adding new element in reversed order:");
        newList.displayReverse();
        System.out.printf("%n%n");

        System.out.println("Display list to see if list was copied properly:");
        list.display();
        System.out.printf("%n%n");

        System.out.print("Sum of keys (list): ");
        System.out.println(list.sumOfKeys());

        System.out.print("Sum of keys (copy): ");
        System.out.println(newList.sumOfKeys());

        System.out.print("Size (list): ");
        System.out.println(list.size());

        System.out.print("Size (copy): ");
        System.out.println(newList.size());
    }
}
