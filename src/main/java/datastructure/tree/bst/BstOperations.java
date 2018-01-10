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

import java.io.IOException;

public final class BstOperations {

    private BinarySearchTree<Integer> mBinarySearchTree;

    public static void main(String... args) throws IOException {
        final BstOperations bstOperations = new BstOperations();
        bstOperations.initialize();
    }

    private void initialize() throws IOException {
        mBinarySearchTree = new BinarySearchTree<>();
        int ch;

        do {

            System.out.println("\nEnter 1 to add item\n" +
                    "Enter 2 to remove item\n" +
                    "Enter 3 to search item\n" +
                    "Enter 4 to get min\n" +
                    "Enter 5 to get max\n" +
                    "Enter 6 to get height\n" +
                    "Enter 7 to get depth\n" +
                    "Enter 8 to display In Order\n" +
                    "Enter 9 to display Pre Order\n" +
                    "Enter 10 to display Post Order\n" +
                    "Enter 11 to display Level Order\n" +
                    "Enter 12 to get no of elements\n" +
                    "Enter 13 to get In Order Successor of a element\n" +
                    "Enter 14 to check if the node is leaf node\n" +
                    "Enter 15 to check if tree is complete\n" +
                    "Enter 16 to check if tree is balanced\n" +
                    "Enter 17 to balance the tree\n" +
                    "Enter 18 to display\n" +
                    "Enter 0 to exit\n");

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