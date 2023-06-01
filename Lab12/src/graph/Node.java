package graph;

public class Node {
    private final int value;
    private boolean isVisited;
    private int distance;

    public Node(int value) {
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