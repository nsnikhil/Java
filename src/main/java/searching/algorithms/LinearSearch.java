package searching.algorithms;

public class LinearSearch implements Searcher {

    @Override
    public boolean search(int[] ar, int n) {
        for (int i : ar)
            if (i == n)
                return true;
        return false;
    }
}
