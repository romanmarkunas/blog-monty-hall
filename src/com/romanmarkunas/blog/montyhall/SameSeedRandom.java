package com.romanmarkunas.blog.montyhall;

import java.util.Arrays;
import java.util.Random;

public class SameSeedRandom {

   public static void main(String[] args) {
      Random rn1 = new Random(42);
      Random rn2 = new Random(42);
      Random rn3 = new Random(43);

      System.out.println(Arrays.toString(generateSequence(rn1)));
      System.out.println(Arrays.toString(generateSequence(rn2)));
      System.out.println(Arrays.toString(generateSequence(rn3)));
   }

   private static int[] generateSequence(Random rn) {
      return new int[]{
              rn.nextInt(10),
              rn.nextInt(23),
              rn.nextInt(93),
              rn.nextInt(15),
              rn.nextInt(76),
      };
   }
}
