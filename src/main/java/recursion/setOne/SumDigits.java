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
 * Given a non-negative int n, return the sum of its digits recursively (no loops).
 * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
 * <p>
 * sumDigits(126) → 9
 * sumDigits(49) → 13
 * sumDigits(12) → 3
 */
public final class SumDigits {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
        System.out.println(new SumDigits().sumDigits(GenericUtil.takeIntegerInput()));
    }

    private int sumDigits(final int n) {
        if (n < 1) return 0;
        return n % 10 + sumDigits(n / 10);
    }
}
