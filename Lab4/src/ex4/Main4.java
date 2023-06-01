package ex4;

public class Main4 {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(6);

        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
        System.out.println();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("Stack after pushing elements");
        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
        System.out.println();

        System.out.println("Get top element without removing: " + stack.top());
        System.out.println("Stack size: " + stack.size());
        System.out.println();

        System.out.println("Stack elements:");
        while (!stack.isEmpty())
            System.out.println(stack.pop());

        System.out.println();
        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
        System.out.println();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        System.out.println("Stack after pushing more elements than initial capacity can contain");
        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
        System.out.println();

        System.out.println("Stack elements:");
        while (!stack.isEmpty())
            System.out.println(stack.pop());

        System.out.println();

        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("Stack size: " + stack.size());
    }
}
