package com.cybertek.tests;

import javax.xml.transform.sax.SAXSource;

public class TestNGDemo {
    public void testOne(){
        System.out.println("Hello World!");

        String expected = "a";
        String actual = "B";
        if (expected.equals(actual)){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        // this is not how you test in TestNG
    }
}
