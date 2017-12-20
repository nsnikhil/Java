package searching.algorithms;

import sorting.algorithms.QuickSort;

public class BinarySearch implements Searcher {

    /**
     * @param ar the original array
     * @param n  the value to be searched
     * @return true of value if found
     */
    @Override
    public boolean search(int[] ar, int n) {
        return binarySearch(new QuickSort().sort(ar), 0, ar.length, n);
    }

    /**
     * Find the mid of the array and search if no
     * is equal to array at mid index if not
     * then recursively search right of mid index if element is
     * greater than value at mid index else search from start to
     * mid of the array.
     * <p>
     * Eg -> 2,3,8,9,14,51,55,88 and no - 3
     * mid  = (0+8)/2 = 4
     * ar[mid] = 9
     * since no < ar[mid]
     * recursively search from (0 to mid)
     * and if value if found return true.
     *
     * @param ar    the original array
     * @param start the starting index
     * @param end   the end index
     * @param no    the number to be searched
     * @return true if number is present
     */
    private boolean binarySearch(int[] ar, int start, int end, int no) {
        if (start > end) return false;
        int mid = (start + end) / 2;
        if (no == ar[mid]) return true;
        if (no < ar[mid]) return binarySearch(ar, start, mid - 1, no);
        return binarySearch(ar, mid + 1, end, no);
    }

}
