package b12app.vyom.com.simplejunittestexample;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.EditText;
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

public class NextActivityTest {

    @Rule
    public ActivityTestRule<NextActivity> activityTestRule = new ActivityTestRule<>(NextActivity.class);

    private NextActivity context;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(NextActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        context = activityTestRule.getActivity();
    }

    @Test
    public void testTextChangeAction(){
        assertNotNull(context);
        EditText etInput = context.findViewById(R.id.etInputText);
        TextView tvOutput = context.findViewById(R.id.tvOutput);

        //checking if etInput and tvOutput are not null?
        assertNotNull(etInput);
        assertNotNull(tvOutput);

        //performing onclick event on the view with id.
        onView(withId(R.id.btnChange)).perform(click());

        assertEquals(tvOutput.getText().toString(),etInput.getText().toString());


    }

    @After
    public void tearDown() throws Exception {

        context = null;
    }
}