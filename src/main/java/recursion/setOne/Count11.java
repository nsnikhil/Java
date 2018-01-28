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
 * Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap.
 * <p>
 * count11("11abc11") → 2
 * count11("abc11x11x11") → 3
 * count11("111") → 1
 */
public final class Count11 {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE);
        System.out.println(new Count11().count11(GenericUtil.takeStringInput()));
    }

    /**
     * @param str the string
     * @return no of 11 in string
     */
    private int count11(@NotNull final String str) {
        if (str.length() < 2) return 0;
        if (str.substring(0, 2).equals("11"))
            return 1 + count11(str.substring(2));
        return count11(str.substring(1));
    }
}
