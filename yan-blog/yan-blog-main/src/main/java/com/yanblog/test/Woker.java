package com.yanblog.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xujingyan on 2017/11/6.
 */
public class Woker {

    static final SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public void startWork(int i,AsyncHandler handler){
        /**
         *
         */
        System.out.println("woker-"+i+"start Work @" +sf.format(new Date()));
        handler.callback();
    }

    public static void main(String[] args){
        AsyncHandler asyncHandler=new AsyncHandler() {
            @Override
            public void handel() {
                System.out.println("handler start @ " + sf.format(new Date()));
            }
        };
        Woker woker=new Woker();
        woker.startWork(1,asyncHandler);
        System.out.println("main thread ending @" + sf.format(new Date()));
    }
}
