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
import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static datastructure.graph.adjacencyMatrix.DummyGraph.*;

/**
 *
 */
public class GraphOperations {

    private GraphObject<Character> mGraphOne;
    private GraphObject<Character> mGraphTwo;
    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final GraphOperations graphOperations = new GraphOperations();
        graphOperations.buildChoice();
        graphOperations.initialize();
    }

    private void buildChoice() {
        mChoice = PrintUtil.getPrintList(Arrays.asList(
                "find adjacent nodes",
                "find if two nodes are connected"
        ));
    }

    private void initialize() throws IOException {
        mGraphOne = new GraphObject<>(VERTICES, EDGE_MATRIX_NON_WEIGHTED);
        mGraphTwo = new GraphObject<>(VERTICES, EDGE_MATRIX_WEIGHTED);

        int ch;

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            System.out.println(PrintUtil.ENTER_CHOICE_MESSAGE);
            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(GraphUtil.CHARACTER_INPUT);
                    GraphUtil.print(GraphActions.getAdjacentNodes(GenericUtil.takeCharacterInput(), mGraphOne));
                    break;
                case 2:
                    System.out.println(GraphUtil.CHARACTER_INPUT + " & " + GraphUtil.CHARACTER_INPUT);
                    System.out.println(GraphActions.areConnected(GenericUtil.takeCharacterInput(), GenericUtil.takeCharacterInput(), mGraphOne));
                    break;
            }

        } while (ch != 0);
    }
}