package com.mphasis.main.cui;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Point{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Task2 implements Callable<Point> {
    private static final Logger logger;
    static {
        logger = Logger.getLogger(Task2.class.getName());
    }
    @Override
    public Point call() throws Exception{
        logger.log(Level.INFO, "...............................Task started");
        Thread.sleep(2000);
        logger.log(Level.INFO, "...............................Task ended");

        return new Point(2,4);
    }
}


class Task implements Runnable{
    private static final Logger logger;
    static {
        logger = Logger.getLogger(Task.class.getName());
    }
    @Override
    public void run() {
        logger.log(Level.INFO, "...............................Task started");
//        logger.log(Level.INFO,Thread.currentThread().toString());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        logger.log(Level.INFO, "...............................Task ended");

/*

*/
    }
}

public class Main {
    private static final Logger logger;
    static {
        logger = Logger.getLogger(Main.class.getName());
    }

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(cores);

        Future<Point> future = service.submit(new Task2());    //Use submit for callable
        try {
            Point point = future.get();
            System.out.println(point);
        } catch (InterruptedException | ExecutionException exception) {
            exception.printStackTrace();
        }


        //custom pool with Threadpool Factory
//        ExecutorService service = new ThreadPoolExecutor(10,100,30,TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));
//
//        try {
//            service.execute(new Task());
//        }catch (RejectedExecutionException e){
//            e.printStackTrace();
//        }

//        ExecutorService executorService = Executors.newFixedThreadPool(cores);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        ScheduledExecutorService service = Executors.newScheduledThreadPool(cores);

//        logger.log(Level.INFO, "Begin");
//        service.schedule(new Task(), 5, TimeUnit.SECONDS);  //Executes the task after specified amount of time.
//        service.scheduleAtFixedRate(new Task(), 5, 3, TimeUnit.SECONDS);  //Repeated executions after 3(period) seconds.(time between two starts)
//        service.scheduleWithFixedDelay(new Task(), 5, 3, TimeUnit.SECONDS); // delay is difference between one task ending and second task starting.
//        logger.log(Level.INFO, "Submitted");

        service.shutdown();
//        executorService.execute(new Task());
//        executorService.shutdown();
    }
}
