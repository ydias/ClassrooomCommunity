package com.example.yann.classroom_community;

public class Questions {

    private static String mQuestions[] = {
            "Test : la réponse A est la bonne",
            "Lequel de ces groupes n'était pas actif dans les années 60?",
            "Lequel n'est pas un instrument a cordes ?",
            "J'ai pas d'idée de question, donc clique sur D..."
    };

    private static String mChoices[][] = {
            {"A","B","C","D"},
            {"Pink Floyd","AC/DC","Black Sabbath","Genesis"},
            {"Harpe","Violon","Flute","Guitare"},
            {"A","B","C","D"}

    };
    private static String mCorrectAnswers[] = {
            "A",
            "AC/DC",
            "Flute",
            "D"
    };
    public static String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }
    public static String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }
    public static String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }
    public static String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }
    public static String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }
    public static String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
