import java.util.Random;


/**
 * Created by eclipze on 2017/01/08.
 */
public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

class Message {

    private String message;
    private boolean empty = true;

    //When a thread is reading or writing the message, no other thread should interfere.
    //In both read() and write(String message), we use wait() inside a 'while' loop.
    //When the waiting thread is woken up by 'notify' or other reason, the while loop
    //ensures that proper condition is met before the rest of code is executed.
    //If the right condition is not met, the awoken thread will go back to 'wait' mode.

    public synchronized String read() {

        while (empty) {
           try {
               wait();
           }catch(InterruptedException e){

           }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {


        while (!empty) {
           try{
               wait();
           }catch(InterruptedException e){

           }
        }

        empty = false;
        this.message = message;
        notifyAll();

    }


}


class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String messages[] = {
                "Humpty Dumpty sat on a wall",
                "Humpty Dumpty had a great fall",
                "All the king's horses and all the king's men",
                "Couldn't put Humpty together again"
        };

        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }

        message.write("Finished");
    }
}


class Reader implements Runnable{
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run(){
        Random random = new Random();
        for (String latestMessage=message.read(); !latestMessage.equals("Finished");
             latestMessage = message.read()){
            System.out.println(latestMessage);
            try{
                Thread.sleep(random.nextInt(2000));
            }catch(InterruptedException e){

            }
        }

    }

}

