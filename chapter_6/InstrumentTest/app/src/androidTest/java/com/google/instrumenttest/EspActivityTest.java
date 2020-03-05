package com.google.instrumenttest;

import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.web.assertion.WebViewAssertions;
import android.support.test.espresso.web.webdriver.DriverAtoms;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;

@RunWith(AndroidJUnit4.class)
public class EspActivityTest {
    @Rule
    public ActivityTestRule<EspActivity> rule = new ActivityTestRule<>(EspActivity.class);
    private IdlingResource idlingResource;

    @Before
    public void setUp() throws Exception {
        idlingResource = rule.getActivity().getIdlingResource();
        IdlingRegistry.getInstance().register(idlingResource);
    }

    @After
    public void tearDown() throws Exception {
        if (idlingResource != null) {
            IdlingRegistry.getInstance().unregister(idlingResource);
        }
    }

    @Test
    public void testClick() {
        Espresso.onView(withId(R.id.tv_text)).check(matches(withText("TextViewText")));
        Espresso.onView(withId(R.id.et_text)).perform
                (typeText("https://www.baidu.com"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.btn)).perform(ViewActions.click());
    }

    @Test
    public void testIntent() {
        //传递数据到WebViewActivity
        Intent intent = new Intent();
        intent.putExtra("url", "https://m.baidu.com");
        rule.launchActivity(intent);
        Espresso.onView(withId(R.id.wv)).perform(ViewActions.click());
        //通过name为"word"找到搜索输入框
        onWebView().withElement(findElement(Locator.NAME, "word"))
                //往输入框中输入字符串"android"
                .perform(DriverAtoms.webKeys("android"))
                //通过id为"index-bn"找到"百度一下"按钮
                .withElement(findElement(Locator.ID, "index-bn"))
                //执行点击事件
                .perform(webClick())
                //通过id为"results"找到结果div
                .withElement(findElement(Locator.ID, "results"))
                //检查div中是否包含字符串"android"
                .check(WebViewAssertions.webMatches(DriverAtoms.getText(),
                        Matchers.containsString("android")));
    }

}