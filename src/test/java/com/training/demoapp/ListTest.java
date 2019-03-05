package com.training.demoapp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListTest {
    @Test
    public void testArrayList() {
        ArrayList <String> list = new ArrayList<>();
        //di spesifikasi in jadi string karena kalo ngga, dia bakal dalam bentuk object. akibatnya semua tipe data bisa
        list.add("Anandita");
        list.add("Melisa");


        Assert.assertTrue("Size list harus 2", list.size()==2);
        Assert.assertTrue("List harus berisi kata Melisa", list.contains("Melisa"));
    }
    @Test
    public void testLinkedList(){
        LinkedList <String> linkedList = new LinkedList<>();
        linkedList.add("Gilang");
        linkedList.add("Rabbani");

        Assert.assertTrue("Size list harus 2", linkedList.size()==2);
        Assert.assertFalse("List tidak boleh berisi melisa", linkedList.contains("melisa"));
    }
}
