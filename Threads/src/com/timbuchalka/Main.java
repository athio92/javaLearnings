package com.timbuchalka;

import static com.timbuchalka.ThreadColor.ANSI_GREEN;
import static com.timbuchalka.ThreadColor.ANSI_PURPLE;
import static com.timbuchalka.ThreadColor.ANSI_RED;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        //Creating an instance of thread from a subclass that EXTENDS Thread
        final Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        //Creating an instance of thread using anonymous subclass of Thread
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

        //Creating an instance of thread from a class that IMPLEMENTS Runnable.
        //Syntax: Thread x = new Thread(object implementing runnable)

        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from MyRunnable Thread");
                try{
                    //join: wait until either the other thread returns/finish executing OR timeout period has reached before continue
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "AnotherThread is terminated OR timeout reached. MyRunnable runs again.");
                }catch(InterruptedException e){
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted");
                }

            }
         }
        );

        myRunnableThread.start();

//        anotherThread.interrupt();



        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");

    }
}
