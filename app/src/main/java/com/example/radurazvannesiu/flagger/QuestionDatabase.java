package com.example.radurazvannesiu.flagger;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Radu & Razvan Nesiu on 1/17/2016.
 */
public class QuestionDatabase {

    public static final int NR_OF_QUESTIONS = 131;
    public static final int NR_OF_FLAGS = 94;
    public static final String[] QUESTIONS = new String[NR_OF_QUESTIONS];
    public static final String[] FLAGS = new String[NR_OF_FLAGS];
    public static final int[] ANSWER_MAP = new int[NR_OF_QUESTIONS];
    private static QuestionDatabase instance = new QuestionDatabase();
    private RandomNumberGenerator generator = RandomNumberGenerator.getInstance();

    private QuestionDatabase() {
        QUESTIONS[0] = "What is the flag of Romania?";
        ANSWER_MAP[0] = 0;

        QUESTIONS[1] = "What is the flag of Russia?";
        ANSWER_MAP[1] = 1;

        QUESTIONS[2] = "What is the flag of Indonesia?";
        ANSWER_MAP[2] = 2;

        QUESTIONS[3] = "What is the flag of Ukraine?";
        ANSWER_MAP[3] = 3;

        QUESTIONS[4] = "What is the flag of Poland?";
        ANSWER_MAP[4] = 4;

        QUESTIONS[5] = "What is the flag of Italy?";
        ANSWER_MAP[5] = 5;

        QUESTIONS[6] = "What is the flag of Hungary?";
        ANSWER_MAP[6] = 6;

        QUESTIONS[7] = "What is the flag of Greece?";
        ANSWER_MAP[7] = 7;

        QUESTIONS[8] = "What is the flag of Japan?";
        ANSWER_MAP[8] = 8;

        QUESTIONS[9] = "What is the flag of Afghanistan?";
        ANSWER_MAP[9] = 9;

        QUESTIONS[10] = "What is the flag of Albania?";
        ANSWER_MAP[10] = 10;

        QUESTIONS[11] = "What is the flag of Andorra?";
        ANSWER_MAP[11] = 11;

        QUESTIONS[12] = "What is the flag of Armenia?";
        ANSWER_MAP[12] = 12;

        QUESTIONS[13] = "What is the flag of Austria?";
        ANSWER_MAP[13] = 13;

        QUESTIONS[14] = "What is the flag of Azerbaijan?";
        ANSWER_MAP[14] = 14;

        QUESTIONS[15] = "What is the flag of Bahrain?";
        ANSWER_MAP[15] = 15;

        QUESTIONS[16] = "What is the flag of Bangladesh?";
        ANSWER_MAP[16] = 16;

        QUESTIONS[17] = "What is the flag of Belarus?";
        ANSWER_MAP[17] = 17;

        QUESTIONS[18] = "What is the flag of Belgium?";
        ANSWER_MAP[18] = 18;

        QUESTIONS[19] = "What is the flag of Bosnia & Herzegovina?";
        ANSWER_MAP[19] = 19;

        QUESTIONS[20] = "What is the flag of Brunei?";
        ANSWER_MAP[20] = 20;

        QUESTIONS[21] = "What is the flag of Bhutan?";
        ANSWER_MAP[21] = 21;

        QUESTIONS[22] = "What is the flag of South Korea?";
        ANSWER_MAP[22] = 22;

        QUESTIONS[23] = "What is the flag of China?";
        ANSWER_MAP[23] = 23;

        QUESTIONS[24] = "What is the flag of India?";
        ANSWER_MAP[24] = 24;

        QUESTIONS[25] = "What is the flag of Bulgaria?";
        ANSWER_MAP[25] = 26;

        QUESTIONS[26] = "What is the flag of Cambodia?";
        ANSWER_MAP[26] = 27;

        QUESTIONS[27] = "What is the flag of Croatia?";
        ANSWER_MAP[27] = 28;

        QUESTIONS[28] = "What is the flag of Cyprus?";
        ANSWER_MAP[28] = 29;

        QUESTIONS[29] = "What is the flag of the Czech Republic?";
        ANSWER_MAP[29] = 30;

        QUESTIONS[30] = "What is the flag of Denmark?";
        ANSWER_MAP[30] = 31;

        QUESTIONS[31] = "What is the flag of East Timor?";
        ANSWER_MAP[31] = 32;

        QUESTIONS[32] = "What is the flag of Estonia?";
        ANSWER_MAP[32] = 33;

        QUESTIONS[33] = "What is the flag of Finland?";
        ANSWER_MAP[33] = 34;

        QUESTIONS[34] = "What is the flag of France?";
        ANSWER_MAP[34] = 35;

        QUESTIONS[35] = "What is the flag of Georgia?";
        ANSWER_MAP[35] = 36;

        QUESTIONS[36] = "What is the flag of Germany?";
        ANSWER_MAP[36] = 37;

        QUESTIONS[37] = "What is the flag of Hong Kong?";
        ANSWER_MAP[37] = 38;

        QUESTIONS[38] = "What is the flag of Iceland?";
        ANSWER_MAP[38] = 39;

        QUESTIONS[39] = "What is the flag of Iran?";
        ANSWER_MAP[39] = 40;

        QUESTIONS[40] = "What is the flag of Iraq?";
        ANSWER_MAP[40] = 41;

        QUESTIONS[41] = "What is the flag of Ireland?";
        ANSWER_MAP[41] = 42;

        QUESTIONS[42] = "What is the flag of Israel?";
        ANSWER_MAP[42] = 43;

        QUESTIONS[43] = "What is the flag of Kazakhstan?";
        ANSWER_MAP[43] = 45;

        QUESTIONS[44] = "What is the flag of Kosovo?";
        ANSWER_MAP[44] = 46;

        QUESTIONS[45] = "What is the flag of Kuwait?";
        ANSWER_MAP[45] = 47;

        QUESTIONS[46] = "What is the flag of Kyrgyzstan?";
        ANSWER_MAP[46] = 48;

        QUESTIONS[47] = "What is the flag of Laos?";
        ANSWER_MAP[47] = 49;

        QUESTIONS[48] = "What is the flag of Latvia?";
        ANSWER_MAP[48] = 50;

        QUESTIONS[49] = "What is the flag of Lebanon?";
        ANSWER_MAP[49] = 51;

        QUESTIONS[50] = "What is the flag of Lichtenstein?";
        ANSWER_MAP[50] = 52;

        QUESTIONS[51] = "What is the flag of Lithuania?";
        ANSWER_MAP[51] = 53;

        QUESTIONS[52] = "What is the flag of Luxemburg?";
        ANSWER_MAP[52] = 54;

        QUESTIONS[53] = "What is the flag of Macau?";
        ANSWER_MAP[53] = 55;

        QUESTIONS[54] = "What is the flag of Macedonia?";
        ANSWER_MAP[54] = 56;

        QUESTIONS[55] = "What is the flag of Malaysia?";
        ANSWER_MAP[55] = 57;

        QUESTIONS[56] = "What is the flag of Maldives?";
        ANSWER_MAP[56] = 58;

        QUESTIONS[57] = "What is the flag of Malta?";
        ANSWER_MAP[57] = 59;

        QUESTIONS[58] = "What is the flag of Moldova?";
        ANSWER_MAP[58] = 60;

        QUESTIONS[59] = "What is the flag of Mongolia?";
        ANSWER_MAP[59] = 61;

        QUESTIONS[60] = "What is the flag of Montenegro?";
        ANSWER_MAP[60] = 62;

        QUESTIONS[61] = "What is the flag of Myanmar?";
        ANSWER_MAP[61] = 63;

        QUESTIONS[62] = "What is the flag of Nepal?";
        ANSWER_MAP[62] = 64;

        QUESTIONS[63] = "What is the flag of Netherlands?";
        ANSWER_MAP[63] = 65;

        QUESTIONS[64] = "What is the flag of North Korea?";
        ANSWER_MAP[64] = 66;

        QUESTIONS[65] = "What is the flag of Norway?";
        ANSWER_MAP[65] = 67;

        QUESTIONS[66] = "What is the flag of Oman?";
        ANSWER_MAP[66] = 68;

        QUESTIONS[67] = "What is the flag of Pakistan?";
        ANSWER_MAP[67] = 69;

        QUESTIONS[68] = "What is the flag of Palestine?";
        ANSWER_MAP[68] = 70;

        QUESTIONS[69] = "What is the flag of Philippines?";
        ANSWER_MAP[69] = 71;

        QUESTIONS[70] = "What is the flag of Portugal?";
        ANSWER_MAP[70] = 72;

        QUESTIONS[71] = "What is the flag of Qatar?";
        ANSWER_MAP[71] = 73;

        QUESTIONS[72] = "What is the flag of San Marino?";
        ANSWER_MAP[72] = 74;

        QUESTIONS[73] = "What is the flag of Saudi Arabia?";
        ANSWER_MAP[73] = 75;

        QUESTIONS[74] = "What is the flag of Serbia?";
        ANSWER_MAP[74] = 76;

        QUESTIONS[75] = "What is the flag of the 2nd most populated country in the world?";
        ANSWER_MAP[75] = 24;

        QUESTIONS[76] = "What is the flag of Slovakia?";
        ANSWER_MAP[76] = 78;

        QUESTIONS[77] = "What is the flag of Slovenia?";
        ANSWER_MAP[77] = 79;

        QUESTIONS[78] = "What is the flag of Spain?";
        ANSWER_MAP[78] = 80;

        QUESTIONS[79] = "What is the flag of Sri Lanka?";
        ANSWER_MAP[79] = 81;

        QUESTIONS[80] = "What is the flag of Sweden?";
        ANSWER_MAP[80] = 82;

        QUESTIONS[81] = "What is the flag of Switzerland?";
        ANSWER_MAP[81] = 83;

        QUESTIONS[82] = "What is the flag of Syria?";
        ANSWER_MAP[82] = 84;

        QUESTIONS[83] = "What is the flag of Taiwan?";
        ANSWER_MAP[83] = 85;

        QUESTIONS[84] = "What is the flag of Tajikistan?";
        ANSWER_MAP[84] = 86;

        QUESTIONS[85] = "What is the flag of Thailand?";
        ANSWER_MAP[85] = 87;

        QUESTIONS[86] = "What is the flag of Turkey?";
        ANSWER_MAP[86] = 88;

        QUESTIONS[87] = "What is the flag of Turkmenistan?";
        ANSWER_MAP[87] = 89;

        QUESTIONS[88] = "What is the flag of the United Arab Emirates?";
        ANSWER_MAP[88] = 90;

        QUESTIONS[89] = "What is the flag of the United Kingdom?";
        ANSWER_MAP[89] = 91;

        QUESTIONS[90] = "What is the flag of Uzbekistan?";
        ANSWER_MAP[90] = 92;

        QUESTIONS[91] = "What is the flag of Vatican?";
        ANSWER_MAP[91] = 93;

        QUESTIONS[92] = "What is the flag of Vietnam?";
        ANSWER_MAP[92] = 25;

        QUESTIONS[93] = "What is the flag of Yemen?";
        ANSWER_MAP[93] = 77;

        QUESTIONS[94] = "What is the flag of the country that has the capital at Bucharest?";
        ANSWER_MAP[94] = 0;

        QUESTIONS[95] = "What is the flag of the country that has the capital at Moscow?";
        ANSWER_MAP[95] = 1;

        QUESTIONS[96] = "What is the flag of the country that has the capital at Jakarta?";
        ANSWER_MAP[96] = 2;

        QUESTIONS[97] = "What is the flag of the country that has the capital at Kiev?";
        ANSWER_MAP[97] = 3;

        QUESTIONS[98] = "What is the flag of the country that has the capital at Warsaw?";
        ANSWER_MAP[98] = 4;

        QUESTIONS[99] = "What is the flag of the country that has the capital at Rome?";
        ANSWER_MAP[99] = 5;

        QUESTIONS[100] = "What is the flag of the country that has the capital at Budapest?";
        ANSWER_MAP[100] = 6;

        QUESTIONS[101] = "What is the flag of the country that has the capital at Athens?";
        ANSWER_MAP[101] = 7;

        QUESTIONS[102] = "What is the flag of the country that has the capital at Tokyo?";
        ANSWER_MAP[102] = 8;

        QUESTIONS[103] = "What is the flag of the country that has the capital at Kabul?";
        ANSWER_MAP[103] = 9;

        QUESTIONS[104] = "What is the flag of the country that has the capital at Tirana?";
        ANSWER_MAP[104] = 10;

        QUESTIONS[105] = "What is the flag of the country that has the capital at Sarajevo?";
        ANSWER_MAP[105] = 19;

        QUESTIONS[106] = "What is the flag of the country that has the capital at Reykjavik?";
        ANSWER_MAP[106] = 39;

        QUESTIONS[107] = "What is the flag of the country that has the capital at Vilnius?";
        ANSWER_MAP[107] = 53;

        QUESTIONS[108] = "What is the flag of the country that has the capital at Riga?";
        ANSWER_MAP[108] = 50;

        QUESTIONS[109] = "What is the flag of the country that has the capital at Chisinau?";
        ANSWER_MAP[109] = 60;

        QUESTIONS[110] = "What is the flag of the country that has the capital at Thimpu?";
        ANSWER_MAP[110] = 21;

        QUESTIONS[111] = "What is the flag of the country that has the capital at Dhaka?";
        ANSWER_MAP[111] = 16;

        QUESTIONS[112] = "What is the flag of the country that has the capital at Tbilisi?";
        ANSWER_MAP[112] = 36;

        QUESTIONS[113] = "What is the flag of the country that has the capital at Belgrade?";
        ANSWER_MAP[113] = 76;

        QUESTIONS[114] = "What is the flag of the country that has the capital at Yerevan?";
        ANSWER_MAP[114] = 12;

        QUESTIONS[115] = "What is the flag of the country that has the capital at Brussels?";
        ANSWER_MAP[115] = 18;

        QUESTIONS[116] = "What is the flag of the country that has the capital at Tehran?";
        ANSWER_MAP[116] = 40;

        QUESTIONS[117] = "What is the flag of the country that has the capital at Baghdad?";
        ANSWER_MAP[117] = 41;

        QUESTIONS[118] = "What is the flag of the country that has the capital at Bandar Seri Begawan?";
        ANSWER_MAP[118] = 20;

        QUESTIONS[119] = "What is the flag of the country that has the capital at Ankara?";
        ANSWER_MAP[119] = 88;

        QUESTIONS[120] = "What is the flag of the only Romance country in Eastern Europe?";
        ANSWER_MAP[120] = 0;

        QUESTIONS[121] = "What is the flag of the country that has the largest administrative building in the world?";
        ANSWER_MAP[121] = 0;

        QUESTIONS[122] = "What is the flag of the country that has the largest brown bear population in Europe?";
        ANSWER_MAP[122] = 0;

        QUESTIONS[123] = "What is the flag of the country that has the largest rock sculpture in Europe?";
        ANSWER_MAP[123] = 0;

        QUESTIONS[124] = "What is the flag of the country that has the longest railway in the world?";
        ANSWER_MAP[124] = 1;

        QUESTIONS[125] = "What is the flag of the largest country in the world by area?";
        ANSWER_MAP[125] = 1;

        QUESTIONS[126] = "What is the flag of the smallest country by area in Europe?";
        ANSWER_MAP[126] = 93;

        QUESTIONS[127] = "What is the flag of the smallest country by area in Asia?";
        ANSWER_MAP[127] = 58;

        QUESTIONS[128] = "What is the flag of the most populated country in Asia?";
        ANSWER_MAP[128] = 23;

        QUESTIONS[129] = "What is the flag of the least populated country in Asia?";
        ANSWER_MAP[129] = 58;

        QUESTIONS[130] = "What is the flag of Jordan?";
        ANSWER_MAP[130] = 44;

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
        FLAGS[19] = "bosniaherzegovina";
        FLAGS[20] = "brunei";
        FLAGS[21] = "bhutan";
        FLAGS[22] = "southkorea";
        FLAGS[23] = "china";
        FLAGS[24] = "india";
        FLAGS[25] = "vietnam";
        FLAGS[26] = "bulgaria";
        FLAGS[27] = "cambodia";
        FLAGS[28] = "croatia";
        FLAGS[29] = "cyprus";
        FLAGS[30] = "czechrepublic";
        FLAGS[31] = "denmark";
        FLAGS[32] = "easttimor";
        FLAGS[33] = "estonia";
        FLAGS[34] = "finland";
        FLAGS[35] = "france";
        FLAGS[36] = "georgia";
        FLAGS[37] = "germany";
        FLAGS[38] = "hongkong";
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
        FLAGS[66] = "northkorea";
        FLAGS[67] = "norway";
        FLAGS[68] = "oman";
        FLAGS[69] = "pakistan";
        FLAGS[70] = "palestine";
        FLAGS[71] = "philippines";
        FLAGS[72] = "portugal";
        FLAGS[73] = "qatar";
        FLAGS[74] = "sanmarino";
        FLAGS[75] = "saudiarabia";
        FLAGS[76] = "serbia";
        FLAGS[77] = "yemen";
        FLAGS[78] = "slovakia";
        FLAGS[79] = "slovenia";
        FLAGS[80] = "spain";
        FLAGS[81] = "srilanka";
        FLAGS[82] = "sweden";
        FLAGS[83] = "switzerland";
        FLAGS[84] = "syria";
        FLAGS[85] = "taiwan";
        FLAGS[86] = "tajikistan";
        FLAGS[87] = "thailand";
        FLAGS[88] = "turkey";
        FLAGS[89] = "turkmenistan";
        FLAGS[90] = "uae";
        FLAGS[91] = "unitedkingdom";
        FLAGS[92] = "uzbekistan";
        FLAGS[93] = "vaticancity";

    }

    public static QuestionDatabase getInstance() {
        return instance;
    }

    public int getRandomQuestion() {
        return generator.generateRandomQNumber();
    }

    public ArrayList<Integer> getFlags(Integer questionNr) {

        ArrayList<Integer> flagIndexes = new ArrayList<Integer>();
        flagIndexes.add(ANSWER_MAP[questionNr]);
        int number;

        do {
            number = generator.generateRandomFNumber();
            if (isUnique(flagIndexes, number)) {
                flagIndexes.add(number);
            }
        } while (flagIndexes.size() != 4);

        Collections.shuffle(flagIndexes);
        return flagIndexes;
    }

    private boolean isUnique(ArrayList<Integer> list, int number) {
        for (int e : list) {
            if (e == number) {
                return false;
            }
        }
        return true;
    }

}
