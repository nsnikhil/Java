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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class GenericUtil {

    public static final String INTEGER_INPUT_MESSAGE = "Enter the no";
    public static final String INTEGER_INPUT_SIZE = "Enter the size";
    public static final String INTEGER_INPUT_INDEX = "Enter the index";
    public static final String INTEGER_POSITION_MESSAGE = "Enter the position";
    public static final String STRING_INPUT_MESSAGE = "Enter the string";
    public static final String STRING_INPUT_SUB_MESSAGE = "Enter the sub string";

    private static BufferedReader mBufferedReader;

    /**
     * @return buffered reader
     */
    private static BufferedReader getBufferedReader() {
        if (mBufferedReader == null) mBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return mBufferedReader;
    }

    /**
     * @return output stream
     * @throws IOException input/output exception
     */
    public static int takeIntegerInput() throws IOException {
        return Integer.parseInt(takeStringInput());
    }

    /**
     * @return output stream
     * @throws IOException input/output exception
     */
    public static char takeCharacterInput() throws IOException {
        return takeStringInput().charAt(0);
    }

    /**
     * @return output stream
     * @throws IOException input/output exception
     */
    public static String takeStringInput() throws IOException {
        return getBufferedReader().readLine();
    }

}
