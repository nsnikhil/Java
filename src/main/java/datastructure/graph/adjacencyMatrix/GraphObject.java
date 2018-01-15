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

import java.util.List;

/**
 * Adjacency matrix is good when graph is dense
 * or when no of edges is close to square of no
 * of vertices
 * <p>
 * Its not very good in terms of space as it takes
 * v*v space to store edges
 */
public class GraphObject<T> {

    private List<T> mVertices;
    private Integer[][] mEdges;

    /**
     * @param vertices
     * @param edges
     */
    GraphObject(List<T> vertices, Integer[][] edges) {
        mVertices = vertices;
        mEdges = edges;
    }

    /**
     *
     * @return
     */
    public Integer[][] getEdges() {
        return mEdges;
    }

    /**
     *
     * @param edges
     */
    public void setEdges(Integer[][] edges) {
        this.mEdges = edges;
    }

    /**
     *
     * @return
     */
    public List<T> getVertices() {
        return mVertices;
    }

    /**
     *
     * @param vertices
     */
    public void setVertices(List<T> vertices) {
        this.mVertices = vertices;
    }
}
