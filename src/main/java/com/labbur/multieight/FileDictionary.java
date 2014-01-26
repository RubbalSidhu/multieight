package com.labbur.multieight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Implements a file based dictionary
 */
public class FileDictionary implements Dictionary {

    Set<String> wordSet;
    public FileDictionary(String fileNameFullPath) throws IOException {
        wordSet = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader(fileNameFullPath));
        String word;

        while ((word = br.readLine()) != null) {
            wordSet.add(word.toLowerCase().trim());
        }
    }
    @Override
    public boolean isValidWord(String word) {
        return wordSet.contains(word);
    }

    @Override
    public boolean isValidPrefix(String prefix) {
        return true;
    }
}
