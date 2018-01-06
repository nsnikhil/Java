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
 * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies (1, 3, ..) have the normal 2 ears.
 * The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
 * Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
 * <p>
 * bunnyEars2(0) → 0
 * bunnyEars2(1) → 2
 * bunnyEars2(2) → 5
 */
public final class BunnyEars2 {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
        System.out.println(new BunnyEars2().bunnyEars2(GenericUtil.takeIntegerInput()));
    }

    private int bunnyEars2(final int bunnies) {
        if (bunnies == 0) return 0;
        if (bunnies % 2 == 0) return 3 + bunnyEars2(bunnies - 1);
        return 2 + bunnyEars2(bunnies - 1);
    }
}