package searching.algorithms;

import sorting.algorithms.QuickSort;

public class BinarySearch implements Searcher {

    @Override
    public boolean search(int[] ar, int n) {
        return binarySearch(new QuickSort().sort(ar), 0, ar.length, n);
    }

    private boolean binarySearch(int[] ar, int start, int end, int no) {
        if (start > end) return false;
        int mid = (start + end) / 2;
        if (no == ar[mid]) return true;
        if (no < ar[mid]) return binarySearch(ar, start, mid - 1, no);
        return binarySearch(ar, mid + 1, end, no);
    }

}
