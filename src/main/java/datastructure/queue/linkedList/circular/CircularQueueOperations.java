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

package datastructure.queue.linkedList.circular;

import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CircularQueueOperations {

    private CircularQueue<Integer> mQueue;
    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final CircularQueueOperations circularQueueOperations = new CircularQueueOperations();
        circularQueueOperations.buildChoice();
        circularQueueOperations.initialize();
    }

    private void buildChoice() {
        mChoice = new ArrayList<>();
        mChoice.add("exit");
        mChoice.add("enqueue data to queue");
        mChoice.add("dequeue data from queue");
        mChoice.add("peek data from queue");
        mChoice.add("check if queue is empty");
        mChoice.add("search queue");
        mChoice.add("get queue size");
        mChoice.add("display the queue");
    }

    private void initialize() throws IOException {
        mQueue = new CircularQueue<>();
        int ch;

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mQueue.enqueue(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    System.out.println(mQueue.dequeue());
                    break;
                case 3:
                    System.out.println(mQueue.peek());
                    break;
                case 4:
                    System.out.println(mQueue.empty());
                    break;
                case 5:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mQueue.search(GenericUtil.takeIntegerInput()));
                    break;
                case 6:
                    System.out.println(mQueue.size());
                    break;
                case 7:
                    mQueue.display();
                    break;
            }

        } while (ch != 0);
    }
}