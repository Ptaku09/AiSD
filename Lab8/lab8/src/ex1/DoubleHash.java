package ex1;

public class DoubleHash implements HashFunction {
    private int i = 0;

    @Override
    public int hash(int el) {
        int code = 1;

        code ^= hashFunc(el);
        code ^= ((i++) * hashFunc(el / 2));

        return Math.abs(code);
    }

    @Override
    public void reset() {
        i = 0;
    }

    private int hashFunc(int el) {
        el ^= el << 13;
        el ^= el >>> 17;
        el ^= el << 5;

        return Math.abs(el);
    }

    @Override
    public String toString() {
        return "Double Hash";
    }
}
