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
 * Edge
 *
 * @param <T>
 */
public class VertexObject<T> {

    private T mData;

    /**
     * @param data the data
     */
    VertexObject(T data) {
        this.mData = data;
    }

    /**
     * @return the data
     */
    public T getData() {
        return this.mData;
    }

    /**
     * @param data new data
     */
    public void setData(T data) {
        this.mData = data;
    }
}