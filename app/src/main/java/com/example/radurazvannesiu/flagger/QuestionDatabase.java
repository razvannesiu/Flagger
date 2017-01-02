package com.example.radurazvannesiu.flagger;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Singleton class that stores the questions & their IDs, flags & their IDs,
 * and an array that maps a question ID to its corresponding flag ID.
 */
@SuppressWarnings("WeakerAccess")
public class QuestionDatabase {

    //total # of questions store in database
    public static final int NR_OF_QUESTIONS = 131;
    //total # of flags stored in database
    public static final int NR_OF_FLAGS = 94;
    //array that stores the questions
    public static final String[] QUESTIONS = new String[NR_OF_QUESTIONS];
    //array that stores the names of the png files that represent the flags
    public static final String[] FLAGS = new String[NR_OF_FLAGS];
    //array that maps a question ID to its corresponding flag ID
    //(each question has only one correct answer, and the correct answer is the correct flag ID)
    public static final int[] QUESTION_ANSWER_MAP = new int[NR_OF_QUESTIONS];
    // # of flags displayed as options (option A, option B, etc.)
    public static final int NR_OF_OPTIONS = 4;
    private static final QuestionDatabase INSTANCE = new QuestionDatabase();
    private final RandomNumberGenerator GENERATOR = RandomNumberGenerator.getInstance();

