package com.training.demoapp;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogAppTest {

    @Test
    public void testSingleton(){
        LogApp app1 = LogApp.getInstance();
        LogApp app2 = LogApp.getInstance();
        Assert.assertTrue("App1 harus sama App2", app1==app2);
    }

    @Test
    public void run() {
        LogApp app = LogApp.getInstance();
        app.run();
        Assert.assertTrue("App harus berjalan", app.isStart());
        app.stop();
        Assert.assertFalse("App harus berhenti", app.isStart());
    }
}