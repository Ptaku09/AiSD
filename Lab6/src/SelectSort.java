public class SelectSort {
    private int swaps = 0;
    private int comparisons = 0;

    public SelectSort() {
    }

    public void sort(int[] tab) {
        for (int i = 0; i < tab.length - 1; i++) {
            int smallest = i;

            for (int j = i + 1; j < tab.length; j++)
                if (compare(tab[smallest], tab[j]))
                    smallest = j;

            if (smallest != i)
                swap(tab, i, smallest);
        }

        System.out.println("Select sort: ");
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
