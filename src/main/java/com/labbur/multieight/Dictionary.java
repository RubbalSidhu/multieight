package com.labbur.multieight;

public interface Dictionary {
    /**
     * @param word
     * @return if the word is a valid word as per the dictionary or not
     */
    boolean isValidWord(String word);

    /**
     * @param prefix
     * @return whether the input is a prefix to some word in the dictionary
     * Might use prefix tree to reduce the possible permutations if the prefix obtained till now
     * is not found in the prefix tree
     */
    boolean isValidPrefix(String prefix);
}
