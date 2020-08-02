package com.atnt.training1.userDemo.utils;

public class Utils {
    private static Long userId = 10000l;

    public static Long getNextUserSequence(){
        return userId++;
    }
}
