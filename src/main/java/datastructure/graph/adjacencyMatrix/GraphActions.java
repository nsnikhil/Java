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

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class GraphActions {

    private static int getVertexIndex(final Character vertex, final List<Character> vertexList) {
        return getVertexIndex(vertex, vertexList, 0, vertexList.size());
    }

    private static int getVertexIndex(final Character vertex, final List<Character> vertexList, final int index, final int size) {
        if (size == index) return index;
        if (vertexList.get(index).equals(vertex)) return index;
        return getVertexIndex(vertex, vertexList, index + 1, size);
    }

    private static Integer[] getAdjacentIndex(final Integer[] edge) {
        return getAdjacentIndex(edge, 0, edge.length, new Integer[edge.length], 0);
    }

    private static Integer[] getAdjacentIndex(final Integer[] edge, final int index, final int size, final Integer[] temp, final int tempIndex) {
        if (size == index) return temp;
        if (edge[index] != 0) {
            temp[tempIndex] = index;
            return getAdjacentIndex(edge, index + 1, size, temp, tempIndex + 1);
        }
        return getAdjacentIndex(edge, index + 1, size, temp, tempIndex);
    }

    @Contract(pure = true)
    private static Character[] getNodesFromIndex(@NotNull final Integer[] index, @NotNull final List<Character> vertexList) {
        return getNodesFromIndex(index, vertexList, new Character[index.length], 0);
    }

    private static Character[] getNodesFromIndex(final Integer[] indexes, @NotNull final List<Character> vertexList, final Character[] charArray, final int index) {
        if (indexes[index] == null) return charArray;
        charArray[index] = vertexList.get(indexes[index]);
        return getNodesFromIndex(indexes, vertexList, charArray, index + 1);
    }

    public static Character[] getAdjacentNodes(final Character vertex, @NotNull final GraphObject<Character> graphObject) {
        return getNodesFromIndex(getAdjacentIndex(graphObject.getEdges()[getVertexIndex(vertex, graphObject.getVertices())]), graphObject.getVertices());
    }

    public static boolean areConnected(final Character first, final Character second, @NotNull final GraphObject<Character> graphObject) {
        return graphObject.getEdges()[getVertexIndex(first, graphObject.getVertices())][getVertexIndex(second, graphObject.getVertices())] == 1;
    }
}
