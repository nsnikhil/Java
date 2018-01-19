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

package recursion.setTwo;

import org.jetbrains.annotations.NotNull;
import util.ArrayUtil;
import util.GenericUtil;

import java.io.IOException;

/**
 * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the given target?
 * This is a classic backtracking recursion problem. Once you understand the recursive backtracking strategy in this problem,
 * you can use the same pattern for many problems to search a space of choices. Rather than looking at the whole array,
 * our convention is to consider the part of the array starting at index start and continuing to the end of the array.
 * The caller can specify the whole array simply by passing start as 0. No loops are needed -- the recursive calls progress down the array.
 * <p>
 * groupSum(0, [2, 4, 8], 10) → true
 * groupSum(0, [2, 4, 8], 14) → true
 * groupSum(0, [2, 4, 8],
 */
public final class GroupSum {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE + " and " + ArrayUtil.ARRAY_INPUT_SIZE + " and " + ArrayUtil.ARRAY_ELEMENTS_INPUTS + " and " + GenericUtil.INTEGER_INPUT_MESSAGE);
        System.out.println(new GroupSum().groupSum(GenericUtil.takeIntegerInput(), ArrayUtil.takeArrayInput(), GenericUtil.takeIntegerInput()));
    }

    private boolean groupSum(final Integer start, @NotNull final Integer[] nums, final Integer target) {
        //TODO
        return false;
    }

}
