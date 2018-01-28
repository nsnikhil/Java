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

package datastructure.queue.linkedList;

import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Class to demonstrate functions of
 * linear queue
 */
public class QueueOperations {

    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final QueueOperations queueOperations = new QueueOperations();
        queueOperations.buildChoice();
        queueOperations.initialize();
    }

    /**
     * build list of choices which
     * can be performed
     */
    private void buildChoice() {
        mChoice = PrintUtil.getPrintList(Arrays.asList(
                "enqueue data to queue",
                "dequeue data from queue",
                "peek data from queue",
                "check if queue is empty",
                "search queue",
                "get queue size",
                "display the queue"));
    }

    /**
     * function that allows to perform all function
     * of queue
     *
     * @throws IOException IOException
     */
    private void initialize() throws IOException {
        Queue<Integer> queue = new Queue<>();
        int ch;

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            System.out.println(PrintUtil.ENTER_CHOICE_MESSAGE);
            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    queue.enqueue(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    System.out.println(queue.dequeue());
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
                case 4:
                    System.out.println(queue.empty());
                    break;
                case 5:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(queue.search(GenericUtil.takeIntegerInput()));
                    break;
                case 6:
                    System.out.println(queue.size());
                    break;
                case 7:
                    queue.display();
                    break;
            }

        } while (ch != 0);
    }
}