    /**
     * Private default constructor for this singleton class.
     */
    private QuestionDatabase() {
        //writing the questions, and their answer IDs
        QUESTIONS[0] = "What is the flag of Romania?";
        QUESTION_ANSWER_MAP[0] = 0;

        QUESTIONS[1] = "What is the flag of Russia?";
        QUESTION_ANSWER_MAP[1] = 1;

        QUESTIONS[2] = "What is the flag of Indonesia?";
        QUESTION_ANSWER_MAP[2] = 2;

        QUESTIONS[3] = "What is the flag of Ukraine?";
        QUESTION_ANSWER_MAP[3] = 3;

        QUESTIONS[4] = "What is the flag of Poland?";
        QUESTION_ANSWER_MAP[4] = 4;

        QUESTIONS[5] = "What is the flag of Italy?";
        QUESTION_ANSWER_MAP[5] = 5;

        QUESTIONS[6] = "What is the flag of Hungary?";
        QUESTION_ANSWER_MAP[6] = 6;

        QUESTIONS[7] = "What is the flag of Greece?";
        QUESTION_ANSWER_MAP[7] = 7;

        QUESTIONS[8] = "What is the flag of Japan?";
        QUESTION_ANSWER_MAP[8] = 8;

        QUESTIONS[9] = "What is the flag of Afghanistan?";
        QUESTION_ANSWER_MAP[9] = 9;

        QUESTIONS[10] = "What is the flag of Albania?";
        QUESTION_ANSWER_MAP[10] = 10;

        QUESTIONS[11] = "What is the flag of Andorra?";
        QUESTION_ANSWER_MAP[11] = 11;

        QUESTIONS[12] = "What is the flag of Armenia?";
        QUESTION_ANSWER_MAP[12] = 12;

        QUESTIONS[13] = "What is the flag of Austria?";
        QUESTION_ANSWER_MAP[13] = 13;

        QUESTIONS[14] = "What is the flag of Azerbaijan?";
        QUESTION_ANSWER_MAP[14] = 14;

        QUESTIONS[15] = "What is the flag of Bahrain?";
        QUESTION_ANSWER_MAP[15] = 15;

        QUESTIONS[16] = "What is the flag of Bangladesh?";
        QUESTION_ANSWER_MAP[16] = 16;

        QUESTIONS[17] = "What is the flag of Belarus?";
        QUESTION_ANSWER_MAP[17] = 17;

        QUESTIONS[18] = "What is the flag of Belgium?";
        QUESTION_ANSWER_MAP[18] = 18;

        QUESTIONS[19] = "What is the flag of Bosnia & Herzegovina?";
        QUESTION_ANSWER_MAP[19] = 19;

        QUESTIONS[20] = "What is the flag of Brunei?";
        QUESTION_ANSWER_MAP[20] = 20;

        QUESTIONS[21] = "What is the flag of Bhutan?";
        QUESTION_ANSWER_MAP[21] = 21;

        QUESTIONS[22] = "What is the flag of South Korea?";
        QUESTION_ANSWER_MAP[22] = 22;

        QUESTIONS[23] = "What is the flag of China?";
        QUESTION_ANSWER_MAP[23] = 23;

        QUESTIONS[24] = "What is the flag of India?";
        QUESTION_ANSWER_MAP[24] = 24;

        QUESTIONS[25] = "What is the flag of Bulgaria?";
        QUESTION_ANSWER_MAP[25] = 26;

        QUESTIONS[26] = "What is the flag of Cambodia?";
        QUESTION_ANSWER_MAP[26] = 27;

        QUESTIONS[27] = "What is the flag of Croatia?";
        QUESTION_ANSWER_MAP[27] = 28;

        QUESTIONS[28] = "What is the flag of Cyprus?";
        QUESTION_ANSWER_MAP[28] = 29;

        QUESTIONS[29] = "What is the flag of the Czech Republic?";
        QUESTION_ANSWER_MAP[29] = 30;

        QUESTIONS[30] = "What is the flag of Denmark?";
        QUESTION_ANSWER_MAP[30] = 31;

        QUESTIONS[31] = "What is the flag of East Timor?";
        QUESTION_ANSWER_MAP[31] = 32;

        QUESTIONS[32] = "What is the flag of Estonia?";
        QUESTION_ANSWER_MAP[32] = 33;

        QUESTIONS[33] = "What is the flag of Finland?";
        QUESTION_ANSWER_MAP[33] = 34;

        QUESTIONS[34] = "What is the flag of France?";
        QUESTION_ANSWER_MAP[34] = 35;

        QUESTIONS[35] = "What is the flag of Georgia?";
        QUESTION_ANSWER_MAP[35] = 36;

        QUESTIONS[36] = "What is the flag of Germany?";
        QUESTION_ANSWER_MAP[36] = 37;

        QUESTIONS[37] = "What is the flag of Hong Kong?";
        QUESTION_ANSWER_MAP[37] = 38;

        QUESTIONS[38] = "What is the flag of Iceland?";
        QUESTION_ANSWER_MAP[38] = 39;

        QUESTIONS[39] = "What is the flag of Iran?";
        QUESTION_ANSWER_MAP[39] = 40;

        QUESTIONS[40] = "What is the flag of Iraq?";
        QUESTION_ANSWER_MAP[40] = 41;

        QUESTIONS[41] = "What is the flag of Ireland?";
        QUESTION_ANSWER_MAP[41] = 42;

        QUESTIONS[42] = "What is the flag of Israel?";
        QUESTION_ANSWER_MAP[42] = 43;

        QUESTIONS[43] = "What is the flag of Kazakhstan?";
        QUESTION_ANSWER_MAP[43] = 45;

        QUESTIONS[44] = "What is the flag of Kosovo?";
        QUESTION_ANSWER_MAP[44] = 46;

        QUESTIONS[45] = "What is the flag of Kuwait?";
        QUESTION_ANSWER_MAP[45] = 47;

        QUESTIONS[46] = "What is the flag of Kyrgyzstan?";
        QUESTION_ANSWER_MAP[46] = 48;

        QUESTIONS[47] = "What is the flag of Laos?";
        QUESTION_ANSWER_MAP[47] = 49;

        QUESTIONS[48] = "What is the flag of Latvia?";
        QUESTION_ANSWER_MAP[48] = 50;

        QUESTIONS[49] = "What is the flag of Lebanon?";
        QUESTION_ANSWER_MAP[49] = 51;

        QUESTIONS[50] = "What is the flag of Lichtenstein?";
        QUESTION_ANSWER_MAP[50] = 52;

        QUESTIONS[51] = "What is the flag of Lithuania?";
        QUESTION_ANSWER_MAP[51] = 53;

        QUESTIONS[52] = "What is the flag of Luxemburg?";
        QUESTION_ANSWER_MAP[52] = 54;

        QUESTIONS[53] = "What is the flag of Macau?";
        QUESTION_ANSWER_MAP[53] = 55;

        QUESTIONS[54] = "What is the flag of Macedonia?";
        QUESTION_ANSWER_MAP[54] = 56;

        QUESTIONS[55] = "What is the flag of Malaysia?";
        QUESTION_ANSWER_MAP[55] = 57;

        QUESTIONS[56] = "What is the flag of Maldives?";
        QUESTION_ANSWER_MAP[56] = 58;

        QUESTIONS[57] = "What is the flag of Malta?";
        QUESTION_ANSWER_MAP[57] = 59;

        QUESTIONS[58] = "What is the flag of Moldova?";
        QUESTION_ANSWER_MAP[58] = 60;

        QUESTIONS[59] = "What is the flag of Mongolia?";
        QUESTION_ANSWER_MAP[59] = 61;

        QUESTIONS[60] = "What is the flag of Montenegro?";
        QUESTION_ANSWER_MAP[60] = 62;

        QUESTIONS[61] = "What is the flag of Myanmar?";
        QUESTION_ANSWER_MAP[61] = 63;

        QUESTIONS[62] = "What is the flag of Nepal?";
        QUESTION_ANSWER_MAP[62] = 64;

        QUESTIONS[63] = "What is the flag of Netherlands?";
        QUESTION_ANSWER_MAP[63] = 65;

        QUESTIONS[64] = "What is the flag of North Korea?";
        QUESTION_ANSWER_MAP[64] = 66;

        QUESTIONS[65] = "What is the flag of Norway?";
        QUESTION_ANSWER_MAP[65] = 67;

        QUESTIONS[66] = "What is the flag of Oman?";
        QUESTION_ANSWER_MAP[66] = 68;

        QUESTIONS[67] = "What is the flag of Pakistan?";
        QUESTION_ANSWER_MAP[67] = 69;

        QUESTIONS[68] = "What is the flag of Palestine?";
        QUESTION_ANSWER_MAP[68] = 70;

        QUESTIONS[69] = "What is the flag of Philippines?";
        QUESTION_ANSWER_MAP[69] = 71;

        QUESTIONS[70] = "What is the flag of Portugal?";
        QUESTION_ANSWER_MAP[70] = 72;

        QUESTIONS[71] = "What is the flag of Qatar?";
        QUESTION_ANSWER_MAP[71] = 73;

        QUESTIONS[72] = "What is the flag of San Marino?";
        QUESTION_ANSWER_MAP[72] = 74;

        QUESTIONS[73] = "What is the flag of Saudi Arabia?";
        QUESTION_ANSWER_MAP[73] = 75;

        QUESTIONS[74] = "What is the flag of Serbia?";
        QUESTION_ANSWER_MAP[74] = 76;

        QUESTIONS[75] = "What is the flag of the 2nd most populated country in the world?";
        QUESTION_ANSWER_MAP[75] = 24;

        QUESTIONS[76] = "What is the flag of Slovakia?";
        QUESTION_ANSWER_MAP[76] = 78;

        QUESTIONS[77] = "What is the flag of Slovenia?";
        QUESTION_ANSWER_MAP[77] = 79;

        QUESTIONS[78] = "What is the flag of Spain?";
        QUESTION_ANSWER_MAP[78] = 80;

        QUESTIONS[79] = "What is the flag of Sri Lanka?";
        QUESTION_ANSWER_MAP[79] = 81;

        QUESTIONS[80] = "What is the flag of Sweden?";
        QUESTION_ANSWER_MAP[80] = 82;

        QUESTIONS[81] = "What is the flag of Switzerland?";
        QUESTION_ANSWER_MAP[81] = 83;

        QUESTIONS[82] = "What is the flag of Syria?";
        QUESTION_ANSWER_MAP[82] = 84;

        QUESTIONS[83] = "What is the flag of Taiwan?";
        QUESTION_ANSWER_MAP[83] = 85;

        QUESTIONS[84] = "What is the flag of Tajikistan?";
        QUESTION_ANSWER_MAP[84] = 86;

        QUESTIONS[85] = "What is the flag of Thailand?";
        QUESTION_ANSWER_MAP[85] = 87;

        QUESTIONS[86] = "What is the flag of Turkey?";
        QUESTION_ANSWER_MAP[86] = 88;

        QUESTIONS[87] = "What is the flag of Turkmenistan?";
        QUESTION_ANSWER_MAP[87] = 89;

        QUESTIONS[88] = "What is the flag of the United Arab Emirates?";
        QUESTION_ANSWER_MAP[88] = 90;

        QUESTIONS[89] = "What is the flag of the United Kingdom?";
        QUESTION_ANSWER_MAP[89] = 91;

        QUESTIONS[90] = "What is the flag of Uzbekistan?";
        QUESTION_ANSWER_MAP[90] = 92;

        QUESTIONS[91] = "What is the flag of Vatican?";
        QUESTION_ANSWER_MAP[91] = 93;

        QUESTIONS[92] = "What is the flag of Vietnam?";
        QUESTION_ANSWER_MAP[92] = 25;

        QUESTIONS[93] = "What is the flag of Yemen?";
        QUESTION_ANSWER_MAP[93] = 77;

        QUESTIONS[94] = "What is the flag of the country that has the capital at Bucharest?";
        QUESTION_ANSWER_MAP[94] = 0;

        QUESTIONS[95] = "What is the flag of the country that has the capital at Moscow?";
        QUESTION_ANSWER_MAP[95] = 1;

        QUESTIONS[96] = "What is the flag of the country that has the capital at Jakarta?";
        QUESTION_ANSWER_MAP[96] = 2;

        QUESTIONS[97] = "What is the flag of the country that has the capital at Kiev?";
        QUESTION_ANSWER_MAP[97] = 3;

        QUESTIONS[98] = "What is the flag of the country that has the capital at Warsaw?";
        QUESTION_ANSWER_MAP[98] = 4;

        QUESTIONS[99] = "What is the flag of the country that has the capital at Rome?";
        QUESTION_ANSWER_MAP[99] = 5;

        QUESTIONS[100] = "What is the flag of the country that has the capital at Budapest?";
        QUESTION_ANSWER_MAP[100] = 6;

        QUESTIONS[101] = "What is the flag of the country that has the capital at Athens?";
        QUESTION_ANSWER_MAP[101] = 7;

        QUESTIONS[102] = "What is the flag of the country that has the capital at Tokyo?";
        QUESTION_ANSWER_MAP[102] = 8;

        QUESTIONS[103] = "What is the flag of the country that has the capital at Kabul?";
        QUESTION_ANSWER_MAP[103] = 9;

        QUESTIONS[104] = "What is the flag of the country that has the capital at Tirana?";
        QUESTION_ANSWER_MAP[104] = 10;

        QUESTIONS[105] = "What is the flag of the country that has the capital at Sarajevo?";
        QUESTION_ANSWER_MAP[105] = 19;

        QUESTIONS[106] = "What is the flag of the country that has the capital at Reykjavik?";
        QUESTION_ANSWER_MAP[106] = 39;

        QUESTIONS[107] = "What is the flag of the country that has the capital at Vilnius?";
        QUESTION_ANSWER_MAP[107] = 53;

        QUESTIONS[108] = "What is the flag of the country that has the capital at Riga?";
        QUESTION_ANSWER_MAP[108] = 50;

        QUESTIONS[109] = "What is the flag of the country that has the capital at Chisinau?";
        QUESTION_ANSWER_MAP[109] = 60;

        QUESTIONS[110] = "What is the flag of the country that has the capital at Thimpu?";
        QUESTION_ANSWER_MAP[110] = 21;

        QUESTIONS[111] = "What is the flag of the country that has the capital at Dhaka?";
        QUESTION_ANSWER_MAP[111] = 16;

        QUESTIONS[112] = "What is the flag of the country that has the capital at Tbilisi?";
        QUESTION_ANSWER_MAP[112] = 36;

        QUESTIONS[113] = "What is the flag of the country that has the capital at Belgrade?";
        QUESTION_ANSWER_MAP[113] = 76;

        QUESTIONS[114] = "What is the flag of the country that has the capital at Yerevan?";
        QUESTION_ANSWER_MAP[114] = 12;

        QUESTIONS[115] = "What is the flag of the country that has the capital at Brussels?";
        QUESTION_ANSWER_MAP[115] = 18;

        QUESTIONS[116] = "What is the flag of the country that has the capital at Tehran?";
        QUESTION_ANSWER_MAP[116] = 40;

        QUESTIONS[117] = "What is the flag of the country that has the capital at Baghdad?";
        QUESTION_ANSWER_MAP[117] = 41;

        QUESTIONS[118] = "What is the flag of the country that has the capital at Bandar Seri Begawan?";
        QUESTION_ANSWER_MAP[118] = 20;

        QUESTIONS[119] = "What is the flag of the country that has the capital at Ankara?";
        QUESTION_ANSWER_MAP[119] = 88;

        QUESTIONS[120] = "What is the flag of the only Romance country in Eastern Europe?";
        QUESTION_ANSWER_MAP[120] = 0;

        QUESTIONS[121] = "What is the flag of the country that has the largest administrative building in the world?";
        QUESTION_ANSWER_MAP[121] = 0;

        QUESTIONS[122] = "What is the flag of the country that has the largest brown bear population in Europe?";
        QUESTION_ANSWER_MAP[122] = 0;

        QUESTIONS[123] = "What is the flag of the country that has the largest rock sculpture in Europe?";
        QUESTION_ANSWER_MAP[123] = 0;

        QUESTIONS[124] = "What is the flag of the country that has the longest railway in the world?";
        QUESTION_ANSWER_MAP[124] = 1;

        QUESTIONS[125] = "What is the flag of the largest country in the world by area?";
        QUESTION_ANSWER_MAP[125] = 1;

        QUESTIONS[126] = "What is the flag of the smallest country by area in Europe?";
        QUESTION_ANSWER_MAP[126] = 93;

        QUESTIONS[127] = "What is the flag of the smallest country by area in Asia?";
        QUESTION_ANSWER_MAP[127] = 58;

        QUESTIONS[128] = "What is the flag of the most populated country in Asia?";
        QUESTION_ANSWER_MAP[128] = 23;

        QUESTIONS[129] = "What is the flag of the least populated country in Asia?";
        QUESTION_ANSWER_MAP[129] = 58;

        QUESTIONS[130] = "What is the flag of Jordan?";
        QUESTION_ANSWER_MAP[130] = 44;

        //storing the names of the png files in the FLAGS array
        FLAGS[0] = "romania";
        FLAGS[1] = "russia";
        FLAGS[2] = "indonesia";
        FLAGS[3] = "ukraine";
        FLAGS[4] = "poland";
        FLAGS[5] = "italy";
        FLAGS[6] = "hungary";
        FLAGS[7] = "greece";
        FLAGS[8] = "japan";
        FLAGS[9] = "afghanistan";
        FLAGS[10] = "albania";
        FLAGS[11] = "andorra";
        FLAGS[12] = "armenia";
        FLAGS[13] = "austria";
        FLAGS[14] = "azerbaijan";
        FLAGS[15] = "bahrain";
        FLAGS[16] = "bangladesh";
        FLAGS[17] = "belarus";
        FLAGS[18] = "belgium";
        FLAGS[19] = "bosnia_and_herzegovina";
        FLAGS[20] = "brunei";
        FLAGS[21] = "bhutan";
        FLAGS[22] = "south_korea";
        FLAGS[23] = "china";
        FLAGS[24] = "india";
        FLAGS[25] = "vietnam";
        FLAGS[26] = "bulgaria";
        FLAGS[27] = "cambodia";
        FLAGS[28] = "croatia";
        FLAGS[29] = "cyprus";
        FLAGS[30] = "czech_republic";
        FLAGS[31] = "denmark";
        FLAGS[32] = "east_timor";
        FLAGS[33] = "estonia";
        FLAGS[34] = "finland";
        FLAGS[35] = "france";
        FLAGS[36] = "georgia";
        FLAGS[37] = "germany";
        FLAGS[38] = "hong_kong";
        FLAGS[39] = "iceland";
        FLAGS[40] = "iran";
        FLAGS[41] = "iraq";
        FLAGS[42] = "ireland";
        FLAGS[43] = "israel";
        FLAGS[44] = "jordan";
        FLAGS[45] = "kazakhstan";
        FLAGS[46] = "kosovo";
        FLAGS[47] = "kuwait";
        FLAGS[48] = "kyrgyzstan";
        FLAGS[49] = "laos";
        FLAGS[50] = "latvia";
        FLAGS[51] = "lebanon";
        FLAGS[52] = "lichtenstein";
        FLAGS[53] = "lithuania";
        FLAGS[54] = "luxemburg";
        FLAGS[55] = "macau";
        FLAGS[56] = "macedonia";
        FLAGS[57] = "malaysia";
        FLAGS[58] = "maldives";
        FLAGS[59] = "malta";
        FLAGS[60] = "moldova";
        FLAGS[61] = "mongolia";
        FLAGS[62] = "montenegro";
        FLAGS[63] = "myanmar";
        FLAGS[64] = "nepal";
        FLAGS[65] = "netherlands";
        FLAGS[66] = "north_korea";
        FLAGS[67] = "norway";
        FLAGS[68] = "oman";
        FLAGS[69] = "pakistan";
        FLAGS[70] = "palestine";
        FLAGS[71] = "philippines";
        FLAGS[72] = "portugal";
        FLAGS[73] = "qatar";
        FLAGS[74] = "san_marino";
        FLAGS[75] = "saudi_arabia";
        FLAGS[76] = "serbia";
        FLAGS[77] = "yemen";
        FLAGS[78] = "slovakia";
        FLAGS[79] = "slovenia";
        FLAGS[80] = "spain";
        FLAGS[81] = "sri_lanka";
        FLAGS[82] = "sweden";
        FLAGS[83] = "switzerland";
        FLAGS[84] = "syria";
        FLAGS[85] = "taiwan";
        FLAGS[86] = "tajikistan";
        FLAGS[87] = "thailand";
        FLAGS[88] = "turkey";
        FLAGS[89] = "turkmenistan";
        FLAGS[90] = "united_arab_emirates";
        FLAGS[91] = "united_kingdom";
        FLAGS[92] = "uzbekistan";
        FLAGS[93] = "vatican_city";

    }

