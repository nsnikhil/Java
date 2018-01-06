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
 * Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
 * <p>
 * countAbc("abc") → 1
 * countAbc("abcxxabc") → 2
 * countAbc("abaxxaba") → 2
 */
public final class CountAbc {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE);
        System.out.println(new CountAbc().countAbc(GenericUtil.takeStringInput()));
    }

    private int countAbc(@NotNull final String str) {
        final int length = str.length();
        if (length < 3) return 0;
        if (str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba"))
            return 1 + countAbc(str.substring(1));
        return countAbc(str.substring(1));
    }
}