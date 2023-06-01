package Ex2;

public class NumberIterator implements NumIterator<Integer> {
    private int firstNumber;
    private int lastNumber;
    private int currentItem;

    public NumberIterator(int firstNumber, int lastNumber) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
        currentItem = firstNumber;
    }

    @Override
    public void first() {
        currentItem = firstNumber;
    }

    @Override
    public void last() {
        currentItem = lastNumber;
    }

    @Override
    public void next() {
        currentItem++;
    }

    @Override
    public void previous() {
        currentItem--;
    }

    @Override
    public boolean isDone() {
        return currentItem < firstNumber || currentItem > lastNumber;
    }

    @Override
    public Integer current() {
        return currentItem;
    }
}
