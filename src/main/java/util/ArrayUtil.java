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

    public static final String ARRAY_INPUT_SIZE = "Enter the size of array";
    public static final String ARRAY_INPUT_ROW_SIZE = "Enter numbers of rows";
    public static final String ARRAY_INPUT_COLUMN_SIZE = "Enter numbers of columns";
    public static final String ARRAY_ELEMENTS_INPUTS = "Enter the array elements";

    /**
     * @return integer array
     * @throws IOException input/output exception
     */
    public static int[] takeArrayInput() throws IOException {
        return takeArrayInput(new int[GenericUtil.takeIntegerInput()], 0);
    }

    /**
     * @return 2-d integer array
     * @throws IOException input/output exception
     */
    public static int[][] take2dArrayInput() throws IOException {
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

    private static int[][] take2dArrayInput(@NotNull final int[][] arr, final int row) throws IOException {
        if (arr.length == row) return arr;
        arr[row] = takeArrayInput(arr[row], 0);
        return take2dArrayInput(arr, row + 1);
    }

    private static int[] takeArrayInput(@NotNull final int ar[], final int index) throws IOException {
        if (ar.length == index) return ar;
        ar[index] = GenericUtil.takeIntegerInput();
        return takeArrayInput(ar, index + 1);
    }

    /**
     * @param ar integer array
     */
    public static void printArray(final Integer[] ar) {
        if (ar == null) return;
        printArray(ar, 0);
    }

    private static void printArray(@NotNull final Integer[] ar, final int index) {
        if (ar.length == index) return;
        System.out.print(ar[index] + " ");
        printArray(ar, index + 1);
    }

    /**
     * @param arr 2-d integer array
     */
    public static void print2dArray(final Integer[][] arr) {
        if (arr == null) return;
        print2dArray(arr, 0);
    }

    private static void print2dArray(@NotNull final Integer[][] arr, final int row) {
        if (arr.length == row) return;
        printArray(arr[row]);
        System.out.println();
        print2dArray(arr, row + 1);
    }

    /**
     * @param ar integer array
     */
    public static void printArray(final int[] ar) {
        if (ar == null) return;
        printArray(ar, 0);
    }

    private static void printArray(@NotNull final int[] ar, final int index) {
        if (ar.length == index) return;
        System.out.print(ar[index] + " ");
        printArray(ar, index + 1);
    }

    /**
     * @param arr 2-d integer array
     */
    public static void print2dArray(final int[][] arr) {
        if (arr == null) return;
        print2dArray(arr, 0);
    }

    private static void print2dArray(@NotNull final int[][] arr, final int row) {
        if (arr.length == row) return;
        printArray(arr[row]);
        System.out.println();
        print2dArray(arr, row + 1);
    }
}