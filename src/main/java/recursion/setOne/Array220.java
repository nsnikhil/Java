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
 * Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10.
 * We'll use the convention of considering only the part of the array that begins at the given index.
 * In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
 * <p>
 * array220([1, 2, 20], 0) → true
 * array220([3, 30], 0) → true
 * array220([3], 0) → false
 */
public final class Array220 {

    public static void main(String... args) throws IOException {
        System.out.println(ArrayUtil.ARRAY_INPUT_SIZE + "" + ArrayUtil.ARRAY_ELEMENTS_INPUTS + "" + GenericUtil.INTEGER_INPUT_MESSAGE);
        System.out.println(new Array220().array220(ArrayUtil.takeArrayInput(), GenericUtil.takeIntegerInput()));
    }

    /**
     * @param nums  the array
     * @param index the starting index
     * @return true if a array contains a number in higher index which
     * is a 10times that of a value in lower index
     */
    private boolean array220(@NotNull final Integer[] nums, final Integer index) {
        //TODO
        return false;
    }

}
