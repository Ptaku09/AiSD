package ex2;

public class Main2 {
    public static void main(String[] args) {
        ListStack<String> stack = new ListStack<>();

        System.out.println("Check if stack is empty:");
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Size: " + stack.size());
        System.out.println();

        //Add elements to stack
        stack.push("Mateusz");
        System.out.println("Added: Mateusz");
        stack.push("Piotr");
        System.out.println("Added: Piotr");
        stack.push("Pawel");
        System.out.println("Added: Pawel");
        stack.push("Adam");
        System.out.println("Added: Adam");
        stack.push("Anna");
        System.out.println("Added: Anna");
        stack.push("Maria");
        System.out.println("Added: Maria");
        System.out.println();

        System.out.println("Check if elements were added correctly:");
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Size: " + stack.size());
        System.out.println();

        System.out.println("Get top element without removing:");
        System.out.println(stack.top());
        System.out.println();

        System.out.println("Check if element was not removed:");
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Size: " + stack.size());
        System.out.println();

        System.out.println("Pop elements:");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println();

        System.out.println("Check if elements were collected correctly:");
        System.out.println("Is empty: " + stack.isEmpty());
        System.out.println("Size: " + stack.size());
    }
}
