package datastructure.stack;

import util.GenericUtil;

import java.io.IOException;

public class ReverseString {

    private Stack<Character> mCharacterStack;
    private Stack<Integer> mIntegerStack;

    public static void main(String... args) throws IOException {
        ReverseString reverseString = new ReverseString();
        reverseString.initialize();
    }

    private void initialize() throws IOException {
        mCharacterStack = new Stack<>();
        mIntegerStack = new Stack<>();
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE);
        reverseString(GenericUtil.takeStringInput());
        System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
        reverseInteger(GenericUtil.takeIntegerInput());
    }

    /**
     * each element of the string is pushed to stack
     * and then each element is pop and printed out
     *
     * @param s the string to be reversed
     */
    private void reverseString(String s) {
        for (int i = 0; i < s.length(); i++)
            mCharacterStack.push(s.charAt(i));
        while (!mCharacterStack.empty())
            System.out.print(mCharacterStack.pop());
    }

    /**
     * get the no of digits
     * push the first element by dividing the no as
     * no/(10 raised to (no of digits-1))
     * and reduce the integer by removing the first
     * digit
     * <p>
     * Eg -> 5894
     * <p>
     * no of digits = 4
     * div = 10 raised to no of digits -1 = 10 raised to 3
     * divide 5894/div => 5894/1000 = 5
     * push 5 to stack
     * and number = number % div => 5894 % 1000 = 894
     * and continue until every digit is pushed to stack
     * <p>
     * and finally pop and print the numbers.
     *
     * @param integer the number to be reversed
     */
    private void reverseInteger(int integer) {
        int size = getNoOfDigits(integer);
        while (size > 0) {
            int div = (int) Math.pow(10, size - 1);
            mIntegerStack.push(integer / div);
            integer = integer % div;
            size--;
        }
        while (!mIntegerStack.empty())
            System.out.print(mIntegerStack.pop());
    }

    /**
     * @param no the integer
     * @return the no of digits in the integer
     */
    private int getNoOfDigits(int no) {
        if (Math.abs(no) < 1) return 0;
        return 1 + getNoOfDigits(no / 10);
    }
}