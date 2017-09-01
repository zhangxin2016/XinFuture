package com.zx.tvm.asynchronous;

import lombok.extern.log4j.Log4j2;
import java.util.concurrent.CompletableFuture;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by zhangx on 2017/9/1
 */
@Log4j2
public class FutureTest {
    private static Random random = new Random();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        useCompletableFuture();
    }

    private static void CallableTest(){
        System.out.println("call start"+LocalTime.now());
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        try {
            Thread.sleep(5000);// 可能做一些事情
            System.out.println(future.get());
            System.out.println("call end"+LocalTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    // Future.get()  会阻塞线程直到返回结果
    private static void futureTest(){
        System.out.println("future start"+LocalTime.now());
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<Integer> future = threadPool.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });
        try {
            Thread.sleep(5000);// 可能做一些事情
            System.out.println(future.get());
            System.out.println("future end"+LocalTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //轮询任务A和任务B的运行状况，只有在A或者是B任务一个结束的情况下，C才能开始执行
    private static void useFuture() throws InterruptedException, ExecutionException{
        log.info("使用Future");
        //创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待.
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Void> futureA = executorService.submit(()->work("A1"));
        Future<Void> futureB = executorService.submit(()->work("B1"));
        while (true){
            try {
                futureA.get(1,TimeUnit.SECONDS);
                break;
            } catch (TimeoutException e) {
                log.info(e.getMessage());
            }
            try {
                futureB.get(1,TimeUnit.SECONDS);
                break;
            } catch (TimeoutException e) {
                log.info(e.getMessage());
            }
        }
        executorService.submit(()->work("C1"));
        executorService.shutdown();
    }
    //
    private static void useCompletableFuture() throws InterruptedException, ExecutionException {
        System.out.println("CompletableFuture");
        CompletableFuture<Void> futureA = CompletableFuture.runAsync(() -> work("A2"));
        CompletableFuture<Void> futureB = CompletableFuture.runAsync(() -> work("B2"));
        futureA.acceptEither(futureB, s->{
            System.out.println("gygdasdasihd");
        }).get();
    }

    public static Void work(String name) {
        System.out.println(name + " starts at " + LocalTime.now());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        System.out.println(name + " ends at " + LocalTime.now());
        return null;
    }
}
