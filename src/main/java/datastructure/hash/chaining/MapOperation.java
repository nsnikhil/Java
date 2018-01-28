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

package datastructure.hash.chaining;

import static datastructure.hash.HashUtil.*;

/**
 * Class to perform action/operations
 * on chain hash table
 */
public final class MapOperation {

    public static void main(String... args) {
        final MapOperation mapOperation = new MapOperation();
        mapOperation.initialize();
    }

    /**
     * function that allows to perform operations
     * of chain hash table
     */
    private void initialize() {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(KEY_ONE, VALUE_ONE);
        myHashMap.put(KEY_TWO, VALUE_TWO);
        myHashMap.put(KEY_THREE, VALUE_THREE);
        myHashMap.put(KEY_FOUR, VALUE_FOUR);


        System.out.println(myHashMap.get(KEY_ONE));
        System.out.println(myHashMap.get(KEY_TWO));
        System.out.println(myHashMap.get(KEY_THREE));
        System.out.println(myHashMap.get(KEY_FOUR));
    }

}
