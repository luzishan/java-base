package com.snym.javabase.thread.interrupt;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * sleep中断线程
 *
 * @author luzishan
 * @date 2021/11/05 15:11
 **/
public class SleepInterruptThread extends Thread {

    /**
     * 测试sleep中断线程
     *
     * @param args 11
     * @return void
     * @author luzishan
     * @date 2021/11/05 15:17
     */
    public static void main(String[] args) {
        try {
            SleepInterruptThread thread = new SleepInterruptThread();
            thread.start();
            Thread.sleep(100);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }


    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            AtomicInteger i = new AtomicInteger();
            while (true) {
                i.incrementAndGet();
                System.out.println("===========");
                if(Thread.currentThread().isInterrupted()){
                    throw new InterruptedException();
                }else {
                    if(i.get() == 60000){
                        break;
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("线程" + Thread.currentThread().getName() + "在休眠时被中断");
            System.out.println("线程状态:" + Thread.currentThread().isInterrupted());
            e.printStackTrace();
        }
        System.out.println("run end");
    }
}
