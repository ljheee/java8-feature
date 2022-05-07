package com.ljheee.java8.future;

import java.util.concurrent.CompletableFuture;

/**
 * taskA 任务过程，不外抛异常，taskA.thenRun时就能执行后续的任务
 */
public class TaskDependency0 {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> taskA = CompletableFuture.runAsync(() -> {
            System.out.println("执行任务A1..." + Thread.currentThread().getName());// ForkJoinPool.commonPool-worker-1
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                int a = 1 / 0; // A线程在此抛出异常，并吞掉
            } catch (Exception e) {
                e.printStackTrace();
                // swallow it
            }
            System.out.println("finish A1...");
        });

        taskA.thenRun(() -> {
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
