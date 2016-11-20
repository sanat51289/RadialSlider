package pony.horshoeslider;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.MotionEvents;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.MotionEvent;
import android.view.View;

import junit.framework.Assert;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("pony.horshoeslider", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(
            MainActivity.class,
            true,     // initialTouchMode
            false);   // launchActivity. False to customize the intent

    @Test
    public void intent() throws InterruptedException {
        Intent intent = new Intent();

        activityRule.launchActivity(intent);

        ViewAction slideThumb = new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayed(), isAssignableFrom(HorseShoeSlider.class));
            }

            @Override
            public String getDescription() {
                return "move slider";
            }

            @Override
            public void perform(UiController uiController, View view) {
                float[] coordinates = GeneralLocation.BOTTOM_LEFT.calculateCoordinates(view);
                MotionEvent motionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 3000L, MotionEvent.ACTION_MOVE, coordinates[0], coordinates[1], 0);
                MotionEvents.sendMovement(uiController, motionEvent, coordinates);
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        onView(ViewMatchers.withId(R.id.slider)).perform(slideThumb);
    }

    /*    CoordinatesProvider coordinatesProvider = new CoordinatesProvider() {
                    @Override
                    public float[] calculateCoordinates(View view) {
                        HorseShoeSlider slider = (HorseShoeSlider) view;
                        ArrayList<View> views = new ArrayList<>();
                        slider.findViewsWithText(views, "35", View.FIND_VIEWS_WITH_TEXT);
                        return new float[]{views.get(0).getX(), views.get(0).getY()};
                    }
                };*/
}
