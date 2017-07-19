package com.testv1;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

/**
 * Created by steve on 7/19/17.
 */
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        System.out.println("Start unit test!");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Done with unit test!");
    }

}