package datastructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {

    private BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private Stack<Character> mCharacterStack;
    private Stack<Integer> mIntegerStack;

    public static void main(String... args) throws IOException {
        ReverseString reverseString = new ReverseString();
        reverseString.initialize();
    }

    private void initialize() throws IOException {
        mCharacterStack = new Stack<>();
        mIntegerStack = new Stack<>();
        reverseString(takeInput("string"));
        System.out.println();
        reverseInteger(Integer.parseInt(takeInput("no")));
    }

    private void reverseString(String s) {
        for (int i = 0; i < s.length(); i++) {
            mCharacterStack.push(s.charAt(i));
        }
        while (!mCharacterStack.empty()) {
            System.out.print(mCharacterStack.pop());
        }
    }

    private void reverseInteger(int integer) {
        int size = getNoOfDigits(integer);
        while (size > 0) {
            int div = (int) Math.pow(10, size - 1);
            mIntegerStack.push(integer / div);
            integer = integer % div;
            size--;
        }
        while (!mIntegerStack.empty()) {
            System.out.print(mIntegerStack.pop());
        }

    }

    private int getNoOfDigits(int no) {
        if (Math.abs(no) < 1) {
            return 0;
        }
        return 1 + getNoOfDigits(no / 10);
    }

    private String takeInput(String message) throws IOException {
        System.out.println("Enter the " + message);
        return mBufferedReader.readLine();
    }

}
