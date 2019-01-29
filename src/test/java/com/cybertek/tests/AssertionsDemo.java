package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

    @Test
    public void test1(){
        String a = "A";
        String b = "A";

        Assert.assertEquals(a,b); //comparing a to b
    }

    @Test
    public void test2(){
        String a = "A";
        String b = "AAA";

        Assert.assertEquals(a, b);
        // comparing a to b, first param is actual second is expected
    }
}
