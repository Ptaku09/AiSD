package Ex2;

public class Main2 {
    public static void main(String[] args) {
        ManagePeople manager = new ManagePeople();

        System.out.println("n = 4; k = 5");
        manager.circle(4, 5);

        System.out.println("n = 10; k = 1");
        manager.circle(10, 1);

        System.out.println("n = 6; k = 5");
        manager.circle(6, 5);

        System.out.println("n = 100; k = 15");
        manager.circle(100, 15);

        System.out.println("n = 12; k = 16");
        manager.circle(12, 16);
    }
}
