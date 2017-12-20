package util;

import java.io.IOException;

public class ArrayUtil {

    /**
     * @return integer array
     * @throws IOException input/output exception
     */
    public static int[] takeArrayInput() throws IOException {
        System.out.println("Enter the size of array and array elements");
        return takeArrayInput(GenericUtil.takeIntegerInput());
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
    private static int[][] take2dArrayInput(int row, int column) throws IOException {
        int arr[][] = new int[row][column];
        for (int i = 0; i < row; i++)
            arr[i] = takeArrayInput(column);
        return arr;
    }

    /**
     * @param size size of integer array
     * @return integer array
     * @throws IOException input/output exception
     */
    private static int[] takeArrayInput(int size) throws IOException {
        int ar[] = new int[size];
        for (int i = 0; i < size; i++)
            ar[i] = GenericUtil.takeIntegerInput();
        return ar;
    }

    /**
     * @param ar integer array
     */
    public static void printArray(Integer[] ar) {
        if (ar == null) return;
        for (Integer i : ar)
            System.out.print(i + " ");
    }

    /**
     * @param arr 2-d integer array
     */
    public static void print2dArray(Integer[][] arr) {
        if (arr == null) return;
        for (Integer[] ar : arr) {
            printArray(ar);
            System.out.println("");
        }
    }

    /**
     * @param ar    integer array
     */
    public static void printArray(int[] ar) {
        if (ar == null) return;
        for (int i : ar)
            System.out.print(i + " ");
    }

    /**
     * @param arr   2-d integer array
     */
    public static void print2dArray(int[][] arr) {
        if (arr == null) return;
        for (int[] ar : arr) {
            printArray(ar);
            System.out.println("");
        }
    }
}