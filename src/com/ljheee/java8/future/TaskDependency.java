package com.ljheee.java8.future;

import java.util.concurrent.CompletableFuture;

/**
 * taskA 依赖于taskB
 *
 * 此方式，适用于 A B任务都是无返回
 */
public class TaskDependency {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> taskA = CompletableFuture.runAsync(() -> {
            System.out.println("执行任务A1..." + Thread.currentThread().getName());// ForkJoinPool.commonPool-worker-1
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int a = 1/0; // A线程在此抛出异常，不会执行B
            System.out.println("finish A1...");
        });

        taskA.exceptionally(throwable -> {
            System.out.println(throwable);
            return null;
        });
        // taskA 外抛异常，不会执行后续的taskB

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
