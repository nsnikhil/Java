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

package searching;

import searching.algorithms.BinarySearch;
import searching.algorithms.LinearSearch;
import util.ArrayUtil;
import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Class illustrating searching on a array
 */
public final class Searching {

    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final Searching searching = new Searching();
        searching.buildChoice();
        searching.initialize();
    }

    /**
     * build list of choices which
     * can be performed
     */
    private void buildChoice() {
        mChoice = PrintUtil.getPrintList(Arrays.asList(
                PrintUtil.buildChoiceString("linear", PrintUtil.ACTION_SEARCH),
                PrintUtil.buildChoiceString("binary", PrintUtil.ACTION_SEARCH)));
    }

    /**
     * function that allows to perform
     * linear and binary search on a array
     *
     * @throws IOException IOException
     */
    private void initialize() throws IOException {

        int choice;
        System.out.println(ArrayUtil.ARRAY_INPUT_SIZE + " & " + ArrayUtil.ARRAY_ELEMENTS_INPUTS);
        final Integer[] ar = ArrayUtil.takeArrayInput();

        ArrayUtil.printArray(ar);

        System.out.println("\nEnter the number to search\n");

        final int number = GenericUtil.takeIntegerInput();

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            System.out.println(PrintUtil.ENTER_CHOICE_MESSAGE);

            choice = GenericUtil.takeIntegerInput();

            switch (choice) {
                case 1:
                    System.out.println(new LinearSearch().search(ar, number));
                    break;
                case 2:
                    System.out.println(new BinarySearch().search(ar, number));
                    break;
            }
        } while (choice != 0);
    }
}
