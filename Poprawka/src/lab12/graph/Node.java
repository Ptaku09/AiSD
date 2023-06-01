package src.lab12.graph;

public class Node {
    private final int index;
    private final int value;
    private boolean isVisited;
    private int distance;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
        this.isVisited = false;
        this.distance = Integer.MAX_VALUE;
    }

    public void visit() {
        this.isVisited = true;
    }

    public void unvisit() {
        this.isVisited = false;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}