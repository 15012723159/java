package com.qfx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
    // 这个代码重复 最好可以共用
    public static  Logger Log;
    private  Class clazz;
    public BaseController() {
        clazz = this.getClass();
        Log = LoggerFactory.getLogger(clazz);
    }
}
