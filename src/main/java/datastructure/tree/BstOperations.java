package datastructure.tree;

import util.ArrayUtil;
import util.GenericUtil;

import java.io.IOException;

public class BstOperations {

    private BinarySearchTree<Integer> mBinarySearchTree;
    private BstNode<Integer> mBstNode;

    public static void main(String... args) throws IOException {
        BstOperations bstOperations = new BstOperations();
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
                    "Enter 8 to convert to array\n" +
                    "Enter 9 to display In Order\n" +
                    "Enter 10 to display Pre Order\n" +
                    "Enter 11 to display Post Order\n" +
                    "Enter 12 to display Level Order\n" +
                    "Enter 13 to get no of elements\n" +
                    "Enter 14 to check if the node is leaf node\n" +
                    "Enter 15 to check if tree is complete\n" +
                    "Enter 16 to display\n" +
                    "Enter 0 to exit\n");

            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mBstNode = mBinarySearchTree.insert(GenericUtil.takeIntegerInput(), mBstNode);
                    break;
                case 2:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mBstNode = mBinarySearchTree.remove(GenericUtil.takeIntegerInput(), mBstNode);
                    break;
                case 3:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mBinarySearchTree.search(GenericUtil.takeIntegerInput(), mBstNode));
                    break;
                case 4:
                    System.out.println(mBinarySearchTree.getMin(mBstNode));
                    break;
                case 5:
                    System.out.println(mBinarySearchTree.getMax(mBstNode));
                    break;
                case 6:
                    System.out.println(mBinarySearchTree.getHeight(mBstNode));
                    break;
                case 7:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mBinarySearchTree.getDepth(mBstNode, GenericUtil.takeIntegerInput()));
                    break;
                case 8:
                    ArrayUtil.printArray(mBinarySearchTree.toArray(mBstNode));
                    break;
                case 9:
                    ArrayUtil.printArray(mBinarySearchTree.toInorder(mBstNode));
                    break;
                case 10:
                    ArrayUtil.printArray(mBinarySearchTree.toPreOrder(mBstNode));
                    break;
                case 11:
                    ArrayUtil.printArray(mBinarySearchTree.toPostOrder(mBstNode));
                    break;
                case 12:
                    ArrayUtil.printArray(mBinarySearchTree.toLevelOrder(mBstNode));
                    break;
                case 13:
                    System.out.println(mBinarySearchTree.getNoOfElements(mBstNode));
                    break;
                case 14:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mBinarySearchTree.isLeafNode(mBstNode, GenericUtil.takeIntegerInput()));
                    break;
                case 15:
                    System.out.println(mBinarySearchTree.isComplete(mBstNode));
                    break;
                case 16:
                    mBinarySearchTree.display(mBstNode);
                    break;
            }

        } while (ch != 0);
    }


}
