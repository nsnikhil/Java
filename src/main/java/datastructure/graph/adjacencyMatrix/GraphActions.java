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

package datastructure.graph.adjacencyMatrix;

import datastructure.graph.util.GraphUtil;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public final class GraphActions {

    /**
     * @param edge
     * @return
     */
    private static Integer[] getAdjacentIndex(final Integer[] edge) {
        return getAdjacentIndex(edge, 0, edge.length, new Integer[edge.length], 0);
    }

    /**
     *
     * @param edge
     * @param index
     * @param size
     * @param temp
     * @param tempIndex
     * @return
     */
    private static Integer[] getAdjacentIndex(final Integer[] edge, final int index, final int size, final Integer[] temp, final int tempIndex) {
        if (size == index) return temp;
        if (edge[index] != 0) {
            temp[tempIndex] = index;
            return getAdjacentIndex(edge, index + 1, size, temp, tempIndex + 1);
        }
        return getAdjacentIndex(edge, index + 1, size, temp, tempIndex);
    }

    /**
     *
     * @param vertex
     * @param graphObject
     * @return
     */
    public static Character[] getAdjacentNodes(final Character vertex, @NotNull final GraphObject<Character> graphObject) {
        return GraphUtil.getNodesFromIndex(getAdjacentIndex(graphObject.getEdges()[GraphUtil.getVertexIndex(vertex, graphObject.getVertices())]), graphObject.getVertices());
    }

    /**
     *
     * @param first
     * @param second
     * @param graphObject
     * @return
     */
    public static boolean areConnected(final Character first, final Character second, @NotNull final GraphObject<Character> graphObject) {
        return graphObject.getEdges()[GraphUtil.getVertexIndex(first, graphObject.getVertices())][GraphUtil.getVertexIndex(second, graphObject.getVertices())] == 1;
    }
}
