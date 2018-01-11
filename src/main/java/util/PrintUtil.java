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

import java.util.List;

public final class PrintUtil {

    public static void printChoice(final List<String> list) {
        printChoice(list, list.size(), 1);
        System.out.println(buildChoice(0, list.get(0)));
    }

    private static void printChoice(final List<String> list, final int listSize, final int index) {
        if (listSize == index) return;
        System.out.println(buildChoice(index, list.get(index)));
        printChoice(list, listSize, index + 1);
    }

    @NotNull
    @Contract(pure = true)
    private static String buildChoice(final int index, final String action) {
        return "Enter " + index + " to " + action;
    }

}