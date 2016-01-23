package com.example.radurazvannesiu.flagger;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Radu & Razvan Nesiu on 1/17/2016.
 */
public class RandomNumberGenerator {

    private ArrayList<Integer> setOfNumbersQ = new ArrayList<Integer>();
    private ArrayList<Integer> setOfNumbersF = new ArrayList<Integer>();
    private static RandomNumberGenerator instance = new RandomNumberGenerator();
    private static int indexQ = 0;
    private static int indexF = 0;

    private RandomNumberGenerator() {
        for (int i = 0; i < QuestionDatabase.NR_OF_QUESTIONS; i++) {
            setOfNumbersQ.add(i);
        }
        for (int j = 0; j < QuestionDatabase.NR_OF_FLAGS * 5; j++) {
            setOfNumbersF.add(j);
        }
        // Randomly permute the sets of numbers
        Collections.shuffle(setOfNumbersQ);
        Collections.shuffle(setOfNumbersF);
    }

    public static RandomNumberGenerator getInstance() {
        return instance;
    }

    public void resetQuestionGenerator(){
        indexQ = 0;
        Collections.shuffle(setOfNumbersQ);
    }

    public int generateRandomQNumber() {
        int number = setOfNumbersQ.get(indexQ);
        indexQ++;
        return number;
    }

    public int generateRandomFNumber() {
        int flagNumber = setOfNumbersF.get(indexF) % QuestionDatabase.NR_OF_FLAGS;
        indexF++;
        if (indexF == QuestionDatabase.NR_OF_FLAGS) {
            indexF = 0;
            Collections.shuffle(setOfNumbersF);
        }
        return flagNumber;
    }
}
