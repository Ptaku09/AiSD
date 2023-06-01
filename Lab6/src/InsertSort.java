public class InsertSort {
    private int swaps = 0;
    private int comparisons = 0;

    public InsertSort() {
    }

    public void sort(int[] tab) {
        for (int i = 0; i < tab.length; i++)
            for (int j = i; j > 0 && compare(tab[j - 1], tab[j]); j--)
                swap(tab, j, j - 1);

        System.out.println("Insert sort: ");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println();
    }

    private void swap(int[] tab, int i, int j) {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
        swaps += 3;
    }

    private boolean compare(int i, int j) {
        comparisons++;
        return i > j;
    }
}
