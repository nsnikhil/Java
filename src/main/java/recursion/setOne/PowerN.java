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

import util.GenericUtil;

import java.io.IOException;

/**
 * Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
 * <p>
 * powerN(3, 1) → 3
 * powerN(3, 2) → 9
 * powerN(3, 3) → 27
 */
public final class PowerN {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE + " and " + GenericUtil.INTEGER_INPUT_MESSAGE);
        System.out.println(new PowerN().powerN(GenericUtil.takeIntegerInput(), GenericUtil.takeIntegerInput()));
    }

    private int powerN(final int base, final int n) {
        if (n <= 1) return base;
        return base * powerN(base, n - 1);
    }
}