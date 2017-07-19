package com.testv1;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by steve on 7/19/17.
 */
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private String invalidTestValues = "ffe,123";

    @Before
    public void setUp() throws Exception {
        System.out.println("Start unit test!");
    }

    @Test
    public void testEmptyInputScenario() {//user clicks button with empty input
        //input some text
        Espresso.onView(withId(R.id.editText)).perform(typeText(""));
        //perform button click
        Espresso.onView(withId(R.id.go)).perform(click());
    }

    @Test
    public void testInvalidInputScenario() {//user clicks button with invalid input
        //input some text
        Espresso.onView(withId(R.id.editText)).perform(typeText(invalidTestValues));
        //perform button click
        Espresso.onView(withId(R.id.go)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Done with unit test!");
    }

}