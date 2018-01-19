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

import datastructure.linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap implements MapInterface<String, Integer> {

    private List<LinkedList<Integer>> mDataList;

    MyHashMap() {
        mDataList = new ArrayList<>(MapInterface.DEFAULT_HASH_TABLE_SIZE);
    }

    @Override
    public void put(String key, Integer data) {
        mDataList.get(getIndex(getHashCode(key))).insertLast(data);
    }

    @Override
    public Integer get(String key) {
        return null;
    }

    @Override
    public Integer getHashCode(String key) {
        return null;
    }

    @Override
    public Integer getIndex(Integer hashCode) {
        return null;
    }
}
