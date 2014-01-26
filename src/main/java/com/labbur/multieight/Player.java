package com.labbur.multieight;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private final Robot robot;
    private Dictionary dictionary;

    public Player(Dictionary dictionary) throws AWTException {
        this.robot = new Robot();
        this.dictionary = dictionary;
    }

    public void playRound(char[] input) throws InterruptedException {
        tryPermutations(new char[0], input, new HashSet<String>());
    }

    void tryPermutations(char[] done, char[] left, Set<String> wordsUsed) throws InterruptedException {
        //System.out.println(done);
        int l = left.length;
        String wordFormed = new String(done);
        if (!wordFormed.isEmpty() && dictionary.isValidWord(wordFormed) && !wordsUsed.contains(wordFormed)) {
            System.out.println(wordFormed);
            wordsUsed.add(wordFormed);
            simulateClicks(wordFormed);
        }
        if (l != 0) {
            for (int i = 0; i < l; i++) {
                char[] newLeft = new char[left.length - 1];
                int j = 0;
                int index = 0;
                while (j < l) {
                    if (j == i) {
                        j++;
                    } else
                        newLeft[index++] = left[j++];
                }
                char[] newDone = new char[done.length + 1];
                for (j = 0; j < newDone.length - 1; j++)
                    newDone[j] = done[j];
                newDone[j] = left[i];
                tryPermutations(newDone, newLeft, wordsUsed);
            }
        }
    }

    private void simulateClicks(String wordFormed) throws InterruptedException {
        for (Character c : wordFormed.toCharArray()) {
            int key = KeyEvent.VK_A + c - 'a';
            robot.keyPress(key);
            robot.keyRelease(key);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(10);
    }
}
