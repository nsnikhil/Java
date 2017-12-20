package datastructure.stack;

import util.GenericUtil;

import java.io.IOException;

public class StackOperations {

    private Stack<Integer> mStack;

    public static void main(String... args) throws IOException {
        StackOperations stackOperations = new StackOperations();
        stackOperations.initialize();
    }

    private void initialize() throws IOException {
        int ch;
        mStack = new Stack<>();
        do {
            System.out.println("\nEnter 1 to push data to stack\n" +
                    "Enter 2 to pop data from stack\n" +
                    "Enter 3 to peek data from stack\n" +
                    "Enter 4 check if stack is empty\n" +
                    "Enter 5 to search stack\n" +
                    "Enter 6 to get stack size\n"+
                    "Enter 7 to display the stack\n" +
                    "Enter 0 to exit\n");
            ch = GenericUtil.takeIntegerInput();
            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mStack.push(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    System.out.println(mStack.pop());
                    break;
                case 3:
                    System.out.println(mStack.peek());
                    break;
                case 4:
                    System.out.println(mStack.empty());
                    break;
                case 5:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mStack.search(GenericUtil.takeIntegerInput()));
                    break;
                case 6:
                    System.out.println(mStack.size());
                    break;
                case 7:
                    mStack.display();
                    break;
            }
        } while (ch != 0);
    }
}