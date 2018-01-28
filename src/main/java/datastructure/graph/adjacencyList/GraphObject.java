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

import java.util.List;

/**
 * Object that represents the entire graph in
 * adjacency list form
 *
 * @param <T>
 */
public class GraphObject<T> {

    /**
     * list of vertices
     */
    private List<T> mVertex;

    /**
     * list of linked list of edges
     */
    private List<LinkedList<Integer>> mEdgeList;

    /**
     * @param vertex   the vertex
     * @param edgeList the list of edges
     */
    GraphObject(List<T> vertex, List<LinkedList<Integer>> edgeList) {
        mVertex = vertex;
        mEdgeList = edgeList;
    }

    /**
     * @return the vertex
     */
    public List<T> getVertex() {
        return mVertex;
    }

    /**
     * @param vertex new vertices
     */
    public void setVertex(List<T> vertex) {
        this.mVertex = vertex;
    }

    /**
     * @return list of edges
     */
    public List<LinkedList<Integer>> getEdgeList() {
        return mEdgeList;
    }

    /**
     * @param edgeList new edges
     */
    public void setEdgeList(List<LinkedList<Integer>> edgeList) {
        this.mEdgeList = edgeList;
    }
}
