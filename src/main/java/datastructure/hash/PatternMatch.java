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

package datastructure.hash;

public class PatternMatch {

    private static final String STRING = "nikabcjavnikapygud";

    private static final String PATTERN_ONE = "nik";
    private static final String PATTERN_TWO = "jav";
    private static final String PATTERN_THREE = "ygu";
    private static final String PATTERN_FOUR = "kab";
    private static final String PATTERN_FIVE = "abc";
    private static final String PATTERN_SIX = "vnik";
    private static final String PATTERN_SEVEN = "nikabc";

    //TODO WONT WORK WITH STRINGS OF SOME LENGTH
    public static void main(String... args) {
        RabinKarp.patternMatch(STRING, PATTERN_ONE);
        RabinKarp.patternMatch(STRING, PATTERN_TWO);
        RabinKarp.patternMatch(STRING, PATTERN_THREE);
        RabinKarp.patternMatch(STRING, PATTERN_FOUR);
        RabinKarp.patternMatch(STRING, PATTERN_FIVE);
        RabinKarp.patternMatch(STRING, PATTERN_SIX);
        RabinKarp.patternMatch(STRING, PATTERN_SEVEN);
    }

}