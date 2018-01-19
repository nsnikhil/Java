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

package datastructure.queue.array;

import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class QueueOperations {

    private Queue mQueue;
    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final QueueOperations queueOperations = new QueueOperations();
        queueOperations.buildChoice();
        queueOperations.initialize();
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
        mQueue = new Queue(GenericUtil.takeIntegerInput());

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            System.out.println(PrintUtil.ENTER_CHOICE_MESSAGE);
            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mQueue.enqueue(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    mQueue.dequeue();
                    break;
                case 3:
                    System.out.print(mQueue.getFront());
                    break;
                case 4:
                    System.out.print(mQueue.getRear());
                    break;
                case 5:
                    System.out.print(mQueue.isEmpty());
                    break;
                case 6:
                    System.out.print(mQueue.isFull());
                    break;
                case 7:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mQueue.search(GenericUtil.takeIntegerInput()));
                    break;
                case 8:
                    mQueue.display();
                    break;
            }
        } while (ch != 0);
    }
}