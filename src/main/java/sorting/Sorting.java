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
import util.PrintUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sorting {

    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final Sorting sorting = new Sorting();
        sorting.buildChoice();
        sorting.initialize();
    }

    private void buildChoice() {
        mChoice = new ArrayList<>();
        mChoice.add("exit");
        mChoice.add(buildChoice("bubble"));
        mChoice.add(buildChoice("insertion"));
        mChoice.add(buildChoice("selection"));
        mChoice.add(buildChoice("merge"));
        mChoice.add(buildChoice("quick"));
        mChoice.add(buildChoice("heap"));
    }

    private String buildChoice(String choice) {
        return "perform " + choice + " sort";
    }

    private void initialize() throws IOException {

        int choice;
        System.out.println(ArrayUtil.ARRAY_INPUT_SIZE + " & " + ArrayUtil.ARRAY_ELEMENTS_INPUTS);
        final int ar[] = ArrayUtil.takeArrayInput();
        ArrayUtil.printArray(ar);

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
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