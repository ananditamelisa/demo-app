package com.training.demoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogApp {
    //SINGLETON
    private static final LogApp INSTANCE = new LogApp();

    public static LogApp getInstance(){
        return INSTANCE;
    }
    //SINGLETON


    private Logger logger = LoggerFactory.getLogger(LogApp.class);
    private boolean state = false;

    private LogApp(){}
    public void run(){
        logger.info("Ini info");
        logger.warn("ini warning");
        logger.error("Ini error");

        state = true;
    }
    public void stop(){
        state = false;
    }
    public boolean isStart(){
        return state;
    }
}
