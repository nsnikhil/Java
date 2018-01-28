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

package util;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class which houses some common
 * print function used in the entire project
 */
public final class PrintUtil {


    public static final String ACTION_SORT = "sort";
    public static final String ACTION_SEARCH = "search";
    public static final String ACTION_INSERT = "insert";
    public static final String ACTION_DELETE = "delete";
    public static final String ACTION_DISPLAY = "display";
    public static final String ACTION_GET = "get";
    public static final String ACTION_SET = "set";
    public static final String ACTION_CHECK = "check";
    public static final String ENTER_CHOICE_MESSAGE = "\nEnter your choice\n";
    private static final String CHOICE_EXIT = "exit";

    /**
     * @param listItem the list
     * @return the list with exit addded
     */
    public static List<String> getPrintList(List<String> listItem) {
        final List<String> choiceList = new ArrayList<>();
        choiceList.add(CHOICE_EXIT);
        choiceList.addAll(listItem);
        return choiceList;
    }

    /**
     * @param list the list to print
     */
    public static void printChoice(final List<String> list) {
        printChoice(list, list.size(), 1);
        System.out.println(buildChoice(0, list.get(0)));
    }

    /**
     * @param list     the list to print
     * @param listSize the size of list
     * @param index    the index from where the print has to start
     */
    private static void printChoice(final List<String> list, final int listSize, final int index) {
        if (listSize == index) return;
        System.out.println(buildChoice(index, list.get(index)));
        printChoice(list, listSize, index + 1);
    }

    /**
     * @param index  the index
     * @param action the string
     * @return custom string
     */
    @NotNull
    @Contract(pure = true)
    private static String buildChoice(final int index, final String action) {
        return "Enter " + index + " to " + action;
    }

    /**
     * @param choice the string
     * @return custom string
     */
    @NotNull
    @Contract(pure = true)
    public static String buildChoiceString(final String choice, final String action) {
        return "perform " + choice + " " + action;
    }

}