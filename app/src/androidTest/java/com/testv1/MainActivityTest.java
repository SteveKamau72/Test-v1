package com.testv1;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by steve on 7/19/17.
 */
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private String invalidTestValues = "ffe,123";
    private String validTestValues = "125, 254, 10, 6, 4765";

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

    @Test
    public void testUserInputScenario() {//user clicks button with valid input
        //input some text
        Espresso.onView(withId(R.id.editText)).perform(typeText(validTestValues));
        //perform button click
        Espresso.onView(withId(R.id.go)).perform(click());
        //checking the result in textview
        Espresso.onView(withId(R.id.result)).check(matches(withText("48")));
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Done with unit test!");
    }

}