package src.lab3;

public class Main1 {
    public static void main(String[] args) {
        OneWayLinkedListWithHead<String> list = new OneWayLinkedListWithHead<>();

        //Add
        list.add("Piotr");
        list.add("Mateusz");
        list.add("Jan");
        list.add("Adam");
        list.add("Anna");
        list.add("Bartek");
        System.out.println("List of names:");
        list.display();

        // Insert
        list.insert(0, "Pawel");
        list.insert(list.size(), "Agnieszka");
        System.out.println("List of names after insertion:");
        list.display();

        //Set
        list.set(0, "Daria");
        list.set(3, "Pawel");
        System.out.println("List after setting new names:");
        list.display();

        //IndexOf
        System.out.println("Get indexes of");
        System.out.println("Daria: " + list.indexOf("Daria"));
        System.out.println("Adam: " + list.indexOf("Adam"));
        System.out.println("Wrong data: " + list.indexOf("Wrong data"));
        System.out.println();

        //Contains
        System.out.println("Check if list contains elements");
        System.out.println("Adam: " + list.contains("Adam"));
        System.out.println("Daria: " + list.contains("Daria"));
        System.out.println("Andrzej: " + list.contains("Andrzej"));
        System.out.println();

        //Get
        System.out.println("Get element");
        System.out.println(list.get(1));
        System.out.println(list.get(12));
        System.out.println();

        //Remove elements by position
        System.out.println("Removed element: " + list.removePos(3));
        System.out.println("Removed element: " + list.removePos(2));
        System.out.println("List after removing by position:");
        list.display();

        //Add new name
        list.add("Maria");
        System.out.println("List after adding new names:");
        list.display();

        //Remove elements by value
        System.out.println("Is Piotr removed: " + list.removeVal("Piotr"));
        System.out.println("Is Daria removed: " + list.removeVal("Daria"));
        System.out.println("List after removing by value:");
        list.display();

        //Remove elements by using "getEl"
        System.out.println("Removed: " + list.removeElem(list.getEl("Anna")));
        System.out.println("Removed: " + list.removeElem(list.getEl("Adam")));
        System.out.println("List after removing by 'getEl':");
        list.display();

        //Remove first elements
        System.out.println("Removed: " + list.removeFirst());
        System.out.println("Removed: " + list.removeFirst());
        System.out.println("List after removing two first elements:");
        list.display();

        //Clear, isEmpty and size
        System.out.println("Check if list is empty: " + list.isEmpty());
        System.out.println("Size of list: " + list.size());
        list.clear();
        System.out.println("List after clearing:");
        list.display();

        //isEmpty and size
        System.out.println("Check if list is empty: " + list.isEmpty());
        System.out.println("Size of list: " + list.size());
    }
}
