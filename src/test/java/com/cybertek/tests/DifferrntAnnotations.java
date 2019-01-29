package com.cybertek.tests;

import com.google.common.annotations.VisibleForTesting;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DifferrntAnnotations {

    @Test
    public void testOne(){
        System.out.println("This is test one");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is before method");
    }

    @Test
    public void testTwo(){
        System.out.println("This is test two");
    }

}
