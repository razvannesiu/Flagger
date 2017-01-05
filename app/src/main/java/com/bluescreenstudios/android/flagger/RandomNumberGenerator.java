package com.bluescreenstudios.android.flagger;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Singleton class that generates random question IDs & flag IDs.
 *
 * @author Razvan Nesiu
 */
@SuppressWarnings("WeakerAccess")
public class RandomNumberGenerator {

    /* Determines how many times a flag ID occurs in the list.
     (if this constant is set to 1, then once a flag ID is generated in a match,
     that flag ID won't occur anymore in that match,
     unless it's the ID of the correct-answer flag)*/
    public static final int REPEAT_FLAGS_X_TIMES = 5;
    private static final RandomNumberGenerator INSTANCE = new RandomNumberGenerator();
    private static int indexForQuestionIdsSet = 0;
    private static int indexForFlagIdsList = 0;
    /* Define constants: # of question IDs in set & # of flag IDs in list.
      (for efficiency: we won't have to compute these values each time they're used in a loop) */
    final int NR_OF_QUESTION_IDS_IN_SET = QuestionDatabase.NR_OF_QUESTIONS;
    final int NR_OF_FLAG_IDS_IN_LIST = QuestionDatabase.NR_OF_FLAGS * REPEAT_FLAGS_X_TIMES;
    //set of question IDs (one question ID occurs only once in the set)
    private final ArrayList<Integer> setOfQuestionIds = new ArrayList<>();
    //list of flag IDs (one flag ID can occur multiple times in the list)
    private final ArrayList<Integer> listOfFlagIds = new ArrayList<>();

    /**
     * Private default constructor for this singleton class.
     */
    private RandomNumberGenerator() {

        //populate set of question IDs
        for (int i = 0; i < NR_OF_QUESTION_IDS_IN_SET; i++) {
            setOfQuestionIds.add(i);
        }
        //populate list of flag IDs
        for (int j = 0; j < NR_OF_FLAG_IDS_IN_LIST; j++) {
            listOfFlagIds.add(j);
        }
        //randomly permute the set of question IDs & the list of flag IDs
        Collections.shuffle(setOfQuestionIds);
        Collections.shuffle(listOfFlagIds);
    }

    /**
     * Method used to get the instance of the singleton class.
     *
     * @return The only object created from this singleton class.
     */
    public static RandomNumberGenerator getInstance() {
        return INSTANCE;
    }

    /**
     * Generates a random question ID.
     * (once generated in a match, a question ID cannot be generated again in the same match)
     * In case of rematch, use {@link #resetQuestionIdGenerator() } to reset this method.
     * The question id generator gets restarted whenever a new game starts.
     */
    public int generateRandomQuestionId() {
        //get the questionId corresponding to the indexForQuestionIdsSet
        int questionId = setOfQuestionIds.get(indexForQuestionIdsSet);
        //increment index (so that this question ID won't be generated again in the same match)
        indexForQuestionIdsSet++;

        //if we run out of question ID's to generate, we reset the generator
        if(indexForQuestionIdsSet == NR_OF_QUESTION_IDS_IN_SET){
            resetQuestionIdGenerator();
        }

        return questionId;
    }

    /**
     * Resets the {@link #generateRandomQuestionId() } method,
     * by setting the indexForQuestionIdsSet to 0 & by reshuffling the setOfQuestionIds.
     */
    public void resetQuestionIdGenerator() {
        //reset the index for the set of question IDs
        indexForQuestionIdsSet = 0;
        //reshuffle the set of question IDs
        Collections.shuffle(setOfQuestionIds);
    }

    /**
     * Generates a random flag ID.
     * (once a flag ID is generated in a match, its chance to be generated again in the same match
     * depends on the constant {@link #REPEAT_FLAGS_X_TIMES } )
     * To avoid an {@exception #ArrayIndexOutOfBoundsException } given by indexForFlagIdsList,
     * we use {@link #resetFlagIdGenerator()}, after indexForFlagIdsList becomes equal to the size
     * of the list of flag Ids.
     * @see QuestionDatabase
     */
    public int generateRandomFlagId() {
        //get the flagId (flagId has to be less than the NR_OF_FLAGS stored in the database)
        int flagId = listOfFlagIds.get(indexForFlagIdsList) % QuestionDatabase.NR_OF_FLAGS;
        //increment index
        // (so that this flag ID would have a smaller chance to occur again in the same match)
        indexForFlagIdsList++;
        //if we run out of flag IDs to generate, we reset the generator
        if (indexForFlagIdsList == NR_OF_FLAG_IDS_IN_LIST) {
            resetFlagIdGenerator();
        }
        return flagId;
    }

    /**
     * Resets the {@link #generateRandomFlagId() } method,
     * by setting the indexForFlagIdsList to 0 & by reshuffling the listOfFlagIds.
     */
    public void resetFlagIdGenerator() {
        //reset the index for the list of flag IDs
        indexForFlagIdsList = 0;
        //reshuffle the list of flag IDs
        Collections.shuffle(listOfFlagIds);
    }
}