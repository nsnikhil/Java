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

import java.io.IOException;

public class StackOperations {

    private Stack<Integer> mStack;

    public static void main(String... args) throws IOException {
        final StackOperations stackOperations = new StackOperations();
        stackOperations.initialize();
    }

    private void initialize() throws IOException {
        int ch;
        mStack = new Stack<>();
        do {
            System.out.println("\nEnter 1 to push data to stack\n" +
                    "Enter 2 to pop data from stack\n" +
                    "Enter 3 to peek data from stack\n" +
                    "Enter 4 check if stack is empty\n" +
                    "Enter 5 to search stack\n" +
                    "Enter 6 to get stack size\n" +
                    "Enter 7 to display the stack\n" +
                    "Enter 0 to exit\n");
            ch = GenericUtil.takeIntegerInput();
            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mStack.push(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    System.out.println(mStack.pop());
                    break;
                case 3:
                    System.out.println(mStack.peek());
                    break;
                case 4:
                    System.out.println(mStack.empty());
                    break;
                case 5:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mStack.search(GenericUtil.takeIntegerInput()));
                    break;
                case 6:
                    System.out.println(mStack.size());
                    break;
                case 7:
                    mStack.display();
                    break;
            }
        } while (ch != 0);
    }
}