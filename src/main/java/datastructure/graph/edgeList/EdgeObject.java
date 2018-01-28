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

package datastructure.graph.edgeList;

/**
 * Edge of a graph is given by two of the nodes its
 * is connected to
 *
 * @param <T>
 */
public class EdgeObject<T> {

    private VertexObject<T> mNodeOne;
    private VertexObject<T> mNodeTwo;
    private int mWeight;

    /**
     * @param nodeOne the first vertex
     * @param nodeTwo the second vertex
     */
    public EdgeObject(VertexObject<T> nodeOne, VertexObject<T> nodeTwo) {
        this(nodeOne, nodeTwo, 1);
    }

    /**
     * @param nodeOne the first vertex
     * @param nodeTwo the second vertex
     * @param weight  the weight of the edge
     */
    EdgeObject(VertexObject<T> nodeOne, VertexObject<T> nodeTwo, int weight) {
        this.mNodeOne = nodeOne;
        this.mNodeTwo = nodeTwo;
        this.mWeight = weight;
    }

    /**
     * @return the first vertex
     */
    public VertexObject<T> getNodeOne() {
        return mNodeOne;
    }

    /**
     * @param nodeOne new first vertex
     */
    public void setNodeOne(VertexObject<T> nodeOne) {
        this.mNodeOne = nodeOne;
    }

    /**
     * @return the second vertex
     */
    public VertexObject<T> getNodeTwo() {
        return mNodeTwo;
    }

    /**
     * @param nodeTwo new second vertex
     */
    public void setNodeTwo(VertexObject<T> nodeTwo) {
        this.mNodeTwo = nodeTwo;
    }

    /**
     * @return the weight of edge
     */
    public int getWeight() {
        return mWeight;
    }

    /**
     * @param weight new weight of edge
     */
    public void setWeight(int weight) {
        this.mWeight = weight;
    }
}
