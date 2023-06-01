public class Main {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();

        //insert data
        rbt.insert(2);
        rbt.insert(3);
        rbt.insert(5);
        rbt.insert(12);
        rbt.insert(14);
        rbt.insert(1);
        rbt.insert(6);
        rbt.insert(13);
        rbt.insert(15);

        System.out.println("---------------- FIND VALUES ----------------");
        System.out.println("Find 2 (present): " + rbt.find(2));
        System.out.println("Find 123 (absent): " + rbt.find(123));
        System.out.println();

        System.out.println("---------------- INORDER WALK ----------------");
        rbt.inOrderWalk();
        System.out.printf("%n%n");

        System.out.println("---------------- DISPLAY BY LEVEL ----------------");
        rbt.displayByLevel();
        System.out.printf("%n%n");

        System.out.println("---------------- TREE DATA ----------------");
        System.out.println("Height: " + rbt.getHeight());
        System.out.println("Left subtree height: " + rbt.getLeftSubtreeHeight());
        System.out.println("Right subtree height: " + rbt.getRightSubtreeHeight());
        System.out.println("Number of nodes: " + rbt.getNumberOfNodes());
        System.out.println("Left subtree number of nodes: " + rbt.getLeftSubtreeNumberOfNodes());
        System.out.println("Number of nodes: " + rbt.getRightSubtreeNumberOfNodes());
        System.out.println();

        rbt.setSubtreeHeightsForEachNode();
        rbt.setSubtreeNumberOfNodesForEachNode();

        System.out.println("---------------- INORDER WITH ALL NODE DATA ----------------");
        System.out.println("Template -> [value, color, left subtree height, right subtree height, left subtree number of nodes, right subtree number of nodes]");
        rbt.inOrderWalkWithAllData();
        System.out.printf("%n%n");

        System.out.println("---------------- DRAW TREE ----------------");
        rbt.drawTree();
    }
}
