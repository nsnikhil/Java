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
 * Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza".
 * <p>
 * <p>
 * stringClean("yyzzza") → "yza"
 * stringClean("abbbcdd") → "abcd"
 * stringClean("Hello") → "Helo"
 */
public final class StringClean {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE);
        System.out.println(new StringClean().stringClean(GenericUtil.takeStringInput()));
    }

    private String stringClean(@NotNull final String str) {
        if (str.length() < 2) return str;
        if (str.charAt(0) == str.charAt(1))
            return stringClean(str.substring(1));
        return str.charAt(0) + stringClean(str.substring(1));
    }
}