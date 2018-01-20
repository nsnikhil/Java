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

package datastructure.hash;


import util.PrintUtil;

import java.util.Arrays;
import java.util.List;

public final class MapOperation {

    private MyHashMap mMyHashMap;
    private List<String> mChoice;

    public static void main(String... args) {
        final MapOperation mapOperation = new MapOperation();
        //mapOperation.buildChoice();
        mapOperation.initialize();
    }

    private void buildChoice() {
        mChoice = PrintUtil.getPrintList(Arrays.asList(
                "add",
                "get"));
    }

    private void initialize() {
        mMyHashMap = new MyHashMap();

        mMyHashMap.put("nikhil", 80134);
        mMyHashMap.put("chanchal", 98366);
        mMyHashMap.put("rewant", 98367);
        mMyHashMap.put("sidharth", 70036);

        System.out.println(mMyHashMap.get("nikhil"));
    }

}
