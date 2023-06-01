package Ex2;

public class FilteredNumberIterator<Integer> implements NumIterator<Integer> {
    private NumIterator<Integer> iterator;
    private Predicate2<Integer> predicate;

    private Integer currentValue = null;
    private boolean bIsDone = false;

    public FilteredNumberIterator(NumIterator<Integer> iterator, Predicate2<Integer> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        next();
    }

    @Override
    public void first() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void last() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void next() {
        while (!iterator.isDone()) {
            currentValue = iterator.current();

            if (predicate.accept(currentValue)) {
                iterator.next();
                return;
            }

            iterator.next();
        }

        bIsDone = true;
        currentValue = null;
    }

    @Override
    public void previous() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isDone() {
        return bIsDone;
    }

    @Override
    public Integer current() {
        return currentValue;
    }
}
