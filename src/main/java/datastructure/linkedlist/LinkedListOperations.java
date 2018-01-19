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

package datastructure.linkedlist;

import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public final class LinkedListOperations {

    private LinkedList<Integer> mLinkedList;
    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final LinkedListOperations linkedListOperations = new LinkedListOperations();
        linkedListOperations.buildChoice();
        linkedListOperations.initialize();
    }

    private void buildChoice() {
        mChoice = PrintUtil.getPrintList(Arrays.asList(
                PrintUtil.ACTION_INSERT + " at beginning",
                PrintUtil.ACTION_INSERT + " at end",
                PrintUtil.ACTION_INSERT + " at given position",
                PrintUtil.ACTION_DELETE + " from first",
                PrintUtil.ACTION_DELETE + " from last",
                PrintUtil.ACTION_DELETE + " from given position",
                PrintUtil.ACTION_GET + " first item",
                PrintUtil.ACTION_GET + " last item",
                PrintUtil.ACTION_GET + " item at given position",
                PrintUtil.ACTION_GET + " item position",
                PrintUtil.ACTION_SEARCH + " if item exists",
                PrintUtil.ACTION_GET + " the size of list",
                PrintUtil.ACTION_CHECK + " if list is empty",
                PrintUtil.ACTION_DISPLAY + " list"));
    }

    private void initialize() throws IOException {

        int ch;
        mLinkedList = new LinkedList<>();

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            System.out.println(PrintUtil.ENTER_CHOICE_MESSAGE);
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
                    System.out.println(GenericUtil.INTEGER_POSITION_MESSAGE + " & " + GenericUtil.INTEGER_INPUT_MESSAGE);
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
                    System.out.println(mLinkedList.getItemPosition(GenericUtil.takeIntegerInput()));
                    break;
                case 12:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mLinkedList.searchByItem(GenericUtil.takeIntegerInput()));
                    break;
                case 13:
                    System.out.println(mLinkedList.getSize());
                    break;
                case 14:
                    System.out.println(mLinkedList.isEmpty());
                    break;
                case 15:
                    mLinkedList.display();
                    break;
            }
        } while (ch != 0);
    }
}