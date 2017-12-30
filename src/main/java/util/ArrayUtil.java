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

package util;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public final class ArrayUtil {

    /**
     * @return integer array
     * @throws IOException input/output exception
     */
    public static int[] takeArrayInput() throws IOException {
        System.out.println("Enter the size of array and array elements");
        return takeArrayInput(new int[GenericUtil.takeIntegerInput()], 0);
    }

    /**
     * @return 2-d integer array
     * @throws IOException input/output exception
     */
    public static int[][] take2dArrayInput() throws IOException {
        System.out.println("Enter the no of row and column and array elements");
        return take2dArrayInput(GenericUtil.takeIntegerInput(), GenericUtil.takeIntegerInput());
    }

    /**
     * @param row    no of rows in array
     * @param column no of columns in array
     * @return 2-d integer array
     * @throws IOException input/output exception
     */
    private static int[][] take2dArrayInput(final int row, final int column) throws IOException {
        return take2dArrayInput(new int[row][column], 0);
    }

    private static int[][] take2dArrayInput(@NotNull final int[][] arr, int row) throws IOException {
        if (arr.length == row) return arr;
        arr[row] = takeArrayInput(arr[row], 0);
        return take2dArrayInput(arr, ++row);
    }

    /**
     * @param size size of integer array
     * @return integer array
     * @throws IOException input/output exception
     */
    private static int[] takeArrayInput(final int size) throws IOException {
        final int ar[] = new int[size];
        for (int i = 0; i < size; i++)
            ar[i] = GenericUtil.takeIntegerInput();
        return ar;
    }

    private static int[] takeArrayInput(@NotNull final int ar[], int index) throws IOException {
        if (ar.length == index) return ar;
        ar[index] = GenericUtil.takeIntegerInput();
        return takeArrayInput(ar, ++index);
    }

    /**
     * @param ar integer array
     */
    public static void printArray(final Integer[] ar) {
        if (ar == null) return;
        printArray(ar, 0);
    }

    private static void printArray(@NotNull final Integer[] ar, int index) {
        if (ar.length == index) return;
        System.out.print(ar[index] + " ");
        printArray(ar, ++index);
    }

    /**
     * @param arr 2-d integer array
     */
    public static void print2dArray(final Integer[][] arr) {
        if (arr == null) return;
        print2dArray(arr, 0);
    }

    private static void print2dArray(@NotNull final Integer[][] arr, int row) {
        if (arr.length == row) return;
        printArray(arr[row]);
        System.out.println();
        print2dArray(arr, ++row);
    }

    /**
     * @param ar integer array
     */
    public static void printArray(final int[] ar) {
        if (ar == null) return;
        printArray(ar, 0);
    }

    private static void printArray(@NotNull final int[] ar, int index) {
        if (ar.length == index) return;
        System.out.print(ar[index] + " ");
        printArray(ar, ++index);
    }

    /**
     * @param arr 2-d integer array
     */
    public static void print2dArray(final int[][] arr) {
        if (arr == null) return;
        print2dArray(arr, 0);
    }

    private static void print2dArray(@NotNull final int[][] arr, int row) {
        if (arr.length == row) return;
        printArray(arr[row]);
        System.out.println();
        print2dArray(arr, ++row);
    }
}