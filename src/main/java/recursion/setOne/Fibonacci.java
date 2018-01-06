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

package recursion.setOne;

import util.GenericUtil;

import java.io.IOException;

/**
 * The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition.
 * The first two values in the sequence are 0 and 1 (essentially 2 base cases).
 * Each subsequent value is the sum of the previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
 * Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n=0 representing the start of the sequence.
 * <p>
 * fibonacci(0) → 0
 * fibonacci(1) → 1
 * fibonacci(2) → 1
 */
public final class Fibonacci {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
        System.out.println(new Fibonacci().fibonacci(GenericUtil.takeIntegerInput()));
    }

    private int fibonacci(final int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}