package sorting;

import sorting.algorithms.*;
import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sorting {

    private BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String... args) throws IOException {
        Sorting sorting = new Sorting();
        sorting.initialize();
    }

    private void initialize() throws IOException {

        int choice;
        int ar[] = ArrayUtil.takeArrayInput();
        ArrayUtil.printArray(ar);

        do {

            System.out.println("\nEnter 1 to perform bubble sort\n" +
                                 "Enter 2 to perform insertion sort\n" +
                                 "Enter 3 to perform selection sort\n" +
                                 "Enter 4 to perform merge sort\n" +
                                 "Enter 5 to perform quick sort\n" +
                                 "Enter 6 to perform heap sort\n"+
                                 "Enter 0 to exit\n");

            System.out.println("\nEnter your choice\n");

            choice = Integer.parseInt(mBufferedReader.readLine());

            switch (choice) {
                case 1:
                    ArrayUtil.printArray(new BubbleSort().sort(ar));
                    break;
                case 2:
                    ArrayUtil.printArray(new InsertionSort().sort(ar));
                    break;
                case 3:
                    ArrayUtil.printArray(new SelectionSort().sort(ar));
                    break;
                case 4:
                    ArrayUtil.printArray(new MergeSort().sort(ar));
                    break;
                case 5:
                    ArrayUtil.printArray(new QuickSort().sort(ar));
                    break;
                case 6:
                    ArrayUtil.printArray(new HeapSort().sort(ar));
                    break;
            }
        } while (choice != 0);
    }


}
