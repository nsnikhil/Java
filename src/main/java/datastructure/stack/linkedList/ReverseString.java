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

package datastructure.stack.linkedList;

import org.jetbrains.annotations.NotNull;
import util.GenericUtil;

import java.io.IOException;

/**
 * Class to demonstrate revering of given
 * Integer or String using stack
 */
public class ReverseString {

    private Stack<Character> mCharacterStack;
    private Stack<Integer> mIntegerStack;

    public static void main(String... args) throws IOException {
        final ReverseString reverseString = new ReverseString();
        reverseString.initialize();
    }

    /**
     * @throws IOException IOException
     */
    private void initialize() throws IOException {
        mCharacterStack = new Stack<>();
        mIntegerStack = new Stack<>();
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE);
        reverseString(GenericUtil.takeStringInput());
        System.out.println("\n" + GenericUtil.INTEGER_INPUT_MESSAGE);
        reverseInteger(GenericUtil.takeIntegerInput());
    }

    /**
     * each element of the string is pushed to stack
     * and then each element is pop and printed out
     *
     * @param s the string to be reversed
     */
    private void reverseString(@NotNull final String s) {
        pushString(s, mCharacterStack);
        while (!mCharacterStack.empty())
            System.out.print(mCharacterStack.pop());
    }

    /**
     * Push a given string in a given stack
     *
     * @param s     the string
     * @param stack the stack
     */
    private void pushString(@NotNull final String s, final Stack<Character> stack) {
        if (s.length() <= 0) return;
        stack.push(s.charAt(0));
        pushString(s.substring(1), stack);
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
    private void reverseInteger(final int integer) {
        pushInteger(integer, mIntegerStack, getNoOfDigits(integer));
        while (!mIntegerStack.empty())
            System.out.print(mIntegerStack.pop());
    }

    /**
     * Push a given integer in a given stack
     *
     * @param integer the integer
     * @param stack   the stack
     * @param size    no of digits in integer
     */
    private void pushInteger(final int integer, final Stack<Integer> stack, int size) {
        if (size < 1) return;
        final int div = (int) Math.pow(10, size - 1);
        stack.push(integer / div);
        pushInteger(integer % div, stack, --size);
    }

    /**
     * @param no the integer
     * @return the no of digits in the integer
     */
    private int getNoOfDigits(final int no) {
        if (Math.abs(no) < 1) return 0;
        return 1 + getNoOfDigits(no / 10);
    }
}