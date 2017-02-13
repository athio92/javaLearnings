package com.anthony;

/**
 * Created by eclipze on 12/3/2016.
 */
public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar = 1;

    public ScopeCheck() {
        //custom constructor
        System.out.println("publicVar = " + publicVar + " ; privateVar = " + privateVar);

    }

    public int getPrivateVar() {
        return privateVar;
    }

    public void timesTwo() {
        int privateVar = 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + (i * privateVar));
        }
    }

    public class InnerClass {
        public int privateVar = 5;

        //constructor
        public InnerClass() {
            System.out.println("InnerClass is created, privateVar is " + privateVar);
        }

        public void timesThree() {
            ScopeCheck.this.timesTwo();
            int privateVar = 3;
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times three is " + (i * privateVar));
            }

        }

        public int getPrivateVar(){
            return privateVar;
        }
    }

}
