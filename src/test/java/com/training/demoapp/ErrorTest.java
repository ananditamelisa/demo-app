package com.training.demoapp;

import org.junit.Test;

import java.util.ArrayList;

public class ErrorTest {
    @Test
    public void testDevideByZero(){
        int angka = 10/0;
    }
    @Test
    public void testNullPointerException(){
        String nama = null;
        String namaBesar = nama.toUpperCase();
    }
    @Test
    public void testArrayErrorIndex(){
        ArrayList<String> list = new ArrayList<>();
        list.get(10);
    }
    @Test
    public void  testError() throws Throwable{
        throw new Throwable(new Exception(new RuntimeException(new NullPointerException())));
    }

}
