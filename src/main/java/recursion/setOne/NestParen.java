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
 * Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))".
 * Suggestion: check the first and last chars, and then recur on what's inside them.
 * <p>
 * nestParen("(())") → true
 * nestParen("((()))") → true
 * nestParen("(((x))") → false
 */
public final class NestParen {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE);
        System.out.println(new NestParen().nestParen(GenericUtil.takeStringInput()));
    }

    /**
     * @param str the string
     * @return true if given no of braces are balanced
     */
    private boolean nestParen(@NotNull final String str) {
        return str.length() == 0 || str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')' && nestParen(str.substring(1, str.length() - 1));
    }
}