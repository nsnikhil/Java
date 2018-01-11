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
import util.PrintUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StackOperation {

    private Stack mStack;
    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final StackOperation stackOperation = new StackOperation();
        stackOperation.initialize();
    }

    private void buildChoice() {
        mChoice = new ArrayList<>();
        mChoice.add("exit");
        mChoice.add("push data to stack");
        mChoice.add("pop data from stack");
        mChoice.add("peek data from stack");
        mChoice.add("check if stack is empty");
        mChoice.add("check if stack is full");
        mChoice.add("search stack");
        mChoice.add("display the stack");
    }

    private void initialize() throws IOException {
        int ch;

        System.out.println(GenericUtil.INTEGER_INPUT_SIZE);
        mStack = new Stack(GenericUtil.takeIntegerInput());

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
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
