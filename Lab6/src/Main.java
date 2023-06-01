import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arraysLength = {8, 32, 128, 512};

        System.out.println("-----------------------------------------");
        System.out.println("RANDOM ORDER");
        System.out.println("-----------------------------------------");

        for (int length : arraysLength) {
            int[] array = createArray(length);

            run(array);
        }

        System.out.println("-----------------------------------------");
        System.out.println("SORTED BACKWARDS");
        System.out.println("-----------------------------------------");

        for (int length : arraysLength) {
            int[] array = createArray(length);

            //Sort backwards
            Arrays.sort(array);
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }

            run(array);
        }

        System.out.println("-----------------------------------------");
        System.out.println("SORTED");
        System.out.println("-----------------------------------------");

        for (int length : arraysLength) {
            int[] array = createArray(length);

            Arrays.sort(array);
            run(array);
        }
    }

    private static void run(int[] array1) {
        SelectSort selectSort = new SelectSort();
        InsertSort insertSort = new InsertSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        int[] array2 = duplicateArray(array1);
        int[] array3 = duplicateArray(array1);
        int[] array4 = duplicateArray(array1);

        System.out.println();
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println("Array length: " + array1.length);
        System.out.print("Array: ");
        printArray(array1);
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-");
        System.out.println();

        insertSort.sort(array1);
        selectSort.sort(array2);
        mergeSort.sort(array3);
        quickSort.sort(array4);
    }

    private static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println();
    }

    private static int[] duplicateArray(int[] arr) {
        int[] result = new int[arr.length];
        System.arraycopy(arr, 0, result, 0, arr.length);

        return result;
    }

    private static int[] createArray(int n) {
        Random random = new Random();
        int[] result = new int[n];

        for (int i = 0; i < n; i++)
            result[i] = random.nextInt(1, 10000);

        return result;
    }
}
