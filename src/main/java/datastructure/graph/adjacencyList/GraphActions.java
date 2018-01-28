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

import datastructure.graph.util.GraphUtil;
import datastructure.linkedlist.LinkedList;
import org.jetbrains.annotations.NotNull;

/**
 * Action/Functions performed on
 * Adjacency list representation of a
 * graph
 */
public class GraphActions {

    /**
     * Returns array of connected vertices to a given
     * vertex
     *
     * @param vertex      the vertex whose adjacent vertices are to be found
     * @param graphObject the graph
     * @return array of vertices adjacent to given vertex
     */
    public static Character[] getAdjacentNodes(final Character vertex, @NotNull final GraphObject<Character> graphObject) {
        return GraphUtil.getNodesFromIndex(listToArray(graphObject.getEdgeList().get(GraphUtil.getVertexIndex(vertex, graphObject.getVertex()))), graphObject.getVertex());
    }

    /**
     * Converts a given linked list of integer to array
     *
     * @param linkedList the linked list to be converted
     * @return array which contains all the elements of a given linked list
     */
    private static Integer[] listToArray(LinkedList<Integer> linkedList) {
        return listToArrayUtil(linkedList, linkedList.getSize(), new Integer[linkedList.getSize()], 0);
    }

    /**
     * Converts a given linked list of integer to array
     *
     * @param linkedList the linked list to be converted
     * @param listSize   the size of linked list
     * @param ar         the array in which elements has to be copied
     * @param index      the index at which the copying will start
     * @return array which contains all the elements of a given linked list
     */
    private static Integer[] listToArrayUtil(final LinkedList<Integer> linkedList, final int listSize, final Integer[] ar, final int index) {
        if (listSize == index) return ar;
        ar[index] = linkedList.getAtPosition(index);
        return listToArrayUtil(linkedList, listSize, ar, index + 1);
    }

    /**
     * Returns true if given two vertices are connected else !true
     *
     * @param first       the first vertex
     * @param second      the second vertex
     * @param graphObject the graph
     * @return true if given two vertices are connected else !true
     */
    public static boolean areConnected(final Character first, final Character second, @NotNull final GraphObject<Character> graphObject) {
        return graphObject.getEdgeList().get(GraphUtil.getVertexIndex(first, graphObject.getVertex())).searchByItem(GraphUtil.getVertexIndex(second, graphObject.getVertex()));
    }
}
