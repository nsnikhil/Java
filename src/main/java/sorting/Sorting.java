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

package sorting;

import sorting.algorithms.*;
import util.ArrayUtil;
import util.GenericUtil;

import java.io.IOException;

public class Sorting {

    public static void main(String... args) throws IOException {
        final Sorting sorting = new Sorting();
        sorting.initialize();
    }

    private void initialize() throws IOException {

        int choice;
        final int ar[] = ArrayUtil.takeArrayInput();
        ArrayUtil.printArray(ar);

        do {

            System.out.println("\nEnter 1 to perform bubble sort\n" +
                    "Enter 2 to perform insertion sort\n" +
                    "Enter 3 to perform selection sort\n" +
                    "Enter 4 to perform merge sort\n" +
                    "Enter 5 to perform quick sort\n" +
                    "Enter 6 to perform heap sort\n" +
                    "Enter 0 to exit\n");

            System.out.println("\nEnter your choice\n");

            choice = GenericUtil.takeIntegerInput();

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