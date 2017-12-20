package datastructure.linkedlist;

import util.GenericUtil;

import java.io.IOException;


public class LinkedListOperations {

    private LinkedList<Integer> mLinkedList;

    public static void main(String... args) throws IOException {
        LinkedListOperations linkedListOperations = new LinkedListOperations();
        linkedListOperations.initialize();
    }

    private void initialize() throws IOException {

        int ch;
        mLinkedList = new LinkedList<>();

        do {

            System.out.println("\nEnter 1 to insert at beginning\n" +
                    "Enter 2 to insert at end\n" +
                    "Enter 3 to insert at given position\n" +
                    "Enter 4 to delete from first\n" +
                    "Enter 5 to delete from last\n" +
                    "Enter 6 to delete from given position\n" +
                    "Enter 7 to delete a given item\n" +
                    "Enter 8 to get first item\n" +
                    "Enter 9 to get last item\n" +
                    "Enter 10 to get item at given position\n" +
                    "Enter 11 to search if item exists\n" +
                    "Enter 12 to get the size of list\n" +
                    "Enter 13 to check if list is empty\n" +
                    "Enter 14 to display list\n" +
                    "Enter 0 to exit\n");

            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mLinkedList.insertFirst(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mLinkedList.insertLast(GenericUtil.takeIntegerInput());
                    break;
                case 3:
                    System.out.println(GenericUtil.INTEGER_POSITION_MESSAGE);
                    System.out.println("And " + GenericUtil.INTEGER_INPUT_MESSAGE);
                    mLinkedList.insertAtPosition(GenericUtil.takeIntegerInput(), GenericUtil.takeIntegerInput());
                    break;
                case 4:
                    mLinkedList.deleteFirst();
                    break;
                case 5:
                    mLinkedList.deleteLast();
                    break;
                case 6:
                    System.out.println(GenericUtil.INTEGER_POSITION_MESSAGE);
                    mLinkedList.deleteAtPosition(GenericUtil.takeIntegerInput());
                    break;
                case 7:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mLinkedList.deleteItem(GenericUtil.takeIntegerInput());
                    break;
                case 8:
                    System.out.println(mLinkedList.getFirst());
                    break;
                case 9:
                    System.out.println(mLinkedList.getLast());
                    break;
                case 10:
                    System.out.println(GenericUtil.INTEGER_POSITION_MESSAGE);
                    System.out.println(mLinkedList.getAtPosition(GenericUtil.takeIntegerInput()));
                    break;
                case 11:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mLinkedList.searchByItem(GenericUtil.takeIntegerInput()));
                    break;
                case 12:
                    System.out.println(mLinkedList.getSize());
                    break;
                case 13:
                    System.out.println(mLinkedList.isEmpty());
                    break;
                case 14:
                    mLinkedList.display();
                    break;
            }
        } while (ch != 0);
    }
}