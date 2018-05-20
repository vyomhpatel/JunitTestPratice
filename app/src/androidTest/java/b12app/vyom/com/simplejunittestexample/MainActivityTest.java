package b12app.vyom.com.simplejunittestexample;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity context;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(NextActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        context = activityActivityTestRule.getActivity();
    }

    @Test
    public void testTextView(){
        final TextView view = context.findViewById(R.id.tvTest);
       assertEquals(view.getText(),"Hello World!");

       onView(withId(R.id.button)).perform(click());

      Activity nextActivity =  getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
      assertNotNull(nextActivity);
    }

    @Test
    public void testLaunchSecondActivity(){
        assertNotNull(context.findViewById(R.id.button));
    }

    @After
    public void tearDown() throws Exception {
        context = null;
    }
}