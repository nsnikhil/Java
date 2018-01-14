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

import org.jetbrains.annotations.NotNull;
import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static datastructure.graph.adjacencyMatrix.DummyGraph.*;

public class GraphOperation {

    private static final String CHARACTER_INPUT = "Enter the vertex name";
    private GraphObject<Character> mGraphOne;
    private GraphObject<Character> mGraphTwo;
    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final GraphOperation graphOperation = new GraphOperation();
        graphOperation.buildChoice();
        graphOperation.initilaize();
    }

    private void buildChoice() {
        mChoice = new ArrayList<>();
        mChoice.add("exit");
        mChoice.add("find adjacent nodes");
        mChoice.add("find if two nodes are connected");
    }

    private void initilaize() throws IOException {
        mGraphOne = new GraphObject<>(VERTICES, EDGE_MATRIX_NON_WEIGHTED);
        mGraphTwo = new GraphObject<>(VERTICES, EDGE_MATRIX_WEIGHTED);

        int ch;

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(CHARACTER_INPUT);
                    print(GraphActions.getAdjacentNodes(GenericUtil.takeCharacterInput(), mGraphOne));
                    break;
                case 2:
                    System.out.println(CHARACTER_INPUT + " & " + CHARACTER_INPUT);
                    System.out.println(GraphActions.areConnected(GenericUtil.takeCharacterInput(), GenericUtil.takeCharacterInput(), mGraphOne));
                    break;
            }

        } while (ch != 0);
    }

    private void print(@NotNull Character[] ar) {
        print(ar, ar.length, 0);
    }

    private void print(final Character[] ar, final int size, final int index) {
        if (size == index) return;
        if (ar[index] != null) System.out.print(ar[index] + " ");
        print(ar, size, index + 1);
    }
}