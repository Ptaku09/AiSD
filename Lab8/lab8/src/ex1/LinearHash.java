package ex1;

public class LinearHash implements HashFunction {
    private int i = 0;

    @Override
    public int hash(int el) {
        el ^= el << 13;
        el ^= el >>> 17;
        el ^= el << 5;

        return Math.abs(el) + i++;
    }

    @Override
    public void reset() {
        i = 0;
    }

    @Override
    public String toString() {
        return "Linear Hash";
    }
}
