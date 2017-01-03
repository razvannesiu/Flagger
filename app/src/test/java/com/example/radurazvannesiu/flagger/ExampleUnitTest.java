package com.example.radurazvannesiu.flagger;


import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void testFlagNames(){
        assertEquals("Union of Burma", SinglePlayerQuiz.getFormattedFlagName("union_of_burma"));
        assertEquals("Bosnia and Herzegovina", SinglePlayerQuiz.getFormattedFlagName("bosnia_and_herzegovina"));
        assertEquals("Brunei", SinglePlayerQuiz.getFormattedFlagName("brunei"));
    }

    @Test
    public void testAlways4OptionsPerQuestion() throws Exception {
        int questionId;

        //check multiple times
        for(long i = 0; i < 1000000; i++) {
            //get a random question ID from the database and store it in questionId
            questionId = MultiPlayerQuiz.QDB.getRandomQuestionId();
            //get the array list of the flags that will be displayed for this question
            ArrayList<Integer> flags = MultiPlayerQuiz.QDB.getFlagIndexesArrayList(questionId);

            //no 2 flags are the same
            assertNotEquals(flags.get(0), flags.get(1));
            assertNotEquals(flags.get(0), flags.get(2));
            assertNotEquals(flags.get(0), flags.get(3));
            assertNotEquals(flags.get(1), flags.get(2));
            assertNotEquals(flags.get(1), flags.get(3));
            assertNotEquals(flags.get(2), flags.get(3));

            //check if there are 4 options
            assertEquals(4, flags.size());
        }
    }
}