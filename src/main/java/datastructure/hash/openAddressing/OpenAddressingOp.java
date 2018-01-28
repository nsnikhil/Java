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

package datastructure.hash.openAddressing;

import static datastructure.hash.HashUtil.*;

/**
 * Class demonstrating the three open addressing
 * techniques
 */
public class OpenAddressingOp {

    public static void main(String... args) {
        new OpenAddressingOp().initialize();
    }

    /**
     * Calls all the open addressing methods
     */
    private void initialize() {
        setLinearProbing();
        System.out.println("_____");
        setQuadraticProbing();
        System.out.println("_____");
        setDoubleHashing();
    }

    /**
     * Function to demonstrate linear probing
     */
    private void setLinearProbing() {
        final LinearProbing linearProbing = new LinearProbing();

        linearProbing.put(KEY_ONE, VALUE_ONE);
        linearProbing.put(KEY_TWO, VALUE_TWO);
        linearProbing.put(KEY_THREE, VALUE_THREE);
        linearProbing.put(KEY_FOUR, VALUE_FOUR);

        System.out.println(linearProbing.get(KEY_ONE));
        System.out.println(linearProbing.get(KEY_TWO));
        System.out.println(linearProbing.get(KEY_THREE));
        System.out.println(linearProbing.get(KEY_FOUR));
    }

    /**
     * Function to demonstrate quadratic probing
     */
    private void setQuadraticProbing() {
        final QuadraticProbing quadraticProbing = new QuadraticProbing();

        quadraticProbing.put(KEY_ONE, VALUE_ONE);
        quadraticProbing.put(KEY_TWO, VALUE_TWO);
        quadraticProbing.put(KEY_THREE, VALUE_THREE);
        quadraticProbing.put(KEY_FOUR, VALUE_FOUR);

        System.out.println(quadraticProbing.get(KEY_ONE));
        System.out.println(quadraticProbing.get(KEY_TWO));
        System.out.println(quadraticProbing.get(KEY_THREE));
        System.out.println(quadraticProbing.get(KEY_FOUR));
    }

    /**
     * Function to demonstrate double hashing
     */
    private void setDoubleHashing() {
        final DoubleHashing doubleHashing = new DoubleHashing();

        doubleHashing.put(KEY_ONE, VALUE_ONE);
        doubleHashing.put(KEY_TWO, VALUE_TWO);
        doubleHashing.put(KEY_THREE, VALUE_THREE);
        doubleHashing.put(KEY_FOUR, VALUE_FOUR);

        System.out.println(doubleHashing.get(KEY_ONE));
        System.out.println(doubleHashing.get(KEY_TWO));
        System.out.println(doubleHashing.get(KEY_THREE));
        System.out.println(doubleHashing.get(KEY_FOUR));
    }

}
