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
import util.ArrayUtil;
import util.GenericUtil;

import java.io.IOException;

/**
 * Given an array of ints, compute recursively if the array contains a 6.
 * We'll use the convention of considering only the part of the array that begins at the given index.
 * In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
 * <p>
 * array6([1, 6, 4], 0) → true
 * array6([1, 4], 0) → false
 * array6([6], 0) → true
 */
public final class Array6 {

    public static void main(String... args) throws IOException {
        System.out.println(ArrayUtil.ARRAY_INPUT_SIZE + " and " + ArrayUtil.ARRAY_ELEMENTS_INPUTS + " and " + GenericUtil.INTEGER_INPUT_MESSAGE);
        System.out.println(new Array6().array6(ArrayUtil.takeArrayInput(), GenericUtil.takeIntegerInput()));
    }

    private boolean array6(@NotNull final Integer[] nums, final Integer index) {
        return index < nums.length && (nums[index] == 6 || array6(nums, index + 1));
    }
}
