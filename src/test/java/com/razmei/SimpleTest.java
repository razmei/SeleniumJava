package com.razmei;

import org.testng.annotations.Test;

public class SimpleTest {

    public void setUp() {

    }

    @Test(groups = {"fast"})
    public void aFastTest() {
        System.out.println("Fast test");
    }

    @Test(groups = {"slow"})
    public void aSlowTest() {
        System.out.println("Slow test");
    }
}
