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

import java.io.IOException;

public class CircularQueueOperations {

    private CircularQueueArray mCircularQueueArray;

    public static void main(String... args) throws IOException {
        CircularQueueOperations circularQueueOperations = new CircularQueueOperations();
        circularQueueOperations.initialize();
    }

    private void initialize() throws IOException {
        int ch, size;

        System.out.println(GenericUtil.INTEGER_INPUT_SIZE);
        size = GenericUtil.takeIntegerInput();

        mCircularQueueArray = new CircularQueueArray(size);

        do {

            System.out.println("\nEnter 1 to enqueue data to queue\n" +
                    "Enter 2 to dequeue data from queue\n" +
                    "Enter 3 to get front\n" +
                    "Enter 4 to get rear\n" +
                    "Enter 5 check if queue is empty\n" +
                    "Enter 6 check if queue is full\n" +
                    "Enter 7 to search queue\n" +
                    "Enter 8 to display the queue\n" +
                    "Enter 0 to exit\n");

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
