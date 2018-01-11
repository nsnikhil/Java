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

package datastructure.tree.bst;

import util.ArrayUtil;
import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class BstOperations {

    private BinarySearchTree<Integer> mBinarySearchTree;
    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final BstOperations bstOperations = new BstOperations();
        bstOperations.buildChoice();
        bstOperations.initialize();
    }

    private void buildChoice() {
        mChoice = new ArrayList<>();
        mChoice.add("exit");
        mChoice.add("add item");
        mChoice.add("remove item");
        mChoice.add("search item");
        mChoice.add("get min");
        mChoice.add("get max");
        mChoice.add("get height");
        mChoice.add("get depth");
        mChoice.add("display In Order");
        mChoice.add("display Pre Order");
        mChoice.add("display Post Order");
        mChoice.add("display Level Order");
        mChoice.add("get no of elements");
        mChoice.add("get In Order Successor of a element");
        mChoice.add("check if the node is leaf node");
        mChoice.add("check if tree is complete");
        mChoice.add("check if tree is balanced");
        mChoice.add("balance the tree");
        mChoice.add("display");
    }

    private void initialize() throws IOException {
        mBinarySearchTree = new BinarySearchTree<>();
        int ch;

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            ch = GenericUtil.takeIntegerInput();
            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mBinarySearchTree.insert(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mBinarySearchTree.remove(GenericUtil.takeIntegerInput());
                    break;
                case 3:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mBinarySearchTree.search(GenericUtil.takeIntegerInput()));
                    break;
                case 4:
                    System.out.println(mBinarySearchTree.getMin());
                    break;
                case 5:
                    System.out.println(mBinarySearchTree.getMax());
                    break;
                case 6:
                    System.out.println(mBinarySearchTree.getHeight());
                    break;
                case 7:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mBinarySearchTree.getDepth(GenericUtil.takeIntegerInput()));
                    break;
                case 8:
                    ArrayUtil.printArray(mBinarySearchTree.toInorder());
                    break;
                case 9:
                    ArrayUtil.printArray(mBinarySearchTree.toPreOrder());
                    break;
                case 10:
                    ArrayUtil.printArray(mBinarySearchTree.toPostOrder());
                    break;
                case 11:
                    ArrayUtil.printArray(mBinarySearchTree.toLevelOrder());
                    break;
                case 12:
                    System.out.println(mBinarySearchTree.getNoOfElements());
                    break;
                case 13:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mBinarySearchTree.getSuccessorInOrder(GenericUtil.takeIntegerInput()));
                    break;
                case 14:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mBinarySearchTree.isLeafNode(GenericUtil.takeIntegerInput()));
                    break;
                case 15:
                    System.out.println(mBinarySearchTree.isComplete());
                    break;
                case 16:
                    System.out.println(mBinarySearchTree.isBalanced());
                    break;
                case 17:
                    mBinarySearchTree.balanceBst();
                    break;
                case 18:
                    mBinarySearchTree.display();
                    break;
            }

        } while (ch != 0);
    }
}