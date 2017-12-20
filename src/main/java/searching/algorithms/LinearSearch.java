package searching.algorithms;

public class LinearSearch implements Searcher {

    /**
     * Pathetic Algorithm no documentation needed
     *
     * @param ar the original array
     * @param n  the value to be searched
     * @return true if value if searched
     */
    @Override
    public boolean search(int[] ar, int n) {
        for (int i : ar)
            if (i == n)
                return true;
        return false;
    }
}
