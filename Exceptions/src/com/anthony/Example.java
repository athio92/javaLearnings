package com.anthony;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by eclipze on 12/4/2016.
 */
public class Example {

    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division. Shutting down.");
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("No input. Shutting down.");
        }
    }


    private static int divide() {
        int x, y;
      //  try {
            x = getInt();
            y = getInt();
            System.out.println("X is " + x + " , y is " + y);
            return x / y;
        /*} catch (NoSuchElementException e) {
            throw new NoSuchElementException("No suitable input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by zero");
        }*/

    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        while (true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("Please enter a number using only digits 0-9");
            }

        }

    }
}