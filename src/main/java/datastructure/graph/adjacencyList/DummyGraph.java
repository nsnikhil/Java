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

package datastructure.graph.adjacencyList;

import datastructure.linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Graph :
 * <p>
 * A  ----   B
 * /  \      /  \
 * C    D    E   F
 * \    \   /    /
 * G -- H ----/
 * <p>
 * Vertices : A,B,C,D,E,F,G,H
 * <p>
 * Edges : A-B, A-C, A-D, B-E. B-F, C-G, D-H, E-H, F-H, G-H
 * <p>
 * Vertex List :
 * 0 - A
 * 1 - B
 * 2 - C
 * 3 - D
 * 4 - E
 * 5 - F
 * 6 - G
 * 7 - H
 * <p>
 * Edge Array Linked List :
 * <p>
 * List Index = LinkedList
 * 0          = 1 -> 2 -> 3 -> null
 * 1          = 0 -> 4 -> 5 -> null
 * 2          = 0 -> 6 -> null
 * 3          = 0 -> 7 -> null
 * 4          = 1 -> 7 -> null
 * 5          = 1 -> 7 -> null
 * 6          = 2 -> 7 -> null
 * 7          = 3 -> 4 -> 5 -> 6 -> null
 * <p>
 * This class uses a lot of statements sorry for that
 */
class DummyGraph {

    /**
     *
     */
    static final List<Character> VERTICES = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

    /**
     * Creation a array of generic is a bad thing i know that and will change later
     */
    static final List<LinkedList<Integer>> EDGE_LIST_NON_WEIGHTED = new ArrayList<>();

    /*
     *
     */
    static {

        LinkedList<Integer> firstList = new LinkedList<>();
        firstList.insertLast(1);
        firstList.insertLast(2);
        firstList.insertLast(3);

        LinkedList<Integer> secondList = new LinkedList<>();
        secondList.insertLast(0);
        secondList.insertLast(4);
        secondList.insertLast(5);

        LinkedList<Integer> thirdList = new LinkedList<>();
        thirdList.insertLast(0);
        thirdList.insertLast(6);

        LinkedList<Integer> fourthList = new LinkedList<>();
        fourthList.insertLast(0);
        fourthList.insertLast(7);

        LinkedList<Integer> fifthList = new LinkedList<>();
        fifthList.insertLast(1);
        fifthList.insertLast(7);

        LinkedList<Integer> sixthList = new LinkedList<>();
        sixthList.insertLast(1);
        sixthList.insertLast(7);

        LinkedList<Integer> seventhList = new LinkedList<>();
        seventhList.insertLast(2);
        seventhList.insertLast(7);

        LinkedList<Integer> eighthList = new LinkedList<>();
        eighthList.insertLast(3);
        eighthList.insertLast(4);
        eighthList.insertLast(5);
        eighthList.insertLast(6);

        EDGE_LIST_NON_WEIGHTED.add(firstList);
        EDGE_LIST_NON_WEIGHTED.add(secondList);
        EDGE_LIST_NON_WEIGHTED.add(thirdList);
        EDGE_LIST_NON_WEIGHTED.add(fourthList);
        EDGE_LIST_NON_WEIGHTED.add(fifthList);
        EDGE_LIST_NON_WEIGHTED.add(sixthList);
        EDGE_LIST_NON_WEIGHTED.add(seventhList);
        EDGE_LIST_NON_WEIGHTED.add(eighthList);
    }

}
