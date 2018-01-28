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
 * Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".
 * <p>
 * allStar("hello") → "h*e*l*l*o"
 * allStar("abc") → "a*b*c"
 * allStar("ab") → "a*b"
 */
public final class AllStar {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE);
        System.out.println(new AllStar().allStar(GenericUtil.takeStringInput()));
    }

    /**
     * Recurse until length of string is less than or equals to 1
     * and during each step take the first character concat it with *
     * and call the function again by removing the first character
     * using substring
     * <p>
     * allStar(abc)
     * <p>
     * first line checks if the length of string is less than or equals to 1
     * <p>
     * here length is 3 so if condition is not executed
     * <p>
     * then charAt(0) i.e. first character is concatenated with *
     * to from a* which is again concatenated with allStar(bc)
     * which would return b*c
     * to finally return a*b*c
     *
     * @param str the string
     * @return modified string
     */
    private String allStar(@NotNull final String str) {
        if (str.length() <= 1) return str;
        return str.charAt(0) + "*" + allStar(str.substring(1));
    }
}