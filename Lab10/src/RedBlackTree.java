import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RedBlackTree {
    static class Node {
        private final int value;
        private boolean isRed;
        private Node left;
        private Node right;
        private int leftSubtreeHeight;
        private int rightSubtreeHeight;
        private int leftSubtreeNumberOfNodes;
        private int rightSubtreeNumberOfNodes;

        public Node(int value) {
            this.value = value;
            this.isRed = true;
            this.left = null;
            this.right = null;
            this.leftSubtreeHeight = -1;
            this.rightSubtreeHeight = -1;
            this.leftSubtreeNumberOfNodes = -1;
            this.rightSubtreeNumberOfNodes = -1;
        }

        public String toStringAllData() {
            return "[" + value + ", " + (isRed ? "r" : "b") + ", " + leftSubtreeHeight + ", " + rightSubtreeHeight + ", " + leftSubtreeNumberOfNodes + ", " + rightSubtreeNumberOfNodes + "]";
        }

        @Override
        public String toString() {
            return value + (isRed ? "r" : "b");
        }
    }

    private Node _root;

    public RedBlackTree() {
        _root = null;
    }

    public void insert(int value) {
        _root = insert(_root, value);
        _root.isRed = false;
    }

    public int find(int value) {
        Node node = search(value);
        return node != null ? node.value : -1;
    }

    public void inOrderWalk() {
        inOrderWalk(_root);
    }

    public void inOrderWalkWithAllData() {
        inOrderWalkWithAllData(_root);
    }

    public void displayByLevel() {
        displayByLevel(_root);
    }

    public int getHeight() {
        return getHeight(_root);
    }

    public int getLeftSubtreeHeight() {
        return getHeight(_root.left);
    }

    public int getRightSubtreeHeight() {
        return getHeight(_root.right);
    }

    public int getNumberOfNodes() {
        return getNumberOfNodes(_root);
    }

    public int getLeftSubtreeNumberOfNodes() {
        return getNumberOfNodes(_root.left);
    }

    public int getRightSubtreeNumberOfNodes() {
        return getNumberOfNodes(_root.right);
    }

    public void setSubtreeHeightsForEachNode() {
        calculateHeightForEachSubtree(_root);
    }

    public void setSubtreeNumberOfNodesForEachNode() {
        calculateNumberOfNodesForEachSubtree(_root);
    }

    public void drawTree() {
        drawTree(_root);
    }

    private Node insert(Node node, int value) {
        if (node == null)
            return new Node(value);

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);

        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);

        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);

        if (isRed(node.left) && isRed(node.right))
            flipColors(node);

        return node;
    }

    private boolean isRed(Node node) {
        if (node == null) return false;
        return node.isRed;
    }

    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.isRed = node.isRed;
        node.isRed = true;

        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.isRed = node.isRed;
        node.isRed = true;

        return x;
    }

    private void flipColors(Node node) {
        node.isRed = !node.isRed;
        node.left.isRed = !node.left.isRed;
        node.right.isRed = !node.right.isRed;
    }

    private Node search(int value) {
        Node node = _root;
        int compare;

        while (node != null && (compare = Integer.compare(value, node.value)) != 0) {
            node = compare < 0 ? node.left : node.right;
        }

        return node;
    }

    private void inOrderWalk(Node node) {
        if (node != null) {
            inOrderWalk(node.left);
            System.out.print(node.value + (node.isRed ? "r" : "b") + " ");
            inOrderWalk(node.right);
        }
    }

    private void inOrderWalkWithAllData(Node node) {
        if (node != null) {
            inOrderWalkWithAllData(node.left);
            System.out.print(node.toStringAllData() + " ");
            inOrderWalkWithAllData(node.right);
        }
    }

    private void displayByLevel(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.print(n + " ");
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private int getNumberOfNodes(Node node) {
        if (node == null) return 0;
        return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
    }

    private void calculateHeightForEachSubtree(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            node.leftSubtreeHeight = getHeight(node.left);
            node.rightSubtreeHeight = getHeight(node.right);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    private void calculateNumberOfNodesForEachSubtree(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            node.leftSubtreeNumberOfNodes = getNumberOfNodes(node.left);
            node.rightSubtreeNumberOfNodes = getNumberOfNodes(node.right);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    private void drawTree(Node root) {
        List<List<String>> lines = new ArrayList<>();
        List<Node> currentlevel = new ArrayList<>();
        List<Node> nextLevel = new ArrayList<>();
        int notNullElements = 1;
        int widest = 0;

        currentlevel.add(root);

        while (notNullElements != 0) {
            List<String> line = new ArrayList<>();
            notNullElements = 0;

            for (Node node : currentlevel)
                if (node == null) {
                    line.add(null);
                    nextLevel.add(null);
                    nextLevel.add(null);
                } else {
                    String currentElement = node.toString();
                    line.add(currentElement);
                    if (currentElement.length() > widest) widest = currentElement.length();

                    nextLevel.add(node.left);
                    nextLevel.add(node.right);

                    if (node.left != null) notNullElements++;
                    if (node.right != null) notNullElements++;
                }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<Node> temp = currentlevel;
            currentlevel = nextLevel;
            nextLevel = temp;
            nextLevel.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);

        for (List<String> line : lines) {
            for (String element : line) {
                if (element == null) element = "";
                float v = perpiece / 2f - element.length() / 2f;
                int gap1 = (int) Math.ceil(v);
                int gap2 = (int) Math.floor(v);

                for (int i = 0; i < gap1; i++)
                    System.out.print(" ");

                System.out.print(element);

                for (int i = 0; i < gap2; i++)
                    System.out.print(" ");
            }

            perpiece /= 2;
            System.out.printf("%n%n");
        }

        System.out.printf("%n%n");
    }
}
