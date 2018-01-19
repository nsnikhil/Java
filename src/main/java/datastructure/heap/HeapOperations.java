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

package datastructure.heap;

import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class HeapOperations {

    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final HeapOperations heapOperations = new HeapOperations();
        heapOperations.buildChoice();
        heapOperations.initliaze();
    }

    private void buildChoice() {
        mChoice = PrintUtil.getPrintList(Arrays.asList("Max heapify"));

    }

    private void initliaze() throws IOException {
        int ch;

        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            System.out.println(PrintUtil.ENTER_CHOICE_MESSAGE);
            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    HeapActions.maxHeapify(DummyBinaryTrees.TREE_FOUR);
                    System.out.println();
                    HeapActions.minHeapify(DummyBinaryTrees.TREE_FOUR);
                    break;
            }

        } while (ch != 0);
    }

}
