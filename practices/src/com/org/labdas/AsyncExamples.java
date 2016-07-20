package com.org.labdas;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

/**
 * Created by llarios on 7/20/16.
 */
public class AsyncExamples {


    public static void main(String args[]) {


        CompletableFuture completableFuture1 = new CompletableFuture();
        new Thread(() -> {
            try {
                Thread.sleep(4000L);
            } catch (Exception e) {
                completableFuture1.complete(-100.0);
            }
            /*
             * we can manually "complete" a CompletableFuture!!
			 * this feature is not found with the classical Future interface
			 */
            completableFuture1.complete(100.0);
        }, "CompFut1-Thread").start();

        System.out.println("ok...waiting at: " + new Date());
        System.out.format("compFut value and received at: %f, %s \n", completableFuture1.join(), new Date());


    }
}
