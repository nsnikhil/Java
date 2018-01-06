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
 * Given a string that contains a single pair of parenthesis,
 * compute recursively a new string made of only of the parenthesis and their contents,
 * so "xyz(abc)123" yields "(abc)".
 * <p>
 * parenBit("xyz(abc)123") → "(abc)"
 * parenBit("x(hello)") → "(hello)"
 * parenBit("(xy)1") → "(xy)"
 */
public final class ParenBit {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE);
        System.out.println(new ParenBit().parenBit(GenericUtil.takeStringInput()));
    }

    private String parenBit(@NotNull final String str) {
        if (str.charAt(0) != '(')
            return parenBit(str.substring(1));
        if (str.charAt(str.length() - 1) != ')')
            return parenBit(str.substring(0, str.length() - 1));
        return str;
    }
}