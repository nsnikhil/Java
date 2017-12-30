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

package datastructure.stack.array;

import util.GenericUtil;

import java.io.IOException;

public class StackOperation {

    private Stack mStack;

    public static void main(String... args) throws IOException {
        final StackOperation stackOperation = new StackOperation();
        stackOperation.initialize();
    }

    private void initialize() throws IOException {
        int ch;

        System.out.println(GenericUtil.INTEGER_INPUT_SIZE);
        mStack = new Stack(GenericUtil.takeIntegerInput());

        do {
            System.out.println("\nEnter 1 to push data to stack\n" +
                    "Enter 2 to pop data from stack\n" +
                    "Enter 3 to peek data from stack\n" +
                    "Enter 4 check if stack is empty\n" +
                    "Enter 5 check if stack is full\n" +
                    "Enter 6 to search stack\n" +
                    "Enter 7 to display the stack\n" +
                    "Enter 0 to exit\n");
            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mStack.push(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    mStack.pop();
                    break;
                case 3:
                    System.out.println(mStack.peek());
                    break;
                case 4:
                    System.out.println(mStack.isEmpty());
                    break;
                case 5:
                    System.out.println(mStack.isFull());
                    break;
                case 6:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mStack.search(GenericUtil.takeIntegerInput()));
                    break;
                case 7:
                    mStack.display();
                    break;
            }

        } while (ch != 0);
    }

}
