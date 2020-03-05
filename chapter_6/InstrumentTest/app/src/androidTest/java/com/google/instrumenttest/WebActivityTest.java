package com.google.instrumenttest;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class WebActivityTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("espresso:setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("espresso:tearDown");
    }

    @Test
    public void onCreate() {
        System.out.println("espresso:onCreate");
    }

    @Test
    public void onKeyDown() {
        System.out.println("espresso:onKeyDown");
    }


}