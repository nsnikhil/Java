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
 * We have triangle made of blocks. The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on.
 * Compute recursively (no loops or multiplication) the total number of blocks in such a triangle with the given number of rows.
 * <p>
 * triangle(0) → 0
 * triangle(1) → 1
 * triangle(2) → 3
 */
public final class Triangle {

    public static void main(String... args) throws IOException {
        System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
        System.out.println(new Triangle().triangle(GenericUtil.takeIntegerInput()));
    }

    /**
     * @param rows no of rows
     * @return no of triangle blocks in given rows
     */
    private int triangle(final int rows) {
        if (rows <= 1) return rows;
        return rows + triangle(rows - 1);
    }
}