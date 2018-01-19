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

package datastructure.tree;

import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//TODO
public final class TreeOperations {

    private Tree<Integer> mTree;
    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final TreeOperations treeOperations = new TreeOperations();
        treeOperations.buildChoice();
        treeOperations.initialize();
    }

    private void buildChoice() {
        mChoice = PrintUtil.getPrintList(Arrays.asList(
                PrintUtil.ACTION_INSERT,
                PrintUtil.ACTION_DELETE,
                PrintUtil.ACTION_SEARCH,
                PrintUtil.ACTION_DISPLAY));
    }

    private void initialize() throws IOException {
        mTree = new Tree<>();
        int ch;

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            System.out.println(PrintUtil.ENTER_CHOICE_MESSAGE);
            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE + " & " + GenericUtil.INTEGER_INPUT_MESSAGE);
                    mTree.insert(GenericUtil.takeIntegerInput(), GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mTree.delete(GenericUtil.takeIntegerInput());
                    break;
                case 3:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mTree.search(GenericUtil.takeIntegerInput()));
                    break;
                case 4:
                    mTree.display();
                    break;
            }
        } while (ch != 0);
    }
}
