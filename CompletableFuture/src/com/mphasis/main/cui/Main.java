package com.mphasis.main.cui;

import java.util.concurrent.CompletableFuture;

public class Main {                                      //Program to demonstrate Async tasks.
    public static void print(Integer data){
        System.out.println("Inside print " + Thread.currentThread());
        System.out.println(data);
    }

    public static void main(String[] args) {

//        create().thenAccept((data) -> System.out.println(data));
        CompletableFuture<Integer> cFuture = create();  //This uses ForkJoinPool thread pool.
//        CompletableFuture<Integer> cFuture = new CompletableFuture<>();
        process(cFuture);
//        cFuture.complete(4);// This doesn't uses the ForkJoinPool thread pool.
    }

    public static CompletableFuture<Integer> create(){             //<Integer> because compute() returns int
        System.out.println("Inside create:" + Thread.currentThread());
        return CompletableFuture.supplyAsync(() -> compute());     //empty () is the get method of functional interface
    }

    public static int compute(){
        System.out.println("Inside compute" + Thread.currentThread());
        return 2;
    }

    public static void process(CompletableFuture<Integer> cFuture){
        cFuture.thenApply(data -> data*2)
        .thenApply(data -> data/0)
        .exceptionally(throwable -> handle(throwable))  //return value of handle used if the exception happens.
        .thenAccept(data -> print(data))   //thenAccept consumes something that has been produced by create().
        .thenRun(() -> System.out.println("1"))    //Chained execution, no semicolon
        .thenRun(() -> System.out.println("2"));
    }

    public static int handle(Throwable throwable){  //for every transformation(thenApply()) give separate exceptionally and handler function.
        System.out.println("ERROR: " + throwable);
        return 1;
    }
}
