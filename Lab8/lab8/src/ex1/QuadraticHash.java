package ex1;

public class QuadraticHash implements HashFunction {
    private int i = 0;

    @Override
    public int hash(int el) {
        el ^= el << 13;
        el ^= el >>> 17;
        el ^= el << 5;

        return (int) (Math.abs(el) + Math.pow(i++, 2));
    }

    @Override
    public void reset() {
        i = 0;
    }

    @Override
    public String toString() {
        return "Quadratic Hash";
    }
}
