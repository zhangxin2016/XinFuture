package com.zx.tvm.asynchronous;

import lombok.extern.log4j.Log4j2;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.operators.SingleOnSubscribeUsing;
import rx.util.async.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by zhangx on 2017/9/1
 */
@Log4j2
public class RxjavaTest {
    public static void hello(){
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B1"+Thread.currentThread());
            String s = readValue();
            return s;
        });
        CompletableFuture<Void> futureB = CompletableFuture.runAsync(() ->
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("b2"+Thread.currentThread());});

        Observable.zip(Observable.from(futureA),Observable.from(futureB),(a,b)->{
           return a+b;
        }).subscribe(fs->{
            System.out.println(fs);
        });
       /* Observable.from(CompletableFuture.allOf(futureA,futureB)).subscribe(fs->{
            try {
                String s = futureA.get();
                System.out.println(fs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("执行完毕"+Thread.currentThread());
        });*/
    }

    public static void main(String[] args) {
        asyncTest();
    }

    public static String readValue(){
        String a = "nihao";
        return a;
    }
    /*
     * just函数，它接受一至九个参数，返回一个按参数列表顺序发射这些数据的Observable
     * from 接受数组，返回一个按参数列表顺序发射这些数据的Observable
     */
    public static void listTest(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        Observable<String> observable = Observable.just("one","two");
        observable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("a");
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }

    /*
     * 操作符对原始Observable发射的每一项数据应用一个你选择的函数，然后返回一个发射这些结果
     */
    public static void mapTest(){
        Observable.just("hello","rxjava").map(s->{
            return s.toUpperCase();
        }).subscribe(a->{
            System.out.println(a);
        });
    }
    /*
     * flatMap()接收一个Observable的输出作为输入，然后作为一个新的Observable再发射。
     * flatMap输出的新的Observable正是我们在Subscriber想要接收的
     */
    public static void flatMap(){
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("RxJava");
        Observable.from(list).flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.just(s+"qwe");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("comple");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }
    /*
     * 一个累加器函数，操作符对原始Observable发射的第一项数据应用一个函数，
     * 然后将那个函数的结果作为自己的第一项数据发射
     * lambda 表达式之外 可以new function
     */
    public static void scanTest(){
        Observable.just(1,2,3,4,5).scan((a,b)->{
            return a+b;
        }).subscribe(a->{
            System.out.println(a);
        });
    }

    /*
     *  filter 观测序列中只有通过的数据才会被发射
     */
    public static void filterTest(){
        Observable.just(4, 2, 1, 7, 5)
                .filter(a->{
                    return a>3;
                }).subscribe(b->{
                    System.out.println(b);
                });
    }

    /*
     * 合并两个或者多个Observables发射出的数据项，
     * 根据指定的函数Func2变换它们，并发射一个新值
     */
    public static void zipTest(){
        Observable<Integer> observable1 = Observable.just(1, 3, 5);
        Observable<Integer> observable2 = Observable.just(2, 4, 6, 9);
        Observable.zip(observable1, observable2, (a,b)->{
            return a+b;
        }).subscribe(b->{
            System.out.println(b);
        });
    }
    /*
     * join startWith
     * .startWith(1)
     * 在数据序列的开头插入一条指定的项1
     */

    /*
     * 异步  使用的是rxjava-async模块
     */
    public static void asyncTest(){
        CompletableFuture future = CompletableFuture.supplyAsync(()->{
            String a = "xin";
            return a;
        });
        Async.start(new Func0<String>() {
            @Override
            public String call() {
                return "zx";
            }
        }).subscribe(x->{
            System.out.println(x+":"+Thread.currentThread());
        });

        Async.startFuture(new Func0<Future<?>>() {
            @Override
            public Future<?> call() {
                return future;
            }
        }).subscribe(x->{
            System.out.println(x+":"+Thread.currentThread());
        });
        Async.start(new Func0<String>() {
            @Override
            public String call() {
                return "zx1";
            }
        }).subscribe(x->{
            System.out.println(x+":"+Thread.currentThread());
        });
        Async.start(new Func0<String>() {
            @Override
            public String call() {
                return "zx2";
            }
        }).subscribe(x->{
            System.out.println(x+":"+Thread.currentThread());
        });
        Async.start(new Func0<String>() {
            @Override
            public String call() {
                return "zx3";
            }
        }).subscribe(x->{
            System.out.println(x+":"+Thread.currentThread());
        });
    }
}
