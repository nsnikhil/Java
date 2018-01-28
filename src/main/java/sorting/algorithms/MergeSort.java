/*
 *    Copyright 2017 nsnikhil
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package sorting.algorithms;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Implementation of merge sort
 */
public class MergeSort implements Sorter {

    /**
     * @param ar the original array
     * @return the sorted array
     */
    @Override
    public final Integer[] sort(final Integer[] ar) {
        return mergeSort(ar);
    }

    /**
     * Divide the array into two equal* halves
     * and continue diving until one one element is left
     * in each of the two array and then call the merge function to
     * merge the two array into one array that is sorted.
     * <p>
     * Eg -> ar - 9,8,5,2,6,4
     * <p>
     * Divide into two 9,5,8 and 2,6,4
     * again divide 9 and 8,5
     * and then 8 and 5
     * and then 8 & 5 are merged to form 5,8
     * and then 9 and 5,8 are merged to form 5,8,9
     * <p>
     * similar for 2,6,4 to form 2,4,6
     * <p>
     * and finally merge is called with 5,8,9 and 2,6,4
     * to form  2,4,5,6,8,9
     *
     * @param ar the original array
     * @return the sorted array
     */
    @Nullable
    private Integer[] mergeSort(@NotNull final Integer[] ar) {
        final int arrayLength = ar.length;

        if (arrayLength <= 1) return null;

        final int mid = ar.length / 2;
        final Integer leftSubArray[], rightSubArray[];

        leftSubArray = new Integer[mid];

        if (arrayLength % 2 == 0)
            rightSubArray = new Integer[mid];
        else
            rightSubArray = new Integer[mid + 1];

        /*
         * The code below does the same as this loop
         * for (int i = 0, size = leftSubArray.length; i < size; i++)
         *      leftSubArray[i] = ar[i];
         */
        System.arraycopy(ar, 0, leftSubArray, 0, leftSubArray.length);

        /*
         * The code below does the same as this loop
         * for (int i = mid; i < arrayLength; i++)
         *      rightSubArray[i - mid] = ar[i];
         */
        System.arraycopy(ar, mid, rightSubArray, 0, arrayLength - mid);

        mergeSort(leftSubArray);

        mergeSort(rightSubArray);

        merge(ar, leftSubArray, rightSubArray);

        return ar;
    }

    /**
     * The merge function merges two array into the main array
     * the value of left and right array are compared element wise
     * and the smallest of the two is inserted into the original array and
     * its index value is increased and this goes on until of the array is
     * completely inserted and then the remaining array is inserted into the
     * array as it is.
     * <p>
     * Eg - > leftArray : 2,5,9. rightArray : 3,4,7
     * <p>
     * int l = 0 , r = 0 , k = 0;
     * <p>
     * ar[k] = smaller of leftArray[l] & rightArray[k]
     * <p>
     * here
     * <p>
     * ar[0] = 2 amd l and k are incremented by one then
     * ar[1] = 3 and r and k are incremented by one and so on
     * <p>
     * finally we have ar = 2,3,4,5,7,9
     *
     * @param ar         the original array
     * @param leftArray  the left sub array
     * @param rightArray the right sub array
     */
    private void merge(@NotNull final Integer[] ar, @NotNull final Integer[] leftArray, @NotNull final Integer[] rightArray) {
        final int leftLength = leftArray.length;
        final int rightLength = rightArray.length;

        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {

            if (leftArray[i] < rightArray[j]) {
                ar[k] = leftArray[i];
                i++;
            } else {
                ar[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            ar[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            ar[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /*private void mergeOne(@NotNull final Integer[] ar, @NotNull final Integer[] leftArray, @NotNull final Integer[] rightArray,final int leftLength,final int rightLength,final int i,final int j,final int k) {
        if(i==leftLength||j==rightLength)return;
        if (leftArray[i] < rightArray[j]) {
            ar[k] = leftArray[i];
            mergeOne(ar,leftArray,rightArray,leftLength,rightLength,i+1,j,k+1);
        } else {
            ar[k] = rightArray[j];
            mergeOne(ar,leftArray,rightArray,leftLength,rightLength,i,j+1,k+1);
        }
    }

    private void mergeTwo(@NotNull final Integer[] mainArray,@NotNull final Integer[] subArray,final int index,final int length,final int k){
        if(index==length)return;
        mainArray[k] = subArray[index];
        mergeTwo(mainArray,subArray,index+1,length,k+1);
    }*/
}