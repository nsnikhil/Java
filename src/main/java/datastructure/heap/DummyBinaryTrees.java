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

package datastructure.heap;

/**
 * Class with dummy/fake tree
 * Here tree are represented in array format
 * since heap is a complete n-ary(binary here) tree
 * and any tree which is a heap has a property
 * where left child is at  => 2*i+1
 * and right child is at -> 2*i+2
 * where i is the index of parent
 */
public final class DummyBinaryTrees {

    static final Integer[] TREE_ONE = {1, 2, 3, 4, 5, 6, 7};

    static final Integer[] TREE_TWO = {0, 5, 89, 4894, 84, 884, 88, 584};

    static final Integer[] TREE_THREE = {84, 2, 584, 84, -4468, 2564, -844};

    static final Integer[] TREE_FOUR = {84, -848, -1, -9, 74, -58, 238};

    static final Integer[] TREE_FIVE = {-5, -4, -48, -84, -5488, -448, -7484, -545};
}
