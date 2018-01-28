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
 * Given a string and a non-empty substring sub, compute recursively the largest substring which starts and ends with sub and return its length.
 * <p>
 * strDist("catcowcat", "cat") → 9
 * strDist("catcowcat", "cow") → 3
 * strDist("cccatcowcatxx", "cat") → 9
 */
public final class StrDist {

    public static void main(String[] args) throws IOException {
        System.out.println(GenericUtil.STRING_INPUT_MESSAGE + " and " + GenericUtil.STRING_INPUT_SUB_MESSAGE);
        System.out.println(new StrDist().strDist(GenericUtil.takeStringInput(), GenericUtil.takeStringInput()));
    }

    /**
     * @param str the string
     * @param sub sub string
     * @return ??
     */
    private int strDist(@NotNull final String str, @NotNull final String sub) {
        //TODO
        return Integer.MIN_VALUE;
    }
}
