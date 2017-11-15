package datastructure.stack;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackOperations {

    private BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(System.in));
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

            ch = Integer.parseInt(mBufferedReader.readLine());

            switch (ch) {
                case 1:
                    mStack.push(takeInput("no"));
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
                    System.out.println(mStack.search(takeInput("no")));
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

    @NotNull
    private Integer takeInput(String message) throws IOException {
        System.out.println("Enter the " + message);
        return Integer.valueOf(mBufferedReader.readLine());
    }

}
