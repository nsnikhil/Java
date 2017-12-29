package datastructure.queue.array;

import util.GenericUtil;

import java.io.IOException;

public class QueueOperations {

    private Queue mQueue;

    public static void main(String... args) throws IOException {
        final QueueOperations queueOperations = new QueueOperations();
        queueOperations.initialize();
    }

    private void initialize() throws IOException {
        int ch;

        System.out.println(GenericUtil.INTEGER_INPUT_SIZE);
        mQueue = new Queue(GenericUtil.takeIntegerInput());

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