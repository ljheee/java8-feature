package com.ljheee.java8.future;

import java.util.concurrent.CompletableFuture;

/**
 * taskA 依赖于taskB
 * taskA 没有异常，会正常执行B
 * 此方式，适用于 A B任务都是无返回。
 * 无论 thenRunAsync还是thenRun，在A执行完去执行B时，总会复用上一个ForkJoinPool的线程
 */
public class TaskDependency1 {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> taskA = CompletableFuture.runAsync(() -> {
            System.out.println("执行任务A1..." + Thread.currentThread().getName());// ForkJoinPool.commonPool-worker-1
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // A线程没有异常，会执行B
            System.out.println("finish A1...");
        });

        taskA.thenRunAsync(() -> {
            System.out.println(taskA.isCompletedExceptionally());
            System.out.println("执行任务B..." + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish B...");
        });


        Thread.sleep(30000);
//        taskA.whenComplete();

    }


}
