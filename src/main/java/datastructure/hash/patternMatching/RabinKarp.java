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

/**
 * Class implementing rabin-krap algorithm
 */
public class RabinKarp {

    /**
     * Prime Constant used to calculate hash code for
     * a given key
     */
    private static final Integer CONSTANT = 101;

    /**
     * Prints the index at which a given pattern match a given string
     *
     * @param string  the string
     * @param pattern the pattern
     */
    public static void patternMatch(@NotNull final String string, @NotNull final String pattern) {
        patternMatchUtil(string, pattern, calculateHash(pattern), pattern.length(), calculateHash(string.substring(0, pattern.length())), string.length() - pattern.length(), 0);
    }

    /**
     * Prints the index at which a given pattern match a given string
     * <p>
     * Algorithm :
     * a window is set on main string which is equal to length of
     * substring and after each iteration window is shifted by 1 unit
     * length of substring will be equal to length of pattern
     * <p>
     * Calculate the hash code of pattern and substring and
     * check oif hash code match and if they match check
     * individual character and if they also match
     * print index
     * and then increment the window by 1
     *
     * @param string        the string
     * @param pattern       the pattern
     * @param patternHash   the hash value/code of pattern
     * @param patternLength the length of pattern
     * @param stringHash    the hash value/code of sub string
     * @param size          the index until which string will be checked for pattern
     * @param index         the starting point of check
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
     * If hash code and each char of sub string and pattern
     * are equal the return true else !true
     *
     * @param hashOne   the hash code of sub string string
     * @param hashTwo   the hash code of pattern
     * @param subString the sub string
     * @param pattern   the pattern to match
     * @return true if both hash code and char match for two strings
     */
    private static boolean checkEqual(@NotNull final Integer hashOne, final Integer hashTwo, final String subString, final String pattern) {
        return hashOne.equals(hashTwo) && compareCharacter(subString, pattern, pattern.length(), 0);
    }

    /**
     * Returns true if each char is equal in
     * sub string and pattern
     *
     * @param subString the sub string
     * @param pattern   the pattern
     * @param length    the length of pattern
     * @param index     the starting point of comparison
     * @return true if each char is equal in sub string and pattern
     */
    private static boolean compareCharacter(final String subString, final String pattern, final Integer length, @NotNull final Integer index) {
        return index.equals(length) || subString.charAt(index) == pattern.charAt(index) && compareCharacter(subString, pattern, length, index + 1);
    }

    /**
     * Returns hash code for given key/string
     *
     * @param string the key/string
     * @return the hash code
     */
    private static Integer calculateHash(final String string) {
        return calculateHashUtil(string, string.length(), 0, CONSTANT, 0);
    }


    /**
     * Calculates and returns new hash
     *
     * @param oldHash           the old hash value
     * @param previousCharacter the character which is leaving
     * @param newCharacter      the character which will be added
     * @param patternLength     the size of pattern
     * @return new hash after replacing old char with new
     */
    @NotNull
    private static Integer calculateNewHash(final Integer oldHash, final Character previousCharacter, final Character newCharacter, Integer patternLength) {
        return calculateNewHashUtil(oldHash, CONSTANT, previousCharacter, newCharacter, patternLength);
    }

    /**
     * Returns hash code for given key/string
     *
     * @param string        the string/key
     * @param stringLength  length of string
     * @param hashValue     the empty hash value
     * @param primeConstant the prime constant
     * @param index         the starting point
     * @return he hash code
     */
    private static Integer calculateHashUtil(final String string, final Integer stringLength, final Integer hashValue, final Integer primeConstant, @NotNull final Integer index) {
        if (index.equals(stringLength)) return hashValue;
        if (index == 0)
            return string.charAt(index) + calculateHashUtil(string, stringLength, hashValue, primeConstant, index + 1);
        return string.charAt(index) * (int) Math.pow(primeConstant, index) + calculateHashUtil(string, stringLength, hashValue, primeConstant, index + 1);
    }


    /**
     * Calculates and returns new hash
     * <p>
     * <p>
     * Algorithm :
     * a => Old has value - Ascii value of leaving character
     * b => a / prime constant
     * c => ascii of new character * prime_constant ^ index at which character will be placed
     * d => b + c
     * d is the new hash code
     *
     * @param oldHash           old hash code
     * @param primeConstant     the prime constant
     * @param previousCharacter the leaving character
     * @param newCharacter      the new character
     * @param newIndex          index at which new char is added
     * @return
     */
    @NotNull
    private static Integer calculateNewHashUtil(final Integer oldHash, final Integer primeConstant, final Character previousCharacter, final Character newCharacter, final Integer newIndex) {
        return ((oldHash - ((int) previousCharacter)) / primeConstant) + ((int) newCharacter * ((int) Math.pow(primeConstant, newIndex)));
    }

}
