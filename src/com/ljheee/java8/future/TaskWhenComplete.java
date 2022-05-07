package com.ljheee.java8.future;

import java.util.concurrent.CompletableFuture;

/**
 * A 执行完、且A没有异常，再去执行B
 * 用taskA.whenComplete实现：A完成时，检查是否A有异常
 */
public class TaskWhenComplete {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> taskA = CompletableFuture.runAsync(() -> {
            System.out.println("执行任务A1..." + Thread.currentThread().getName());// ForkJoinPool.commonPool-worker-1
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int a = 1 / 0; // A线程在此抛出异常，不会执行B
            System.out.println("finish A1...");
        });


        taskA.whenComplete((result, throwable) -> {
                    if (throwable != null) {
                        System.out.println("Unexpected error:" + throwable);
                    } else {
                        // A 没有异常，去执行B
                        taskA.thenRun(() -> {
                            System.out.println(taskA.isCompletedExceptionally());
                            System.out.println("执行任务B..." + Thread.currentThread().getName());
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("finish B...");
                        });
                    }
                }
        );


        Thread.sleep(30000);
//        taskA.whenComplete();

    }
}
