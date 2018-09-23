package com.romanmarkunas.blog.montyhall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MontyHall {

    public static void main(String[] args) throws InterruptedException {
        int totalGuess = 0;
        int[] carInDoorCount = new int[3];

        int successWithNoChange = 0;
        int successWithChange = 0;

        // TODO - this could be expanded on how random works up to OS level or
        // even below, and that R3 experience and if they could avoid it by
        // making their own generator

        // TODO - how results change if these are the same random
        Random rnDoors = new Random();
        Thread.sleep(1000);
        Random rnGuess = new Random();
        Thread.sleep(1000);
        Random rnOpenDoor = new Random();

        for (int i = 0; i < 1_000_000; i++) {

            // initialize doors with car and donkeys, 1 - is car, 0 - donkey
            // TODO - is there a need to randomly init doors, when guess is random?
            int doorWithCar = rnDoors.nextInt(3);
            int[] doors = new int[3];
            doors[doorWithCar] = 1;
            carInDoorCount[doorWithCar] += 1;
            totalGuess += 1;

            // make an initial guess, this also represents success, if not changing door
            int initialGuess = rnGuess.nextInt(3);
            if (initialGuess == doorWithCar) {
                successWithNoChange += 1;
            }

            // open one of doors
            int openedDoor = 0;
            boolean doorOpened = false;
            while (!doorOpened) {
                int doorToOpen = rnOpenDoor.nextInt(3);
                if (doorToOpen == initialGuess || doorToOpen == doorWithCar) {
                    continue;
                }

                openedDoor = doorToOpen;
                doorOpened = true;
            }

            // change mind
            int changedDoor;
            List<Integer> doorsLeft = new ArrayList<>();
            doorsLeft.add(0);
            doorsLeft.add(1);
            doorsLeft.add(2);
            doorsLeft.remove(new Integer(openedDoor));
            doorsLeft.remove(new Integer(initialGuess));
            changedDoor = doorsLeft.get(0);

            if (changedDoor == doorWithCar) {
                successWithChange += 1;
            }
        }
        // print results
        System.out.println("How randomly is goat is put:");
        for (int door : carInDoorCount) {
            System.out.println(" - " + (door * 100 / (double) totalGuess) + "%");
        }

        System.out.println();
        System.out.println("Success with no change: " + (successWithNoChange * 100 / (double) totalGuess) + "%");

        System.out.println();
        System.out.println("Success with no change: " + (successWithChange * 100 / (double) totalGuess) + "%");
    }
}
