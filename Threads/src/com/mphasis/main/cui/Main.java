package com.mphasis.main.cui;

import java.util.logging.Level;
import java.util.logging.Logger;

class Data{
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Task implements Runnable {
    private static final Logger logger;
    Data data;
    static {
        logger = Logger.getLogger(Task.class.getName());
    }

    Task(){
        data = new Data();
    }

    @Override
    public void run() {
        Thread currThread = Thread.currentThread();

        for (int counter = 0; counter <5; counter++)
        {
            if(currThread.getName().equals("Producer"))
            {

                synchronized (data){      //attempts to acquire the lock.
                    data.setValue(counter);
                    print(currThread.getName() + String.valueOf(data.getValue()));
                    try {
                        data.notify();
                        data.wait();                // simply writing wait(); means waiting on Task object but we have locked "Data" object
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
            else if(currThread.getName().equals("Consumer"))
            {
                synchronized (data){      //attempts to acquire the lock.
                    print(currThread.getName() + String.valueOf(data.getValue()));
                    try {
                        data.notify();  //doesn't throws exception so can be written outside try/catch block also
                        data.wait();
                        //Anything written after wait() will only be executed after the thread gets out of object's wait pool
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }

            }
        }
    }

    private static void print(String str){
        logger.log(Level.INFO,str);
    }
}

public class Main {
    private static final Logger logger;
    static{
        logger = Logger.getLogger(Main.class.getName());
    }
    private static void print(String str){
        logger.log(Level.INFO,str);
    }

    public static void main(String[] args) {
	// write your code here
        print(String.valueOf(Runtime.getRuntime().availableProcessors()));
        Thread mainThread = Thread.currentThread();
//        print(mainThread.toString());
//        print(mainThread.getState().toString());

        Task task = new Task();
        Thread thread1 = new Thread(task, "Producer");
        Thread thread2 = new Thread(task, "Consumer");

//        print(thread1.toString());
//        print(thread1.getState().toString());

        thread1.start();           //MULTIPLE THREADS RUNNING
        thread2.start();
//

//        print("Thread 1 ------->>" + thread1.getState().toString());
//        print("Thread 2 ------->>" + thread2.getState().toString());

        try {
            thread1.join();            //MAIN THREAD WAITING FOR THREAD 1 & 2 TO FINISH OR DIE.
            thread2.join();             //CAN BE USED TO STOP MAIN FROM TERMINATING BEFORE THREAD 1 & 2.
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

//        print("Thread 1 ------->>" + thread1.getState().toString());
//        print("Thread 2 ------->>" + thread2.getState().toString());

        System.out.println("End....");
    }

}
