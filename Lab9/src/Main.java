import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        int n = 1;

        while (n != 0) {
            System.out.println("1. Insert element");
            System.out.println("2. Preorder walk");
            System.out.println("3. Inorder walk");
            System.out.println("4. Postorder walk");
            System.out.println("5. Search element");
            System.out.println("6. Delete element");
            System.out.println("7. Get height");
            System.out.println("8. Get number of nodes");
            System.out.println("9. Get number of leaves");
            System.out.println("10. Display by level");
            System.out.println("11. Find successor");
            System.out.println("12. Find predecessor");
            System.out.println("13. Find minimum");
            System.out.println("14. Find maximum");
            System.out.println("15. Calculate height for each subtree *PRINT TREE TO SEE RESULTS*");
            System.out.println("16. Calculate number of nodes for each subtree *PRINT TREE TO SEE RESULTS*");
            System.out.println("17. Print tree *Pattern: (value, subtree_height (-1 -> unset), subtree_num_of_nodes (-1 -> unset))*");
            System.out.println("0. Exit");
            System.out.println();
            System.out.println("Enter your choice: ");

            n = scanner.nextInt();
            System.out.println();

            switch (n) {
                case 1 -> {
                    System.out.println("Enter the element: ");
                    int element = scanner.nextInt();
                    bst.insert(element);
                    System.out.println();
                }

                case 2 -> {
                    bst.preOrderWalk();
                    System.out.printf("%n%n");
                }

                case 3 -> {
                    bst.inOrderWalk();
                    System.out.printf("%n%n");
                }

                case 4 -> {
                    bst.postOrderWalk();
                    System.out.printf("%n%n");
                }

                case 5 -> {
                    System.out.println("Enter the element: ");
                    int element = scanner.nextInt();
                    System.out.printf("Founded element: %-5d%n%n", bst.find(element));
                }

                case 6 -> {
                    System.out.println("Enter the element: ");
                    int element = scanner.nextInt();
                    bst.delete(element);
                    System.out.println();
                }

                case 7 -> System.out.printf("Height: %-5d%n%n", bst.getHeight());

                case 8 -> System.out.printf("Number of nodes: %-5d%n%n", bst.getNumberOfNodes());

                case 9 -> System.out.printf("Number of leaves: %-5d%n%n", bst.getNumberOfLeafNodes());

                case 10 -> {
                    bst.displayByLevel();
                    System.out.printf("%n%n");
                }

                case 11 -> {
                    System.out.println("Enter the element: ");
                    int element = scanner.nextInt();
                    System.out.printf("Successor: %-5d%n%n", bst.successor(element));
                }

                case 12 -> {
                    System.out.println("Enter the element: ");
                    int element = scanner.nextInt();
                    System.out.printf("Predecessor: %-5d%n%n", bst.predecessor(element));
                }

                case 13 -> System.out.printf("Minimum: %-5d%n%n", bst.getMin());

                case 14 -> System.out.printf("Maximum: %-5d%n%n", bst.getMax());

                case 15 -> bst.calculateHeightForEachSubtree();

                case 16 -> bst.calculateNumberOfNodesForEachSubtree();

                case 17 -> bst.drawTree();

                default -> n = 0;
            }
        }
    }
}
