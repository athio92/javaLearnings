package com.anthony;
public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");


        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");


        CountdownThread t3 = new CountdownThread(countdown);
        t3.setName("Thread 3");

        t1.start();
        t2.start();
        t3.start();


    }
}

//create thread class
class CountdownThread extends Thread{
    private Countdown countdown;

    //constructor:
    public CountdownThread(Countdown countdown){
        this.countdown = countdown;
    }

    //run method
    @Override
    public void run(){
        this.countdown.doCountdown();
    }


}




//create class with a method to do countdown based on which thread is currently running.

//Stack vs heap: Local Variables (variables inside a loop / inside a method, etc)
//are stored in each thread's stack. However, Instance Variables (fields of a class)
//are stored in the Heap, which is a memory shared by all stack.
//If the method doCountDown is NOT synchronized, thread interference will happen
//because t1 & t2 reads and updates Instance Variable int i.

class Countdown{

    //here, i = instance variable
    private int i;

    public void doCountdown(){
        String color;

        switch(Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            case "Thread 3":
                color = ThreadColor.ANSI_GREEN;
            default:
                color = ThreadColor.ANSI_GREEN;

        }

        synchronized(this){
            for (i=10; i>0; i--){
                System.out.println(color + Thread.currentThread().getName() + ": i=" + i);
            }
        }

    }
}

