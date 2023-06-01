import java.util.*;

public class BinarySearchTree {
    static class Node {
        int value;
        int subtreeHeight = -1;
        int subtreeNodes = -1;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        public void setSubtreeHeight(int subtreeHeight) {
            this.subtreeHeight = subtreeHeight;
        }

        public void setSubtreeNodes(int subtreeNodes) {
            this.subtreeNodes = subtreeNodes;
        }

        @Override
        public String toString() {
            return "(" + value + ", " + subtreeHeight + ", " + subtreeNodes + ")";
        }
    }

    private Node _root;

    public BinarySearchTree() {
        _root = null;
    }

    public void insert(int value) {
        _root = insert(_root, value);
    }

    public void preOrderWalk() {
        preOrderWalk(_root);
    }

    public void inOrderWalk() {
        inOrderWalk(_root);
    }

    public void postOrderWalk() {
        postOrderWalk(_root);
    }

    public int find(int value) {
        Node node = search(value);
        return node == null ? -1 : node.value;
    }

    public int getMin() {
        if (_root == null) throw new NoSuchElementException();
        Node node = getMin(_root);
        return node.value;
    }

    public int getMax() {
        if (_root == null) throw new NoSuchElementException();
        Node node = getMax(_root);
        return node.value;
    }

    public int getHeight() {
        return getHeight(_root);
    }

    public int getNumberOfNodes() {
        return getNumberOfNodes(_root);
    }

    public int getNumberOfLeafNodes() {
        return getNumberOfLeafNodes(_root);
    }

    public void displayByLevel() {
        displayByLevel(_root);
    }

    public int successor(int value) {
        Node successorNode = successor(_root, value);
        return successorNode == null ? -1 : successorNode.value;
    }

    public int predecessor(int value) {
        Node predecessorNode = predecessor(_root, value);
        return predecessorNode == null ? -1 : predecessorNode.value;
    }

    public void delete(int value) {
        _root = delete(_root, value);
    }

    public void calculateHeightForEachSubtree() {
        calculateHeightForEachSubtree(_root);
    }

    public void calculateNumberOfNodesForEachSubtree() {
        calculateNumberOfNodesForEachSubtree(_root);
    }

    public void drawTree() {
        drawTree(_root);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else {
            int compare = Integer.compare(value, node.value);

            if (compare < 0) {
                node.left = insert(node.left, value);
            } else if (compare > 0) {
                node.right = insert(node.right, value);
            } else {
                return null;
            }
        }

        return node;
    }

    private void preOrderWalk(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderWalk(node.left);
            preOrderWalk(node.right);
        }
    }

    private void inOrderWalk(Node node) {
        if (node != null) {
            inOrderWalk(node.left);
            System.out.print(node.value + " ");
            inOrderWalk(node.right);
        }
    }

    private void postOrderWalk(Node node) {
        if (node != null) {
            postOrderWalk(node.left);
            postOrderWalk(node.right);
            System.out.print(node.value + " ");
        }
    }

    private Node getMin(Node node) {
        if (node.left == null) return node;

        while (node.left != null)
            node = node.left;

        return node;
    }

    private Node search(int value) {
        Node node = _root;
        int compare = 0;

        while (node != null && (compare = Integer.compare(value, node.value)) != 0) {
            node = compare < 0 ? node.left : node.right;
        }

        return node;
    }

    private Node getMax(Node node) {
        if (node.right == null) return node;

        while (node.right != null)
            node = node.right;

        return node;
    }

    private int getHeight(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private int getNumberOfNodes(Node node) {
        if (node == null) return 0;
        return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
    }

    private int getNumberOfLeafNodes(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return getNumberOfLeafNodes(node.left) + getNumberOfLeafNodes(node.right);
    }

    private void displayByLevel(Node node) {
        if (node == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            System.out.print(n.value + ", ");
            if (n.left != null) queue.add(n.left);
            if (n.right != null) queue.add(n.right);
        }
    }

    private Node successor(Node node, int value) {
        if (node == null) return null;
        int compare = Integer.compare(value, node.value);

        if (compare == 0) {
            if (node.right != null) {
                return getMin(node.right);
            } else {
                return null;
            }
        } else if (compare < 0) {
            Node retNode = successor(node.left, value);
            return retNode == null ? node : retNode;
        } else {
            return successor(node.right, value);
        }
    }

    private Node predecessor(Node node, int value) {
        if (node == null) return null;
        int compare = Integer.compare(value, node.value);

        if (compare == 0) {
            if (node.left != null) {
                return getMax(node.left);
            } else {
                return null;
            }
        } else if (compare < 0) {
            return predecessor(node.left, value);
        } else {
            Node retNode = predecessor(node.right, value);
            return retNode == null ? node : retNode;
        }
    }

    private Node delete(Node node, int value) {
        if (node == null)
            return null;
        else {
            int compare = Integer.compare(value, node.value);

            if (compare < 0) {
                node.left = delete(node.left, value);
            } else if (compare > 0) {
                node.right = delete(node.right, value);
            } else if (node.left != null && node.right != null) {
                node.right = detachMin(node, node.right);
            } else {
                node = node.left != null ? node.left : node.right;
            }
        }

        return node;
    }

    private Node detachMin(Node del, Node node) {
        if (node.left != null)
            node.left = detachMin(del, node.left);
        else {
            del.value = node.value;
            node = node.right;
        }

        return node;
    }

    private void calculateHeightForEachSubtree(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            node.setSubtreeHeight(getHeight(node));
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
            node.setSubtreeNodes(getNumberOfNodes(node));
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
