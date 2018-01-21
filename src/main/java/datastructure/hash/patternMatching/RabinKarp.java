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

package datastructure.hash.patternMatching;

import org.jetbrains.annotations.NotNull;

public class RabinKarp {

    /**
     *
     */
    private static final Integer CONSTANT = 101;

    /**
     * @param string
     * @param pattern
     */
    public static void patternMatch(@NotNull final String string, @NotNull final String pattern) {
        patternMatchUtil(string, pattern, calculateHash(pattern), pattern.length(), calculateHash(string.substring(0, pattern.length())), string.length() - pattern.length(), 0);
    }

    /**
     * @param string
     * @param pattern
     * @param patternHash
     * @param patternLength
     * @param stringHash
     * @param size
     * @param index
     */
    private static void patternMatchUtil(@NotNull final String string, @NotNull final String pattern, final Integer patternHash, final Integer patternLength, Integer stringHash, final Integer size, final Integer index) {
        if (index > size) return;
        if (checkEqual(patternHash, stringHash, string.substring(index, patternLength + index), pattern))
            System.out.println("Match found for " + pattern + " at " + index + " index" + " for " + string.substring(0, index) + "'" + string.substring(index, index + patternLength) + "'" + string.substring(index + patternLength));
        if (index < size)
            stringHash = calculateNewHash(stringHash, string.charAt(index), string.charAt(index + patternLength), patternLength - 1);
        patternMatchUtil(string, pattern, patternHash, patternLength, stringHash, size, index + 1);
    }

    /**
     * @param hashOne
     * @param hashTwo
     * @param subString
     * @param pattern
     * @return
     */
    private static boolean checkEqual(@NotNull final Integer hashOne, final Integer hashTwo, final String subString, final String pattern) {
        return hashOne.equals(hashTwo) && compareCharacter(subString, pattern, pattern.length(), 0);
    }

    /**
     * @param subString
     * @param pattern
     * @param length
     * @param index
     * @return
     */
    private static boolean compareCharacter(final String subString, final String pattern, final Integer length, @NotNull final Integer index) {
        return index.equals(length) || subString.charAt(index) == pattern.charAt(index) && compareCharacter(subString, pattern, length, index + 1);
    }

    /**
     * @param string
     * @return
     */
    private static Integer calculateHash(final String string) {
        return calculateHashUtil(string, string.length(), 0, CONSTANT, 0);
    }


    /**
     * @param oldHash
     * @param previousCharacter
     * @param newCharacter
     * @param patternLength
     * @return
     */
    @NotNull
    private static Integer calculateNewHash(final Integer oldHash, final Character previousCharacter, final Character newCharacter, Integer patternLength) {
        return calculateNewHashUtil(oldHash, CONSTANT, previousCharacter, newCharacter, patternLength);
    }

    /**
     * @param string
     * @param stringLength
     * @param hashValue
     * @param primeConstant
     * @param index
     * @return
     */
    private static Integer calculateHashUtil(final String string, final Integer stringLength, final Integer hashValue, final Integer primeConstant, @NotNull final Integer index) {
        if (index.equals(stringLength)) return hashValue;
        if (index == 0)
            return string.charAt(index) + calculateHashUtil(string, stringLength, hashValue, primeConstant, index + 1);
        return string.charAt(index) * (int) Math.pow(primeConstant, index) + calculateHashUtil(string, stringLength, hashValue, primeConstant, index + 1);
    }


    /**
     * @param oldHash
     * @param primeConstant
     * @param previousCharacter
     * @param newCharacter
     * @param newIndex
     * @return
     */
    @NotNull
    private static Integer calculateNewHashUtil(final Integer oldHash, final Integer primeConstant, final Character previousCharacter, final Character newCharacter, final Integer newIndex) {
        return ((oldHash - ((int) previousCharacter)) / primeConstant) + ((int) newCharacter * ((int) Math.pow(primeConstant, newIndex)));
    }

}