    /**
     * Method used to get the instance of the singleton class.
     *
     * @return The only object created from this singleton class.
     */
    public static QuestionDatabase getInstance() {
        return INSTANCE;
    }

    /**
     * Method used to get a random question ID.
     * The number is generated by the RandomNumberGenerator.
     *
     * @return A random question ID.
     */
    public int getRandomQuestionId() {
        return GENERATOR.generateRandomQuestionId();
    }

    /**
     * Gets the correct flag ID for a specific question, plus other randomly generated flag IDs.
     *
     * @param questionNr The question for which we need the flags.
     * @return An array list of flags that represents the options for this question.
     */
    public ArrayList<Integer> getFlagIndexesArrayList(Integer questionNr) {

        ArrayList<Integer> flagIndexes = new ArrayList<>();
        //add the correct flag ID for this question
        flagIndexes.add(QUESTION_ANSWER_MAP[questionNr]);
        int number;

        //loop until we have NR_OF_OPTIONS unique options in the array list
        do {
            number = GENERATOR.generateRandomFlagId();
            //if the generated flag ID is unique, add it to the array list
            if (isUnique(flagIndexes, number)) {
                flagIndexes.add(number);
            }
        } while (flagIndexes.size() != NR_OF_OPTIONS);

        //shuffle the array list, so that we won't always have
        //the correct option on the first element of the array list
        Collections.shuffle(flagIndexes);
        return flagIndexes;
    }

    /**
     * Method that checks if a number exists in an array list.
     *
     * @param list   The list of numbers.
     * @param number The number we are checking.
     * @return True if that number doesn't exist in the array list. Otherwise, false.
     */
    private boolean isUnique(ArrayList<Integer> list, int number) {
        for (int e : list) {
            if (e == number) {
                return false;
            }
        }
        return true;
    }

}
