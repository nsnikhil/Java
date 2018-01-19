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

package datastructure.queue.array.circular;

import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CircularQueueOperations {

    private CircularQueueArray mCircularQueueArray;
    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final CircularQueueOperations circularQueueOperations = new CircularQueueOperations();
        circularQueueOperations.buildChoice();
        circularQueueOperations.initialize();
    }

    private void buildChoice() {
        mChoice = PrintUtil.getPrintList(Arrays.asList(
                "enqueue data to queue",
                "dequeue data from queue",
                "get front",
                "get rear",
                "check if queue is empty",
                "check if queue is full",
                "search queue",
                "display the queue"));
    }

    private void initialize() throws IOException {
        int ch;

        System.out.println(GenericUtil.INTEGER_INPUT_SIZE);
        mCircularQueueArray = new CircularQueueArray(GenericUtil.takeIntegerInput());

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            System.out.println(PrintUtil.ENTER_CHOICE_MESSAGE);
            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mCircularQueueArray.enqueue(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    mCircularQueueArray.dequeue();
                    break;
                case 3:
                    System.out.println(mCircularQueueArray.getFront());
                    break;
                case 4:
                    System.out.println(mCircularQueueArray.getRear());
                    break;
                case 5:
                    System.out.println(mCircularQueueArray.isEmpty());
                    break;
                case 6:
                    System.out.println(mCircularQueueArray.isFull());
                    break;
                case 7:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mCircularQueueArray.search(GenericUtil.takeIntegerInput()));
                    break;
                case 8:
                    mCircularQueueArray.display();
                    break;
            }

        } while (ch != 0);
    }

}
