package com.google.instrumenttest;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SharedPreferenceUtilsTest {
    public static final String TEST_KEY = "instrumentedTest";
    public static final String TEST_STRING = "TestString";
    private SharedPreferenceUtils sharedPreferenceUtils;

    @Before
    public void setUp() throws Exception {
        sharedPreferenceUtils = new SharedPreferenceUtils(BaseApplication.getContext());
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void sharedPreferenceDaoWriteRead() {
        sharedPreferenceUtils.put(TEST_KEY, TEST_STRING);
        Assert.assertEquals(TEST_STRING, sharedPreferenceUtils.get(TEST_KEY));
    }
}