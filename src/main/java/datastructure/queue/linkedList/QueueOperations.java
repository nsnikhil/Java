package datastructure.queue.linkedList;

import util.GenericUtil;

import java.io.IOException;

public class QueueOperations {

    private Queue<Integer> mQueue;

    public static void main(String... args) throws IOException {
        final QueueOperations queueOperations = new QueueOperations();
        queueOperations.initialize();
    }

    private void initialize() throws IOException {
        mQueue = new Queue<>();
        int ch;

        do{

            System.out.println("\nEnter 1 to enqueue data to queue\n" +
                    "Enter 2 to dequeue data from queue\n" +
                    "Enter 3 to peek data from queue\n" +
                    "Enter 4 check if queue is empty\n" +
                    "Enter 5 to search queue\n" +
                    "Enter 6 to get queue size\n"+
                    "Enter 7 to display the queue\n" +
                    "Enter 0 to exit\n");

            ch = GenericUtil.takeIntegerInput();

            switch (ch){
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

        }while (ch!=0);
    }
}