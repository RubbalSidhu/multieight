package com.labbur.multieight;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    private static final long SLEEP_TIME = 5000;

    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        Dictionary dictionary = new FileDictionary(args[0]);
        Player player = new Player(dictionary);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the characters in any order in a single line and press Enter");
        System.out.println("Enter empty string to exit");
        System.out.println("Click on the window you want the program to type into within 5 seconds");
        System.out.println("(The Program starts typing after a delay of 5 seconds)");

        System.out.println("Enter input");
        String s = br.readLine();

        Thread.sleep(SLEEP_TIME);
        player.playRound(s.toLowerCase().trim().toCharArray());

    }
}
