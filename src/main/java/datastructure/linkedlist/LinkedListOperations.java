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
import java.util.ArrayList;
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
        mChoice = new ArrayList<>();
        mChoice.add("exit");
        mChoice.add("insert at beginning");
        mChoice.add("insert at end");
        mChoice.add("insert at given position");
        mChoice.add("delete from first");
        mChoice.add("delete from last");
        mChoice.add("delete from given position");
        mChoice.add("delete a given item");
        mChoice.add("get first item");
        mChoice.add("get last item");
        mChoice.add("get item at given position");
        mChoice.add("get item position");
        mChoice.add("search if item exists");
        mChoice.add("get the size of list");
        mChoice.add("check if list is empty");
        mChoice.add("display list");
    }

    private void initialize() throws IOException {

        int ch;
        mLinkedList = new LinkedList<>();

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
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