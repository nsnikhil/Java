package searching;

import searching.algorithms.BinarySearch;
import searching.algorithms.LinearSearch;
import util.ArrayUtil;
import util.GenericUtil;

import java.io.IOException;

public class Searching {

    public static void main(String... args) throws IOException {
        Searching searching = new Searching();
        searching.initialize();
    }

    private void initialize() throws IOException {

        int choice,number;

        int ar[] = ArrayUtil.takeArrayInput();

        ArrayUtil.printArray(ar);

        System.out.println("\nEnter the number to search\n");

        number = GenericUtil.takeIntegerInput();

        do {

            System.out.println("\nEnter 1 to perform linear search\n" +
                    "Enter 2 to perform binary search\n" +
                    "Enter 0 to exit\n");

            System.out.println("\nEnter your choice\n");

            choice = GenericUtil.takeIntegerInput();

            switch (choice) {
                case 1:
                    System.out.println(new LinearSearch().search(ar,number));
                    break;
                case 2:
                    System.out.println(new BinarySearch().search(ar,number));
                    break;
            }
        } while (choice != 0);
    }
}
