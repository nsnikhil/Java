package datastructure.tree;

import util.ArrayUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BstOperations {

    private BufferedReader mBufferedReader = new BufferedReader(new InputStreamReader(System.in));
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
                    "Enter 15 to display\n" +
                    "Enter 0 to exit");

            ch = Integer.parseInt(mBufferedReader.readLine());

            switch (ch) {
                case 1:
                    mBstNode = mBinarySearchTree.insert(takeInput("no"), mBstNode);
                    break;
                case 2:
                    mBstNode = mBinarySearchTree.remove(takeInput("no"), mBstNode);
                    break;
                case 3:
                    System.out.println(mBinarySearchTree.search(takeInput("no"), mBstNode));
                    break;
                case 4:
                    System.out.println(mBinarySearchTree.getMin(mBstNode));
                    break;
                case 5:
                    System.out.println(mBinarySearchTree.getMax(mBstNode));
                    break;
                case 6:
                    System.out.println(mBinarySearchTree.getHeight());
                    break;
                case 7:
                    System.out.println(mBinarySearchTree.getDepth());
                    break;
                case 8:
                    ArrayUtil.printArray(mBinarySearchTree.toArray());
                    break;
                case 9:
                    ArrayUtil.printArray(mBinarySearchTree.toInorder());
                    break;
                case 10:
                    ArrayUtil.printArray(mBinarySearchTree.toPreOrder());
                    break;
                case 11:
                    ArrayUtil.printArray(mBinarySearchTree.toPostOrder());
                    break;
                case 12:
                    ArrayUtil.printArray(mBinarySearchTree.toLevelOrder());
                    break;
                case 13:
                    System.out.println(mBinarySearchTree.getNoOfElements());
                    break;
                case 14:
                    System.out.println(mBinarySearchTree.isLeafNode(takeInput("no")));
                    break;
                case 15:
                    mBinarySearchTree.display(mBstNode);
                    break;
            }

        } while (ch != 0);
    }

    private int takeInput(String message) throws IOException {
        System.out.println("Enter the " + message);
        return Integer.parseInt(mBufferedReader.readLine());
    }

}
