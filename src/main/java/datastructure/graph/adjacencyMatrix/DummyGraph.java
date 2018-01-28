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
 * Edge Matrix :
 * <p>
 * <p>
 * 0  1  2  3  4  5  6  7
 * _______________________
 * 0  |0  1  1  1  0  0  0  0
 * |
 * 1  |1  0  0  0  1  1  0  0
 * |
 * 2  |1  0  0  0  0  0  1  0
 * |
 * 3  |1  0  0  0  0  0  0  1
 * |
 * 4  |0  1  0  0  0  0  0  1
 * |
 * 5  |0  1  0  0  0  0  0  1
 * |
 * 6  |0  0  1  0  0  0  0  1
 * |
 * 7  |0  0  0  1  1  1  1  0
 * <p>
 * 1 - represents a direct connection between the vertices
 */
class DummyGraph {

    /**
     * list of vertices
     */
    static final List<Character> VERTICES = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');

    /**
     * Non weighted Matrix representation of the graph
     * Each row represent each vertex of the graph
     * and column are the connection for that row
     * here 1 represents a connection.
     */
    static final Integer[][] EDGE_MATRIX_NON_WEIGHTED = {
            {0, 1, 1, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 1, 1, 1, 0}};
    /**
     * The max value
     */
    private static final int m = Integer.MAX_VALUE;

    /**
     * Weighted Matrix representation of the graph
     * Each row represent each vertex of the graph
     * and column are the connection for that row
     * M represents infinity i.e. no connection
     * between those two vertices and the value
     * represents the weight of the edge that connects
     * those two vertices
     */
    static final Integer[][] EDGE_MATRIX_WEIGHTED = {
            {m, 5, 7, 3, m, m, m, m},
            {5, m, m, m, 2, 10, m, m},
            {7, m, m, m, m, m, 1, m},
            {3, m, m, m, m, m, m, 11},
            {m, 2, m, m, m, m, m, 9},
            {m, 10, m, m, m, m, m, 4},
            {m, m, 1, m, m, m, m, 6},
            {m, m, m, 6, 11, 9, 4, m}};
}