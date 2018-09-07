package dk.easj.anbo.collectwords;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void testIt() {
        // Context of the app under test.
        //Context appContext = InstrumentationRegistry.getTargetContext();

        //assertEquals("dk.easj.anbo.collectwords", appContext.getPackageName());

        onView(withText("Type a word")).check(matches(isDisplayed()));
        onView(withId(R.id.mainwordedittext)).perform(typeText("Anders"));
        onView(withId(R.id.button_save)).perform(click());
        onView(withId(R.id.button_Show)).perform(click());
        onView(withId(R.id.textview_message)).check(matches(withText(("[Anders]"))));

        onView(withId(R.id.mainwordedittext)).perform(typeText("Peter"));
        onView(withId(R.id.button_save)).perform(click());
        onView(withId(R.id.button_Show)).perform(click());
        onView(withId(R.id.textview_message)).check(matches(withText(("[Anders, Peter]"))));

        onView(withId(R.id.button_clear)).perform(click());
        onView(withId(R.id.button_Show)).perform(click());
        onView(withId(R.id.textview_message)).check(matches(withText("empty")));
    }

    @Test
    public void test2() {
        onView(withText("Type a word")).check(matches(isDisplayed()));
    }
}
