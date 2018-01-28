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
 * Given a string, compute recursively the number of times lowercase "hi" appears in the string,
 * however do not count "hi" that have an 'x' immedately before them.
 * <p>
 * countHi2("ahixhi") → 1
 * countHi2("ahibhi") → 2
 * countHi2("xhixhi") → 0
 */
public final class CountHi2 {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE);
        System.out.println(new CountHi2().countHi2(GenericUtil.takeStringInput()));
    }

    /**
     * @param str the string
     * @return no of hi in string(if hi followed by x it is not counted)
     */
    private int countHi2(@NotNull final String str) {
        final int length = str.length();
        if (length < 2) return 0;
        if (length > 2 && str.substring(0, 3).equals("xhi"))
            return countHi2(str.substring(3));
        if (str.substring(0, 2).equals("hi"))
            return 1 + countHi2(str.substring(1));
        return countHi2(str.substring(1));
    }
}