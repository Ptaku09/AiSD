public class MergeSort {
    private int comparisons = 0;
    private int swaps = 0;

    public MergeSort() {
    }

    public void sort(int[] tab) {
        mergeSort(tab, tab.length);

        System.out.println("Merge sort: ");
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println();
    }

    private void mergeSort(int[] tab, int n) {
        if (n < 2)
            return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = tab[i];
            swaps++;
        }

        for (int i = mid; i < n; i++) {
            right[i - mid] = tab[i];
            swaps++;
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);
        merge(tab, left, right, mid, n - mid);
    }

    private void merge(int[] tab, int[] left, int[] right, int l, int r) {
        int i = 0, j = 0, k = 0;
        while (i < l && j < r) {
            if (!compare(left[i], right[j])) {
                tab[k++] = left[i++];
            } else {
                tab[k++] = right[j++];
            }

            swaps++;
        }

        while (i < l) {
            tab[k++] = left[i++];
            swaps++;
        }

        while (j < r) {
            tab[k++] = right[j++];
            swaps++;
        }
    }

    private boolean compare(int i, int j) {
        comparisons++;
        return i > j;
    }
}
