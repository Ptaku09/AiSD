package Ex2;

import Ex1.OneWayLinkedListWithHead;

public class ManagePeople {
    private final OneWayLinkedListWithHead<Person> list;

    public ManagePeople() {
        this.list = new OneWayLinkedListWithHead<>();
    }

    public void circle(int n, int k) {
        createPeople(n);
        int indexToRemove = k - 1;

        while (n > 1) {
            int valueToAdd = list.indexOf(list.get(indexToRemove));
            System.out.print(list.removePos(indexToRemove).getNumber() + (n != 2 ? ", " : ""));
            indexToRemove = valueToAdd + k - 1;
            n--;
        }

        clearList();
        System.out.printf("%n%n");
    }

    private void createPeople(int n) {
        for (int i = 1; i <= n; i++)
            list.add(new Person(i));
    }

    private void clearList() {
        list.clear();
    }

    public OneWayLinkedListWithHead<Person> getList() {
        return list;
    }
}
