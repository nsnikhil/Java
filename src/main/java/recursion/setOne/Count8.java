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
 * Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit,
 * except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4.
 * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
 * <p>
 * count8(8) → 1
 * count8(818) → 2
 * count8(8818) → 4
 */
public final class Count8 {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
        System.out.println(new Count8().count8(GenericUtil.takeIntegerInput()));
    }

    private int count8(final int n) {
        if (n < 8) return 0;
        if (n % 10 == 8 && (n / 10) % 10 == 8) return 2 + count8(n / 10);
        if (n % 10 == 8) return 1 + count8(n / 10);
        return count8(n / 10);
    }
}