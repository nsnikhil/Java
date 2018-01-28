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
 * Action/Functions performed on
 * Adjacency matrix representation of a
 * graph
 */
public final class GraphActions {

    /**
     * Returns the index of all the vertices that are connected
     * to a given node
     *
     * @param edge the row(vertex) whose adjacent vertices are to found
     * @return the array of rows connected to given row(vertex)
     */
    private static Integer[] getAdjacentIndex(final Integer[] edge) {
        return getAdjacentIndexUtil(edge, 0, edge.length, new Integer[edge.length], 0);
    }

    /**
     * Returns the index of all the vertices that are connected
     * to a given node
     *
     * @param edge      the row(vertex) whose adjacent vertices are to found
     * @param index     the starting point
     * @param size      the size of row
     * @param temp      the array where adjacent row value will be stored
     * @param tempIndex the index for temp
     * @return the array of rows connected to given row(vertex)
     */
    private static Integer[] getAdjacentIndexUtil(final Integer[] edge, final int index, final int size, final Integer[] temp, final int tempIndex) {
        if (size == index) return temp;
        if (edge[index] != 0) {
            temp[tempIndex] = index;
            return getAdjacentIndexUtil(edge, index + 1, size, temp, tempIndex + 1);
        }
        return getAdjacentIndexUtil(edge, index + 1, size, temp, tempIndex);
    }

    /**
     * Returns array of connected vertices to a given
     * vertex
     * <p>
     * From a given vertex find its index in 2d matrix
     * the index obtained will represent the row(vertex)
     * in the 2d matrix and for that row(vertex) find out
     * all the cells that have a value 1 and for those cells
     * with value 1 find their vertex name.
     * <p>
     * Eg:
     * <p>
     * vertex list :
     * a,b,c
     * <p>
     * graph :
     * 010
     * 101
     * 001
     * <p>
     * getAdjacentNodes(b,graph)
     * find index of b in graph = 1
     * so we will look at 1th row of matrix
     * i.e. 101
     * now find out cells that have value 1
     * i.e. 0,2 now
     * for these values find the corresponding
     * value in vertex list i.e. a,c
     * so adjacent vertices of b are a,c
     *
     * @param vertex      the vertex whose adjacent vertices are to be found
     * @param graphObject the graph
     * @return array of vertices connected to a given vertex
     */
    public static Character[] getAdjacentNodes(final Character vertex, @NotNull final GraphObject<Character> graphObject) {
        return GraphUtil.getNodesFromIndex(getAdjacentIndex(graphObject.getEdges()[GraphUtil.getVertexIndex(vertex, graphObject.getVertices())]), graphObject.getVertices());
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
        return graphObject.getEdges()[GraphUtil.getVertexIndex(first, graphObject.getVertices())][GraphUtil.getVertexIndex(second, graphObject.getVertices())] == 1;
    }
}
