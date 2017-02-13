package com.series.anthony;

/**
 * Created by eclipze on 12/3/2016.
 */
public class Series {

    public static int nSum(int n) {
        int result = 0;
        if (n < 0) {
            System.out.println("Error. Method only valid for n>=0");
            return -1;
        }
        //else n>=0, enter code:

        for (int i = 0; i < n+1; i++) {
            result = result + i;
        }
        return result;
    }

    public static int factorial(int n) {
        int result = 1;
        if (n < 0) {
            System.out.println("Error. Method only valid for n>=0");
            return -1;
        } else if (n ==0 || n==1){
            result = 1;
            return result;
        }else{
            //n = 2 and above
            result = n * factorial(n-1);
            return result;
        }

    }

   public static int fibonacci(int n) {
        int result = 0;
        if (n < 0) {
            System.out.println("Error. Method only valid for n>=0");
            return -1;
        }else if (n==0 || n==1){
            return n;
        } else{
            result = fibonacci(n-1) +fibonacci(n-2);
            return result;
        }

    }

}
