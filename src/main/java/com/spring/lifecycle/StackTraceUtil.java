package com.spring.lifecycle;

public class StackTraceUtil {

    /**
     * 从当前线程的调用栈中，获取当前调用的方法
     * @return
     */
    public static String getCurrentMethodName() {
        // getStackTrace()[0] 为 getStackTrace() 方法本身。
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

}
