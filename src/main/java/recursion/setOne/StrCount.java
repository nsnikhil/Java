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
 * Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping.
 * <p>
 * strCount("catcowcat", "cat") → 2
 * strCount("catcowcat", "cow") → 1
 * strCount("catcowcat", "dog") → 0
 */
public final class StrCount {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE + " and " + GenericUtil.STRING_INPUT_SUB_MESSAGE);
        System.out.println(new StrCount().strCount(GenericUtil.takeStringInput(), GenericUtil.takeStringInput()));
    }

    private int strCount(@NotNull final String str, @NotNull final String sub) {
        final int length = str.length();
        final int slength = sub.length();
        if (length < slength) return 0;
        if (str.substring(0, slength).equals(sub))
            return 1 + strCount(str.substring(slength), sub);
        return strCount(str.substring(1), sub);
    }
}