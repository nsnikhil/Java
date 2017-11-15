package sorting.algorithms;

public class InsertionSort implements Sorter {

    @Override
    public int[] sort(int[] ar) {
        int i = 0;
        int j = 1;
        while (j < ar.length) {
            int no = ar[j];
            int p = i;
            while (p >= 0 && ar[p] > no) {
                ar[p + 1] = ar[p];
                --p;
            }
            ar[p + 1] = no;
            ++i;
            ++j;
        }
        return ar;
    }

}
