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
 * Given a string and a non-empty substring sub,
 * compute recursively if at least n copies of sub appear in the string somewhere,
 * possibly with overlapping. N will be non-negative.
 * <p>
 * strCopies("catcowcat", "cat", 2) → true
 * strCopies("catcowcat", "cow", 2) → false
 * strCopies("catcowcat", "cow", 1) → true
 */
public final class StrCopies {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE + " and " + GenericUtil.STRING_INPUT_SUB_MESSAGE + " and " + GenericUtil.INTEGER_INPUT_MESSAGE);
        System.out.println(new StrCopies().strCopies(GenericUtil.takeStringInput(), GenericUtil.takeStringInput(), GenericUtil.takeIntegerInput()));
    }

    private boolean strCopies(@NotNull final String str, @NotNull final String sub, final int n) {
        if (n == 0) return true;
        if (str.length() < sub.length()) return false;
        if (str.substring(0, sub.length()).equals(sub))
            return strCopies(str.substring(1), sub, n - 1);
        return strCopies(str.substring(1), sub, n);
    }
}