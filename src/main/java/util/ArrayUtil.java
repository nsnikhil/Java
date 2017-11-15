package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayUtil {

    private static BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static int[] takeArrayInput() throws IOException {
        System.out.println("Enter the size of array");

        int size = Integer.parseInt(mBufferedReader.readLine());

        int ar[] = new int[size];

        System.out.println("Enter the array elements");

        for (int i = 0; i < size; i++) {
            ar[i] = Integer.parseInt(mBufferedReader.readLine());
        }

        return ar;
    }

    public static int[][] take2dArrayInput() throws IOException {

        System.out.println("Enter the no of row");

        int row = Integer.parseInt(mBufferedReader.readLine());

        System.out.println("Enter the no of column");

        int column = Integer.parseInt(mBufferedReader.readLine());

        int arr[][] = new int[row][column];

        System.out.println("Enter the array elements");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = Integer.parseInt(mBufferedReader.readLine());
            }

        }

        return arr;
    }

    public static void printArray(int[] ar) {
        if (ar == null) return;
        for (int i : ar) {
            System.out.print(i + " ");
        }
    }

    public static void printArray(Integer[] ar) {
        if (ar == null) return;
        for (int i : ar) {
            System.out.print(i + " ");
        }
    }

    public static void print2dArray(int[][] arr) {
        if (arr == null) return;
        for (int[] ar : arr) {
            printArray(ar);
            System.out.println();
        }
    }

    public static void print2dArray(Integer[][] arr) {
        if (arr == null) return;
        for (Integer[] ar : arr) {
            printArray(ar);
            System.out.println();
        }
    }

}
