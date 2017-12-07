package com.yanblog.test;

/**
 * Created by xujingyan on 2017/11/6.
 */
abstract class AsyncHandler {
    public void callback(){
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handel();
//        Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                handel();
//            }
//        });
//        thread.start();
    }

    abstract public void handel();
}
