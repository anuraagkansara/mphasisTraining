package com.mphasis.main.cui;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;


class CyclicBarrierTask implements Runnable{
    private final String name;
    CyclicBarrier barrier;
    CyclicBarrierTask(CyclicBarrier barrier,String name){
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        Logger logger = Logger.getLogger(CyclicBarrierTask.class.getName());
        logger.log(Level.INFO,() -> "Performing "+name);
        while(true) {
            try {
                barrier.await();
                logger.log(Level.INFO,() -> "Resuming "+name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }


    }
}
public class CBMain {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        CyclicBarrier barrier = new CyclicBarrier(3);
        service.execute(new CyclicBarrierTask(barrier,"Task 1"));
        service.execute(new CyclicBarrierTask(barrier,"Task 2"));
        service.execute(new CyclicBarrierTask(barrier,"Task 3"));


        Logger.getLogger(CBMain.class.getName()).log(Level.INFO,"End");

    }
}
