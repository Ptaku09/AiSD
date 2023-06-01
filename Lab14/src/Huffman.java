import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman {
    static class Node {
        private final Character character;
        private final Node left;
        private final Node right;
        private int frequency;

        public Node(Character character, int frequency, Node left, Node right) {
            this.character = character;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public char getCharacter() {
            return character;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    private final PriorityQueue<Node> priorityQueue;
    private final Map<Character, Integer> frequencyMap;
    private final Map<Character, String> encodingMap;
    private Node root;
    private String encoded;

    public Huffman() {
        this.frequencyMap = new HashMap<>();
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getFrequency));
        this.encodingMap = new HashMap<>();
        root = null;
        encoded = "";
    }

    public void encode(String text) {
        buildFrequencyMap(text);
        createNodes();
        buildPriorityTree();
        createCodes(root, "");
        displayEncodedText(text);
    }

    private void buildFrequencyMap(String text) {
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (frequencyMap.containsKey(character))
                frequencyMap.put(character, frequencyMap.get(character) + 1);
            else
                frequencyMap.put(character, 1);
        }
    }

    private void createNodes() {
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet())
            priorityQueue.add(new Node(entry.getKey(), entry.getValue(), null, null));
    }

    private void buildPriorityTree() {
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();

            assert right != null;
            Node nodeToAdd = new Node(null, left.getFrequency() + right.getFrequency(), left, right);
            priorityQueue.add(nodeToAdd);
        }

        root = priorityQueue.poll();
    }

    private void createCodes(Node root, String string) {
        if (root == null) return;

        if (root.getLeft() == null && root.getRight() == null)
            encodingMap.put(root.getCharacter(), string.length() > 0 ? string : "0");

        createCodes(root.getLeft(), string + "0");
        createCodes(root.getRight(), string + "1");
    }

    private void displayEncodedText(String text) {
        StringBuilder sb = new StringBuilder();

        System.out.println("ENCODED TEXT");

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            sb.append(encodingMap.get(character));
        }

        this.encoded = sb.toString();
        System.out.println(this.encoded);

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }

    public void decode() {
        StringBuilder sb = new StringBuilder();

        if (root.getLeft() == null && root.getRight() == null) {
            while (root.getFrequency() > 0) {
                sb.append(root.getCharacter());
                root.setFrequency(root.getFrequency() - 1);
            }
        } else {
            int index = -1;

            while (index < encoded.length() - 1)
                index = decode(root, index, sb);
        }

        printDecodedText(sb.toString());
    }

    private int decode(Node root, int index, StringBuilder sb) {
        if (root == null) return index;

        if (root.getLeft() == null && root.getRight() == null) {
            sb.append(root.getCharacter());
            return index;
        }

        index++;

        root = encoded.charAt(index) == '0' ? root.getLeft() : root.getRight();
        index = decode(root, index, sb);

        return index;
    }

    private void printDecodedText(String text) {
        System.out.println("DECODED TEXT");
        System.out.println(text);
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }

    public void printCodes() {
        System.out.println("CODES");
        System.out.println(encodingMap);
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }

    public void printStats() {
        int averageLength = 0;
        int differentCharacters = frequencyMap.size();
        int totalCharacters = 0;
        int shortestCode = Integer.MAX_VALUE;
        int longestCode = 0;

        for (Map.Entry<Character, String> entry : encodingMap.entrySet()) {
            averageLength += entry.getValue().length();
            shortestCode = Math.min(shortestCode, entry.getValue().length());
            longestCode = Math.max(longestCode, entry.getValue().length());
        }

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet())
            totalCharacters += entry.getValue();

        System.out.println("STATS");
        System.out.printf("Average code length: %.2f\n", (double) averageLength / differentCharacters);
        System.out.printf("Shortest code length: %d\n", shortestCode);
        System.out.printf("Longest code length: %d\n", longestCode);
        System.out.printf("Total characters: %d\n", totalCharacters);
        System.out.printf("Different characters: %d\n", differentCharacters);

        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println();
    }
}
