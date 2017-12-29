package searching.algorithms;

import org.jetbrains.annotations.NotNull;

public class LinearSearch implements Searcher {

    /**
     * Pathetic Algorithm no documentation needed
     *
     * @param ar the original array
     * @param n  the value to be searched
     * @return true if value if searched
     */
    @Override
    public boolean search(final int[] ar, final int n) {
        return search(ar, n, 0);
    }

    private boolean search(@NotNull final int ar[], final int n, int index) {
        return ar.length != index && (ar[index] == n || search(ar, n, ++index));
    }
}
