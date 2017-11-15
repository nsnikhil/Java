package sorting.algorithms;

public class BubbleSort implements Sorter {

    @Override
    public int[] sort(int[] ar) {
        for (int i = 0, size = ar.length; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++)
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
        }
        return ar;
    }

}