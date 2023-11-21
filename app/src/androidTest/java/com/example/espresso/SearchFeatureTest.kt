package com.example.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class SearchFeatureTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `초기화면은_nothing을_보여줘야_한다`() {
        onView(withId(R.id.searchBar)).check(matches(withText("")))
        onView(withId(R.id.search_button)).check(matches(withText("search")))
        onView(withId(R.id.search_result)).check(matches(withText("nothing..")))
    }

    @Test
    fun searchBar에_test_를_입력했을_때_test_를_띄워준다() {
        Thread.sleep(1000)
        onView(withId(R.id.searchBar)).perform(typeText("test")).check(matches(withText("test")))
        Thread.sleep(1000)
        onView(withId(R.id.search_button)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.search_result)).check(matches(withText("test")))
        Thread.sleep(1000)
    }

}