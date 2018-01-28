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

import org.jetbrains.annotations.NotNull;
import util.GenericUtil;

import java.io.IOException;

/**
 * We'll say that a "pair" in a string is two instances of a char separated by a char. So "AxA" the A's make a pair.
 * Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number of pairs in the given string.
 * <p>
 * <p>
 * countPairs("axa") → 1
 * countPairs("axax") → 2
 * countPairs("axbx") → 1
 */
public final class CountPairs {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE);
        System.out.println(new CountPairs().countPairs(GenericUtil.takeStringInput()));
    }

    /**
     * @param str the string
     * @return no of pairs in string
     */
    private int countPairs(@NotNull final String str) {
        if (str.length() < 3) return 0;
        if (str.charAt(0) == str.charAt(2))
            return 1 + countPairs(str.substring(1));
        return countPairs(str.substring(1));
    }
}