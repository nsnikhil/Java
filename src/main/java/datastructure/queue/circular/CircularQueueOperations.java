package datastructure.queue.circular;

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
