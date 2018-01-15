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

package datastructure.dynamicArray;

import util.GenericUtil;
import util.PrintUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public final class DynamicArrayOperations {

    private DynamicIntegerArray mDynamicIntegerArray;
    private List<String> mChoice;

    public static void main(String... args) throws IOException {
        final DynamicArrayOperations dynamicArrayOperations = new DynamicArrayOperations();
        dynamicArrayOperations.buildChoice();
        dynamicArrayOperations.initialize();
    }

    private void buildChoice() {
        mChoice = new ArrayList<>();
        mChoice.add("exit");
        mChoice.add("insert");
        mChoice.add("delete");
        mChoice.add("set");
        mChoice.add("get");
        mChoice.add("search");
        mChoice.add("display");
    }

    private void initialize() throws IOException {
        int ch;
        mDynamicIntegerArray = new DynamicIntegerArray();
        do {
            System.out.println();
            PrintUtil.printChoice(mChoice);
            ch = GenericUtil.takeIntegerInput();

            switch (ch) {
                case 1:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mDynamicIntegerArray.add(GenericUtil.takeIntegerInput());
                    break;
                case 2:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    mDynamicIntegerArray.remove(GenericUtil.takeIntegerInput());
                    break;
                case 3:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE + " & " + GenericUtil.INTEGER_INPUT_INDEX);
                    mDynamicIntegerArray.set(GenericUtil.takeIntegerInput(), GenericUtil.takeIntegerInput());
                    break;
                case 4:
                    System.out.println(GenericUtil.INTEGER_INPUT_INDEX);
                    System.out.println(mDynamicIntegerArray.get(GenericUtil.takeIntegerInput()));
                    break;
                case 5:
                    System.out.println(GenericUtil.INTEGER_INPUT_MESSAGE);
                    System.out.println(mDynamicIntegerArray.search(GenericUtil.takeIntegerInput()));
                    break;
                case 6:
                    mDynamicIntegerArray.display();
                    break;
            }
        } while (ch != 0);
    }
}