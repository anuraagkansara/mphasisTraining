package com.mphasis.main.cui;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;

class PhaserCDLTask implements Runnable{
    private final String name;
    Phaser phaser;
    int duration;
    PhaserCDLTask(Phaser phaser,String name,int duration){
        this.phaser = phaser;
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
        phaser.arriveAndDeregister();
        logger.log(Level.INFO,() -> "Resuming "+name);

    }
}


public class PhCLMain {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(4);
        Phaser phaser = new  Phaser(3);
        service.execute(new PhaserCDLTask(phaser," Dependent Service 1",1000));
        service.execute(new PhaserCDLTask(phaser," Dependent Service 2",2000));
        service.execute(new PhaserCDLTask(phaser," Dependent Service 3",3000));

        phaser.arriveAndAwaitAdvance();

        Logger.getLogger(PhCLMain.class.getName()).log(Level.INFO,"End");
    }
}
