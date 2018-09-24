package com.romanmarkunas.blog.montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class MontyHall {

    private static final int DOOR_WITH_CAR = 2;

    public static void main(String[] args) throws InterruptedException {
        long totalGuess = 0;
        long successWithNoChange = 0;
        long successWithChange = 0;

        // TODO - this could be expanded on how random works up to OS level and why it is not affected by below
        // TODO - how results change if these are the same random
        Random rnGuess = new Random();
        Thread.sleep(4);
        Random rnOpenDoor = new Random();

        while (totalGuess < 100_000_000) {
            totalGuess += 1;

            // make an initial guess, this also represents success, if not changing door
            int initialGuess = rnGuess.nextInt(3);
            if (initialGuess == DOOR_WITH_CAR) {
                successWithNoChange += 1;
            }

            // open one of doors with goat
            int openedDoor = 0;
            boolean doorOpened = false;
            while (!doorOpened) {
                int doorToOpen = rnOpenDoor.nextInt(2);
                if (doorToOpen != initialGuess) {
                    openedDoor = doorToOpen;
                    doorOpened = true;
                }
            }

            // change mind
            int changedDoor;
            List<Integer> doorsLeft = new ArrayList<>(asList(0, 1, 2));
            doorsLeft.remove(new Integer(openedDoor));
            doorsLeft.remove(new Integer(initialGuess));
            changedDoor = doorsLeft.get(0);

            if (changedDoor == DOOR_WITH_CAR) {
                successWithChange += 1;
            }
        }

        // print results
        System.out.println("Success with no change: " + ratioAsPercent(successWithNoChange, totalGuess) + "%");
        System.out.println("Success no change: " + ratioAsPercent(successWithChange, totalGuess) + "%");
    }

    private static double ratioAsPercent(long quotient, long dividend) {
        return quotient * 100 / (double) dividend;
    }
}
