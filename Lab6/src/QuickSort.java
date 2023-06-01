import java.util.Random;

public class QuickSort {
    private int comparisons = 0;
    private int swaps = 0;

    public QuickSort() {
    }

    public void sort(int[] tab) {
        quickSort(tab, 0, tab.length);

        System.out.println("Quick sort: ");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println();
    }

    private void quickSort(int[] tab, int startIndex, int endIndex) {
        if (endIndex - startIndex > 1) {
            int partition = partition(tab, startIndex, endIndex);
            quickSort(tab, startIndex, partition);
            quickSort(tab, partition + 1, endIndex);
        }
    }

    private int partition(int[] tab, int nFrom, int nTo) {
        Random random = new Random();
        int rnd = nFrom + random.nextInt(nTo - nFrom);
        swap(tab, nFrom, rnd);

        int value = tab[nFrom];
        int indexBigger = nFrom + 1;
        int indexLower = nTo - 1;

        do {
            while (indexBigger <= indexLower && !compare(tab[indexBigger], value))
                indexBigger++;

            while (compare(tab[indexLower], value))
                indexLower--;

            if (indexBigger < indexLower)
                swap(tab, indexBigger, indexLower);
        } while (indexBigger < indexLower);

        swap(tab, indexLower, nFrom);
        return indexLower;
    }

    private void swap(int[] tab, int left, int right) {
        if (left != right) {
            int temp = tab[left];
            tab[left] = tab[right];
            tab[right] = temp;

            swaps += 3;
        }
    }

    private boolean compare(int i, int j) {
        comparisons++;
        return i > j;
    }
}
