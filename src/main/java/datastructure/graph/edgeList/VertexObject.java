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

public class VertexObject<T> {

    private EdgeObject<T> mNodeOne;
    private EdgeObject<T> mNodeTwo;
    private int mWeight;

    public VertexObject(EdgeObject<T> nodeOne, EdgeObject<T> nodeTwo) {
        this(nodeOne, nodeTwo, 1);
    }

    public VertexObject(EdgeObject<T> nodeOne, EdgeObject<T> nodeTwo, int weight) {
        this.mNodeOne = nodeOne;
        this.mNodeTwo = nodeTwo;
        this.mWeight = weight;
    }

    public EdgeObject<T> getNodeOne() {
        return mNodeOne;
    }

    public void setmNodeOne(EdgeObject<T> nodeOne) {
        this.mNodeOne = nodeOne;
    }

    public EdgeObject<T> getNodeTwo() {
        return mNodeTwo;
    }

    public void setmNodeTwo(EdgeObject<T> nodeTwo) {
        this.mNodeTwo = nodeTwo;
    }

    public int getWeight() {
        return mWeight;
    }

    public void setWeight(int weight) {
        this.mWeight = weight;
    }
}
