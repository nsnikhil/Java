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
import java.util.Arrays;
import java.util.List;

/**
 * Class illustrating all the operations of
 * binary search tree
 */
public final class BstOperations {

    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final BstOperations bstOperations = new BstOperations();
        bstOperations.buildChoice();
        bstOperations.initialize();
    }

    /**
     * build list of choices which
     * can be performed
     */
    private void buildChoice() {
        mChoice = PrintUtil.getPrintList(Arrays.asList(
                "add item",
                "remove item",
                "search item",
                "get min",
                "get max",
                "get height",
                "get depth",
                "display In Order",
                "display Pre Order",
                "display Post Order",
                "display Level Order",
                "get no of elements",
                "get In Order Successor of a element",
                "check if the node is leaf node",
                "check if tree is complete",
                "check if tree is balanced",
                "balance the tree",
                "display"));
    }

    /**
     * function that allows to perform all function
     * of binary search tree
     *
     * @throws IOException IOException
     */
    private void initialize() throws IOException {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int ch;

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            ch = GenericUtil.takeIntegerInput();
            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    binarySearchTree.insert(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    binarySearchTree.remove(GenericUtil.takeIntegerInput());
                    break;
                case 3:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(binarySearchTree.search(GenericUtil.takeIntegerInput()));
                    break;
                case 4:
                    System.out.println(binarySearchTree.getMin());
                    break;
                case 5:
                    System.out.println(binarySearchTree.getMax());
                    break;
                case 6:
                    System.out.println(binarySearchTree.getHeight());
                    break;
                case 7:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(binarySearchTree.getDepth(GenericUtil.takeIntegerInput()));
                    break;
                case 8:
                    ArrayUtil.printArray(binarySearchTree.toInorder());
                    break;
                case 9:
                    ArrayUtil.printArray(binarySearchTree.toPreOrder());
                    break;
                case 10:
                    ArrayUtil.printArray(binarySearchTree.toPostOrder());
                    break;
                case 11:
                    ArrayUtil.printArray(binarySearchTree.toLevelOrder());
                    break;
                case 12:
                    System.out.println(binarySearchTree.getNoOfElements());
                    break;
                case 13:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(binarySearchTree.getSuccessorInOrder(GenericUtil.takeIntegerInput()));
                    break;
                case 14:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(binarySearchTree.isLeafNode(GenericUtil.takeIntegerInput()));
                    break;
                case 15:
                    System.out.println(binarySearchTree.isComplete());
                    break;
                case 16:
                    System.out.println(binarySearchTree.isBalanced());
                    break;
                case 17:
                    binarySearchTree.balanceBst();
                    break;
                case 18:
                    binarySearchTree.display();
                    break;
            }

        } while (ch != 0);
    }
}