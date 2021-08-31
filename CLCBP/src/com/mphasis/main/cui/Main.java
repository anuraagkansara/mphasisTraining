package com.mphasis.main.cui;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

class DependentService implements Runnable{
    private final String name;
    private final  long duration;
    CountDownLatch latch;
    DependentService(CountDownLatch latch,String name,long duration){
        this.latch = latch;
        this.name = name;
        this.duration = duration;
    }

    @Override
    public void run() {
        Logger logger = Logger.getLogger(DependentService.class.getName());
        logger.log(Level.INFO,() -> "Performing "+name);
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        logger.log(Level.INFO,() -> "Resuming "+name);

    }
}


public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(3);
        service.execute(new DependentService(latch," Dependent Service 1",2000));
        service.execute(new DependentService(latch," Dependent Service 2",3000));
        service.execute(new DependentService(latch," Dependent Service 3",4000));

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ;

        Logger.getLogger(Main.class.getName()).log(Level.INFO,"End");
    }
}
