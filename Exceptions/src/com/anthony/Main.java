
package com.anthony;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Created by eclipze on 12/4/2016.
 */
public class Main {

    public static void main(String[] args) {

/*
        int x = 98;
        int y = 0;
        System.out.println(divideLBYL(x,y));
        System.out.println(divideEAFP(x,y));
        System.out.println(divide(x,y));
*/

        int x = getIntEAFP();
        System.out.println("x is " + x);
    }

    private static int getIntEAFP(){
        Scanner scanner = new Scanner(System.in);
        try{
            return scanner.nextInt();
        }catch(InputMismatchException e){
            return 0;
        }


    }

    private static int divideLBYL(int x, int y) {
        //Look Before You Leap: check for errors first!
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }

    }

    private static int divideEAFP(int x, int y) {
        //Easy to Ask for Forgiveness and Permission
        try{
            return x/y;

        }catch(ArithmeticException e){
            return 0;
        }
    }

    private static int divide(int x, int y){
        return x/y;
    }


}
