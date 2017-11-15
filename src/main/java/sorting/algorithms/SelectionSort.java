package sorting.algorithms;

public class SelectionSort implements Sorter {

    @Override
    public int[] sort(int[] ar) {

        for (int i = 0,size = ar.length; i < size - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < size; j++)
                if (ar[j] < ar[minIndex])
                    minIndex = j;

            int temp = ar[minIndex];
            ar[minIndex] = ar[i];
            ar[i] = temp;
        }
        return ar;
    }

}