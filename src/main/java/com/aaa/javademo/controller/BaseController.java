package com.aaa.javademo.controller;

import com.aaa.javademo.util.ThreadParam;
import com.aaa.javademo.util.Watch;

public class BaseController {

    protected String msg(String msg) {
        Watch w = ThreadParam.get();
        return w.logMsg(msg);
    }
}
