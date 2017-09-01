package com.ratpack.xin.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 辅助用的工具类  创建线程池
 * Created by zhangx on 2017/9/1.
 * copy to caoqingguang
 */
public abstract class ThreadPools {

  /**
   * @param threadPrefix 线程前缀
   * @param threadNum  线程数
   * @return
   */
  public static ExecutorService getExecutor(String threadPrefix,int threadNum){
    AtomicInteger currentNum = new AtomicInteger();
    return Executors.newFixedThreadPool(threadNum
      , r -> new Thread(r, String.format("%s-%d-%d",threadPrefix,threadNum,currentNum.getAndIncrement())));
  }

  /**
   *
   * @param threadPrefix
   * @param threadNum
   * @param priority 线程优先级 1最低  10最高
   * @return
   */
  public static ExecutorService getExecutor(String threadPrefix,int threadNum,int priority){
    AtomicInteger currentNum = new AtomicInteger();
    return Executors.newFixedThreadPool(threadNum
      , r -> {
        Thread thread = new Thread(r, String.format("%s-%d-%d", threadPrefix, threadNum, currentNum.getAndIncrement()));
        thread.setPriority(priority);
        return thread;
      });
  }

}
