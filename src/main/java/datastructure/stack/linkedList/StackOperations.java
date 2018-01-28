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

package datastructure.stack.linkedList;

import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Class to demonstrate functions of
 * stack
 */
public class StackOperations {

    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final StackOperations stackOperations = new StackOperations();
        stackOperations.buildChoice();
        stackOperations.initialize();
    }

    /**
     * build list of choices which
     * can be performed
     */
    private void buildChoice() {
        mChoice = PrintUtil.getPrintList(Arrays.asList(
                "push data to stack",
                "pop data from stack",
                "peek data from stack",
                "check if stack is empty",
                "search stack",
                "get stack size",
                "display the stack"));
    }

    /**
     * function that allows to perform all function
     * of dynamic array
     *
     * @throws IOException IOException
     */
    private void initialize() throws IOException {
        int ch;
        Stack<Integer> stack = new Stack<>();
        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            System.out.println(PrintUtil.ENTER_CHOICE_MESSAGE);
            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    stack.push(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    System.out.println(stack.pop());
                    break;
                case 3:
                    System.out.println(stack.peek());
                    break;
                case 4:
                    System.out.println(stack.empty());
                    break;
                case 5:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(stack.search(GenericUtil.takeIntegerInput()));
                    break;
                case 6:
                    System.out.println(stack.size());
                    break;
                case 7:
                    stack.display();
                    break;
            }
        } while (ch != 0);
    }
}