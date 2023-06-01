package ex3;

public class Main3 {
    public static void main(String[] args) {
        TwoWayLinkedListWithHead<String> list1 = new TwoWayLinkedListWithHead<>();
        TwoWayLinkedListWithHead<String> list2 = new TwoWayLinkedListWithHead<>();
        TwoWayLinkedListWithHead<String> list3 = new TwoWayLinkedListWithHead<>();

        list1.add("This");
        list1.add("text");
        list1.add("comes");
        list1.add("from");
        list1.add("list1!");
        System.out.println("List1:");
        list1.display();
        System.out.println();

        list2.add("This");
        list2.add("text");
        list2.add("comes");
        list2.add("from");
        list2.add("list2!");
        System.out.println("List2:");
        list2.display();
        System.out.println();

        list3.add("This");
        list3.add("is");
        list3.add("list3!");
        System.out.println("List3:");
        list3.display();
        System.out.println();

        list1.appendList(list2);
        System.out.println("List1 after appending list2:");
        list1.display();
        System.out.println();

        list1.appendList(5, list3);
        System.out.println("List1 after appending list3 before fifth index:");
        list1.display();
    }
}
