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

public class GraphActions {

    public static Character[] getAdjacentNodes(final Character vertex, @NotNull final GraphObject<Character> graphObject) {
        return GraphUtil.getNodesFromIndex(listToArray(graphObject.getEdgeList().get(GraphUtil.getVertexIndex(vertex, graphObject.getVertex()))), graphObject.getVertex());
    }

    private static Integer[] listToArray(LinkedList<Integer> linkedList) {
        return listToArray(linkedList, linkedList.getSize(), new Integer[linkedList.getSize()], 0);
    }

    private static Integer[] listToArray(final LinkedList<Integer> linkedList, final int listSize, final Integer[] ar, final int index) {
        if (listSize == index) return ar;
        ar[index] = linkedList.getAtPosition(index);
        return listToArray(linkedList, listSize, ar, index + 1);
    }

    public static boolean areConnected(final Character first, final Character second, @NotNull final GraphObject<Character> graphObject) {
        return graphObject.getEdgeList().get(GraphUtil.getVertexIndex(first, graphObject.getVertex())).searchByItem(GraphUtil.getVertexIndex(second, graphObject.getVertex()));
    }
}
